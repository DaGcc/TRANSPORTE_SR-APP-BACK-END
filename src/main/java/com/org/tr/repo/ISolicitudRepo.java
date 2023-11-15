package com.org.tr.repo;

import com.org.tr.model.Cliente;
import com.org.tr.model.Solicitud;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ISolicitudRepo extends JpaRepository<Solicitud ,Integer>{
    
    @Query(value = "FROM Solicitud s WHERE s.estado =:estado ")
    Page<Solicitud> readPageByStatus(@Param("estado") boolean estado, Pageable pageable);
}
