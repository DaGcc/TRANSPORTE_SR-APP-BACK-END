/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.org.tr.repo;

import com.org.tr.model.Conductor;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface IConductorRepo extends JpaRepository<Conductor ,Integer>{
    
    
    @Query(value = "FROM Conductor cd WHERE cd.estado =:estado ")
    Page<Conductor> readPageByStatus(@Param("estado") boolean estado, Pageable pageable);
    
    
    @Query(value ="EXEC filtro_conductores :pageIndex,:pageSize,:filtro ", nativeQuery = true)
    List<Object[]> filtroConductors(
            @Param("pageIndex") Integer pageIndex, 
            @Param("pageSize") Integer pageSize,
            @Param("filtro") String filtro);
    
    
    
}
