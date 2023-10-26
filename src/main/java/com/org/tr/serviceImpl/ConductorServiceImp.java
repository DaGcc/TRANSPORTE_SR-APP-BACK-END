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
import java.util.stream.Collector;
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
        
        List<Conductor> content = this.repo.filtroConductors(pageIndex, pageSize, filtro)
                .stream().map(obj -> {
                    Conductor c = new Conductor();
                    c.setIdConductor(Integer.parseInt(obj[0].toString()));
                    c.setEmail(obj[1].toString());
                    c.setNombres(obj[2].toString());
                    c.setTelefono(obj[3].toString());
                    c.setEstado(Boolean.parseBoolean(obj[4].toString()));
                    c.setApellidoMaterno(obj[5].toString());
                    c.setApellidoPaterno(obj[6].toString());
                    c.setDni(obj[7].toString());
                    c.setEdad(obj[8].toString());
                    c.setFoto(null);//????

                    Genero g = new Genero();
                    g.setIdGenero(Integer.parseInt(obj[10].toString()));
                    g.setTipo(obj[11].toString());
                    c.setGenero(g);
                    
                    

                    //PARA LA PROPEIDAD DE PAGINACION 
                    epf.setTotalElements(Integer.parseInt(obj[12].toString()));
                    epf.setFirstPage(Boolean.parseBoolean(obj[13].toString()));
                    epf.setLastPage(Boolean.parseBoolean(obj[14].toString()));

                    return c;
                }).collect(Collectors.toList());

        epf.setContent(content);

        return epf;
    }

    @Override
    public Page<Conductor> readPageByStatus(boolean estado, Pageable pageable) {
        return this.repo.readPageByStatus(estado, pageable);
    }

}
