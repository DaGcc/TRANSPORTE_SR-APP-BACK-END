package com.org.tr.service;

import com.org.tr.DTO.EntityPageFilterDTO;
import com.org.tr.model.OrdenServicio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IOrdenServicioService extends ICRUD<OrdenServicio> {

    Page<OrdenServicio> readPageByStatus(boolean estado, Pageable pageable);
 
    //??flata
    EntityPageFilterDTO<OrdenServicio> filtroOrdenServicios(Integer pageIndex, Integer pageSize, String filtro);

}
