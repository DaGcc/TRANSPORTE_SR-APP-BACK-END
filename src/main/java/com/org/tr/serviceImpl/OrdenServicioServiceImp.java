/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.org.tr.serviceImpl;

import com.org.tr.DTO.EntityPageFilterDTO;
import com.org.tr.model.OrdenServicio;
import com.org.tr.repo.IArchivoOrdenServicioRepo;
import com.org.tr.repo.IOrdenServicioRepo;
import com.org.tr.service.IOrdenServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrdenServicioServiceImp extends CommonServiceImpl<OrdenServicio, IOrdenServicioRepo> implements IOrdenServicioService {

    @Autowired
    private IArchivoOrdenServicioRepo archivoOrdenServicioRepo;


    @Transactional(readOnly = true)
    @Override
    public EntityPageFilterDTO<OrdenServicio> filtroOrdenServicios(Integer pageIndex, Integer pageSize, String filtro) {
        EntityPageFilterDTO<OrdenServicio> epf = new EntityPageFilterDTO();
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Page<OrdenServicio> readPageByStatus(boolean estado, Pageable pageable) {
        return this.repo.readPageByStatus(estado, pageable);
    }


}
