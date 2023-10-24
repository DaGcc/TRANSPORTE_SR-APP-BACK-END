package com.org.tr.service;

import com.org.tr.DTO.EntityPageFilterDTO;
import com.org.tr.DTO.FacturaOrdenFilesDTO;
import com.org.tr.model.Factura;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IFacturaService extends ICRUD<Factura> {

    Page<Factura> readPageByStatus(boolean estado, Pageable pageable);
 
    EntityPageFilterDTO<Factura> filtroFacturas(Integer pageIndex, Integer pageSize, String filtro);

    
    public Factura create(FacturaOrdenFilesDTO dto);
    
    
}
