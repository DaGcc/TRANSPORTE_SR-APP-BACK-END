package com.org.tr.controller;

import com.org.tr.DTO.EntityPageFilterDTO;
import com.org.tr.excepcions.ModelNotFoundException;
import com.org.tr.model.ArchivoOrdenServicio;
import com.org.tr.model.ArchivoOrdenServicio;
import com.org.tr.model.OrdenServicio;
import com.org.tr.model.OrdenServicio;
import com.org.tr.service.IArchivoOrdenServicioService;
import com.org.tr.service.IOrdenServicioService;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/orden-servicios", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrdenServicioController extends CommonController<OrdenServicio, IOrdenServicioService> {
    
    @Autowired
    private IArchivoOrdenServicioService archivoOrdenServicioService;
    

    @DeleteMapping("/detach/{id}")
    public ResponseEntity<?> deleteById(
            @RequestParam(name = "deep", defaultValue = "false") boolean deep,
            @PathVariable("id") int id) {
        //verificamos si existe en la base de datos
        OrdenServicio entityBD = this.service.readById(id);

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
            throw new ModelNotFoundException("Entidad de tipo: " + OrdenServicio.class.getSimpleName() + " con id: " + id + ", no encontrado");
        }

    }

    @GetMapping("/filtro")
    public ResponseEntity<?> filtroOrdenServicios(
            @RequestParam(name = "pageIndex", defaultValue = "0") Integer pageIndex,
            @RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(name = "value", defaultValue = "") String value) {
        EntityPageFilterDTO<OrdenServicio> responsePage = this.service.filtroOrdenServicios(pageIndex, pageSize, value);
        return ResponseEntity.ok(responsePage);
    }

    /**
     * 0 -> estado en false 1 -> estad en true 3 -> ninguna de las antriores
     *
     * @param estado
     * @param pageable
     * @return
     */
    @GetMapping("/detach/paginado")
    public ResponseEntity<?> readPageByStatus(
            @RequestParam(value = "estado", defaultValue = "2") int estado,
            Pageable pageable) {
        switch (estado) {
            case 0, 1 -> {
                boolean s = (estado == 1);
                Page<OrdenServicio> page = this.service.readPageByStatus(s, pageable);
                return ResponseEntity.ok(page);
            }
            default -> {
                return super.readByPage(pageable);
            }
        }
    }

    
    @GetMapping(value = "/archivo-orden/{idOrdenServicio}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<byte[]> buscarArchivoPorIdOrdenServicio(@PathVariable("idOrdenServicio")Integer idOrdenServicio){
        ArchivoOrdenServicio arfBD = this.archivoOrdenServicioService.readArchivoByOrdenServicio(idOrdenServicio);
        
        if(arfBD==null){
            throw new ModelNotFoundException("El OS de id: "+idOrdenServicio+", no cuenta con un archivo.");
        }else {
            return ResponseEntity.ok(arfBD.getData());
        }
    } 
}
