package com.org.tr.repo;

import com.org.tr.model.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ISolicitudRepo extends JpaRepository<Solicitud ,Integer>{
    
}
