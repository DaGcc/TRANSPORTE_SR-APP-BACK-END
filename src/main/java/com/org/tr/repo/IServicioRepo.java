package com.org.tr.repo;

import com.org.tr.model.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IServicioRepo extends JpaRepository<Servicio ,Integer>{
    
}
