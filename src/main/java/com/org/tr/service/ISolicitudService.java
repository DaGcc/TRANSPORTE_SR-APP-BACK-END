package com.org.tr.service;

import com.org.tr.model.Cliente;
import com.org.tr.model.Solicitud;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ISolicitudService extends ICRUD<Solicitud>{
    
    Page<Solicitud> readPageByStatus(boolean estado, Pageable pageable);

}
