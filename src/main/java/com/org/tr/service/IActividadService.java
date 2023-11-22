package com.org.tr.service;

import com.org.tr.DTO.EntityPageFilterDTO;
import com.org.tr.model.Actividad;
import com.org.tr.model.DetalleActividad;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IActividadService extends ICRUD<Actividad> {

    Page<Actividad> readPageByStatus(boolean estado, Pageable pageable);
 
    EntityPageFilterDTO<Actividad> filtroActividads(Integer pageIndex, Integer pageSize, String filtro);

    List<DetalleActividad> listarDetalleActividadesPorEmailConductor( String email);

}
