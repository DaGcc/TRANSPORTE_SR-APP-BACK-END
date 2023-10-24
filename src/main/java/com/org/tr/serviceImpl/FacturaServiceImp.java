/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.org.tr.serviceImpl;

import com.org.tr.DTO.EntityPageFilterDTO;
import com.org.tr.DTO.FacturaOrdenFilesDTO;
import com.org.tr.model.Factura;
import com.org.tr.repo.IArchivoFacturaRepo;
import com.org.tr.repo.IArchivoOrdenServicioRepo;
import com.org.tr.repo.IFacturaRepo;
import com.org.tr.service.IFacturaService;
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

}
