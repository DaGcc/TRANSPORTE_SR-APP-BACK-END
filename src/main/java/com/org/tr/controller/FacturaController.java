package com.org.tr.controller;

import com.org.tr.DTO.EntityPageFilterDTO;
import com.org.tr.DTO.FacturaOrdenFilesDTO;
import com.org.tr.DTO.FacturaOrdenServicioDTO;
import com.org.tr.excepcions.ModelNotFoundException;
import com.org.tr.model.ArchivoFactura;
import com.org.tr.model.ArchivoOrdenServicio;
import com.org.tr.model.Factura;
import com.org.tr.model.OrdenServicio;
import com.org.tr.service.IArchivoFacturaService;
import com.org.tr.service.IFacturaService;
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
@RequestMapping(value = "/facturas", produces = MediaType.APPLICATION_JSON_VALUE)
public class FacturaController extends CommonController<Factura, IFacturaService> {
    
    @Autowired
    private IArchivoFacturaService archivoFacturaService;

    //problema de recibirlo asi, e que las validaciones de los atributos no estaran activadas 
    //@RequestParam("codigoFactura") String codigoFactura,
    //@RequestParam("fechaFactura") String fechaFactura,
    //@RequestParam("estadoFactura") boolean estadoFactura,
    //@RequestParam("codigoOrden") String codigoOrden,
    //@RequestParam("fechaOrden") String fechaOrden,
    //@RequestParam("estadoOrden") boolean estadoOrden
    @PostMapping(value = "/detach", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> create(
            @RequestParam("fileFactura") MultipartFile fileFactura,
            @RequestParam("fileOrdenServicio") MultipartFile fileOrdenServicio,
            @Valid @ModelAttribute FacturaOrdenServicioDTO dto) throws IOException, DateTimeParseException {

        Factura fa = new Factura();
        fa.setCodigoFactura(dto.getCodigoFactura());
        fa.setFecha(LocalDateTime.now());
        fa.setEstado(dto.isEstadoFactura());

        OrdenServicio ors = new OrdenServicio();
        ors.setCodigoOrden(dto.getCodigoOrden());
        ors.setFecha(LocalDateTime.now());
        ors.setEstado(dto.isEstadoOrden());

        fa.setOrdenServicio(ors);

        //Otra forma de controlar excepciones
        /*
        if (dto.getCodigoOrden().isEmpty()) {
            Map<String, Object> response = new HashMap();
            response.put("mensaje", "Falta el orden de servicio para emitir la factura.");
            return ResponseEntity.badRequest().body(response);// HTTP_404
        } else {
            fa = new Factura();
            fa.setCodigoFactura(codigoFactura);
            fa.setFecha(LocalDateTime.parse(fechaFactura));
            fa.setEstado(estadoFactura);

            ors = new OrdenServicio();
            ors.setCodigoOrden(codigoOrden);
            ors.setEstado(estadoOrden);
            ors.setFecha(LocalDateTime.parse(fechaOrden));
            fa.setOrdenServicio(ors);
        }*/
        ArchivoFactura arf = null;
        //Si viene un archivo para la factura.
        if (!fileFactura.isEmpty()) {
            arf = new ArchivoFactura();//Se inicializa un espacio en memoria si es que se ha mandado el file
            arf.setData(fileFactura.getBytes());
            arf.setNombre(fileFactura.getOriginalFilename());
            arf.setType(fileFactura.getContentType());
        }

        //si viene un archivo para el orden de servicio.
        ArchivoOrdenServicio aro = null;
        if (!fileOrdenServicio.isEmpty()) {
            aro = new ArchivoOrdenServicio();//Se inicializa un espacio en memoria si es que se ha mandado el file
            aro.setData(fileOrdenServicio.getBytes());
            aro.setNombre(fileOrdenServicio.getOriginalFilename());
            aro.setType(fileOrdenServicio.getContentType());
        }

        FacturaOrdenFilesDTO facturaOrdenFilesDTO = new FacturaOrdenFilesDTO(fa, arf, aro);

        this.service.create(facturaOrdenFilesDTO);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/detach/{id}")
    public ResponseEntity<?> deleteById(
            @RequestParam(name = "deep", defaultValue = "false") boolean deep,
            @PathVariable("id") int id) {
        //verificamos si existe en la base de datos
        Factura entityBD = this.service.readById(id);

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
            throw new ModelNotFoundException("Entidad de tipo: " + Factura.class.getSimpleName() + " con id: " + id + ", no encontrado");
        }

    }

    @GetMapping("/filtro")
    public ResponseEntity<?> filtroFacturas(
            @RequestParam(name = "pageIndex", defaultValue = "0") Integer pageIndex,
            @RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(name = "value", defaultValue = "") String value) {
        EntityPageFilterDTO<Factura> responsePage = this.service.filtroFacturas(pageIndex, pageSize, value);
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
                Page<Factura> page = this.service.readPageByStatus(s, pageable);
                return ResponseEntity.ok(page);
            }
            default -> {
                return super.readByPage(pageable);
            }
        }
    }

    
    @GetMapping(value = "/archivo-factura/{idFactura}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<byte[]> buscarArchivoPorIdFactura(@PathVariable("idFactura")Integer idFactura){
        ArchivoFactura arfBD = this.archivoFacturaService.readArchivoByfactura(idFactura);
        
        if(arfBD==null){
            throw new ModelNotFoundException("La factura de id: "+idFactura+", no cuenta con un archivo.");
        }else {
            return ResponseEntity.ok(arfBD.getData());
        }
    } 
}
