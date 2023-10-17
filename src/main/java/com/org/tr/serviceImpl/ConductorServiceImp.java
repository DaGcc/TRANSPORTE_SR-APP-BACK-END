/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.org.tr.serviceImpl;

import com.org.tr.DTO.EntityPageFilterDTO;
import com.org.tr.model.Conductor;
import com.org.tr.model.Genero;
import com.org.tr.repo.IConductorRepo;
import com.org.tr.service.IConductorService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ConductorServiceImp extends CommonServiceImpl<Conductor, IConductorRepo> implements IConductorService {

    @Transactional(readOnly = true)
    @Override
    public EntityPageFilterDTO<Conductor> filtroConductors(Integer pageIndex, Integer pageSize, String filtro) {
        EntityPageFilterDTO<Conductor> epf = new EntityPageFilterDTO();
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Page<Conductor> readPageByStatus(boolean estado,Pageable pageable) {
        return this.repo.readPageByStatus(estado,pageable);
    }

}
