package com.org.tr.service;

import com.org.tr.DTO.EntityPageFilterDTO;
import com.org.tr.model.Vehiculo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IVehiculoService extends ICRUD<Vehiculo> {

    Page<Vehiculo> readPageByStatus(boolean estado, Pageable pageable);
 
    EntityPageFilterDTO<Vehiculo> filtroVehiculos(Integer pageIndex, Integer pageSize, String filtro);

}
