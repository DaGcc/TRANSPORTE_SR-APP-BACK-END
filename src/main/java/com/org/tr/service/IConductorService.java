package com.org.tr.service;

import com.org.tr.DTO.EntityPageFilterDTO;
import com.org.tr.model.Conductor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IConductorService extends ICRUD<Conductor> {

    Page<Conductor> readPageByStatus(boolean estado, Pageable pageable);
 
    EntityPageFilterDTO<Conductor> filtroConductors(Integer pageIndex, Integer pageSize, String filtro);

}
