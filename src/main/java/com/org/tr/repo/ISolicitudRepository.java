package com.org.tr.repo;

import com.org.tr.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ISolicitudRepository extends JpaRepository<Cliente ,Integer>{
    
}
