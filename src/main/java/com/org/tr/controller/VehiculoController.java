package com.org.tr.controller;

import com.org.tr.DTO.EntityPageFilterDTO;
import com.org.tr.excepcions.ModelNotFoundException;
import com.org.tr.model.Vehiculo;
import com.org.tr.service.IVehiculoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/vehiculos", produces = MediaType.APPLICATION_JSON_VALUE)
public class VehiculoController extends CommonController<Vehiculo, IVehiculoService> {

    @DeleteMapping("/detach/{id}")
    public ResponseEntity<?> deleteById(
            @RequestParam(name = "deep", defaultValue = "false") boolean deep,
            @PathVariable("id") int id) {
        //verificamos si existe en la base de datos
        Vehiculo entityBD = this.service.readById(id);

        //si existe
        if (entityBD != null) {

            //vemos si es una eliminacion profunda 
            if (deep == false) {
                //si no lo es, solo cambiaremos el estado a falso y de respuesta sea 204
                entityBD.setEstado(false);
                this.service.update(entityBD);//guardamos esa actualizacion en la bbdd
                return ResponseEntity.noContent().build();// respuesta http_204
            } else {
                //si lo es, elimminamos ese registro de la base de datos
                return super.deleteById(id);//llamamos al metodo core
            }
        } else {
            //si no existe mandamos la excepcion con estado http 404
            throw new ModelNotFoundException("Entidad de tipo: " + Vehiculo.class.getSimpleName() + " con id: " + id + ", no encontrado");
        }

    }

    @GetMapping("/filtro")
    public ResponseEntity<?> filtroVehiculos(
            @RequestParam(name = "pageIndex", defaultValue = "0") Integer pageIndex,
            @RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(name = "value", defaultValue = "") String value) {
        EntityPageFilterDTO<Vehiculo> responsePage = this.service.filtroVehiculos(pageIndex, pageSize, value);
        return ResponseEntity.ok(responsePage);
    }

    
    /**
     * 0 -> estado en false
     * 1 -> estad en true
     * 3 -> ninguna de las antriores
     * @param estado
     * @param pageable
     * @return 
     */
    @GetMapping("/detach/paginado")
    public ResponseEntity<?> readPageByStatus(
            @RequestParam(value = "estado", defaultValue = "2") int estado,
            Pageable pageable) {
        switch (estado){
            case 0, 1 -> {
                boolean s = (estado == 1); 
                Page<Vehiculo> page = this.service.readPageByStatus(s,pageable);
                return ResponseEntity.ok(page);
            }
            default -> {
                return super.readByPage(pageable);
            }
        }
    }
    

    
}
