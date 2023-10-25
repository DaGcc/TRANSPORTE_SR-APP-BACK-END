/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.org.tr.serviceImpl;

import com.org.tr.DTO.EntityPageFilterDTO;
import com.org.tr.DTO.FacturaOrdenFilesDTO;
import com.org.tr.model.ArchivoFactura;
import com.org.tr.model.ArchivoOrdenServicio;
import com.org.tr.model.Factura;
import com.org.tr.repo.IArchivoFacturaRepo;
import com.org.tr.repo.IArchivoOrdenServicioRepo;
import com.org.tr.repo.IFacturaRepo;
import com.org.tr.service.IFacturaService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FacturaServiceImp extends CommonServiceImpl<Factura, IFacturaRepo> implements IFacturaService {

    @Autowired
    private IArchivoFacturaRepo archivoFacturaRepo;

    @Autowired
    private IArchivoOrdenServicioRepo archivoOrdenServicioRepo;

    @Transactional(readOnly = true)
    @Override
    public EntityPageFilterDTO<Factura> filtroFacturas(Integer pageIndex, Integer pageSize, String filtro) {
        EntityPageFilterDTO<Factura> epf = new EntityPageFilterDTO();
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Page<Factura> readPageByStatus(boolean estado, Pageable pageable) {
        return this.repo.readPageByStatus(estado, pageable);
    }

    //sobrecarga de metodo 
    @Transactional
    @Override
    public Factura create(FacturaOrdenFilesDTO dto) {

        //1. guardamos la factura, internamente tiene el orden de servicio por ende tambien lo guarda en la BD.
        this.repo.save(dto.getFactura());

        if (dto.getArchivoFactura() != null) {
            //2. guardamos el archivo perteneciente a la factura.
            dto.getArchivoFactura().setFactura(dto.getFactura());//dicha factura ya fue creada en la acccion anterior
            this.archivoFacturaRepo.save(dto.getArchivoFactura());//guardamos el archivo de la factura.
        }

        if (dto.getArchivoOrdenServicio() != null) {
            //3. guardamos el archivo perteneciente del orden de servicio.
            dto.getArchivoOrdenServicio().setOrdenServicio(dto.getFactura().getOrdenServicio());//el orden de factura persistira junto con la factura.
            this.archivoOrdenServicioRepo.save(dto.getArchivoOrdenServicio());//guardamos
        }

        return dto.getFactura();
    }

    @Transactional
    @Override
    public Factura update(FacturaOrdenFilesDTO dto) {

        //1. actualizamos la factura, internamente tiene el orden de servicio por ende tambien lo guarda en la BD.
        this.repo.save(dto.getFactura());

        if (dto.getArchivoFactura() != null) {//si es que viene un archivo de factura par aguardar/actualizar
            
            dto.getArchivoFactura().setFactura(dto.getFactura());
            
            //verificamos ademas si esa factura tiene ya un archivo asociado 
            Optional<ArchivoFactura> oFactura = this.archivoFacturaRepo.readArchivoByfactura(dto.getFactura().getIdFactura());
            
            if (oFactura.isPresent()) {//Si es que la factura ya tiene un archivo asociado, solo actualizamos su archivo.
                ArchivoFactura arf = oFactura.get();
                dto.getArchivoFactura().setIdArchivoFactura(arf.getIdArchivoFactura());//seteamos id del archivo de la bd.
            }
            this.archivoFacturaRepo.save(dto.getArchivoFactura());//guardamos/actualizamos el archivo de la factura.

        }

        if (dto.getArchivoOrdenServicio() != null) {//si es que viene un archio para el OS
            //3. seteamos el archivo perteneciente del orden de servicio.
            dto.getArchivoOrdenServicio().setOrdenServicio(dto.getFactura().getOrdenServicio());//el orden de factura persistira junto con la factura.
            
            Optional<ArchivoOrdenServicio> oArchivoOrdenServicio = this.archivoOrdenServicioRepo.readArchivoByOrdenServicio(dto.getFactura().getOrdenServicio().getIdOrdenServicio());
            if(oArchivoOrdenServicio.isPresent()){
               dto.getArchivoOrdenServicio().setIdArchivoOrdenServicio(oArchivoOrdenServicio.get().getIdArchivoOrdenServicio());
            }
            this.archivoOrdenServicioRepo.save(dto.getArchivoOrdenServicio());//guardamos/actualizamos
        }

        return dto.getFactura();
    }

}
