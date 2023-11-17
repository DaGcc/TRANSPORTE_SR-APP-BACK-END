package com.org.tr.service;

import com.org.tr.DTO.EntityPageFilterDTO;
import com.org.tr.model.Actividad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IActividadService extends ICRUD<Actividad> {

    Page<Actividad> readPageByStatus(boolean estado, Pageable pageable);
 
    EntityPageFilterDTO<Actividad> filtroActividads(Integer pageIndex, Integer pageSize, String filtro);

}
