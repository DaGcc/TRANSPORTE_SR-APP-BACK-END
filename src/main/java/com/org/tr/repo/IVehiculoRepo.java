/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.org.tr.repo;

import com.org.tr.model.Vehiculo;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface IVehiculoRepo extends JpaRepository<Vehiculo ,Integer>{
    
    
    @Query(value = "FROM Vehiculo v WHERE v.estado =:estado ")
    Page<Vehiculo> readPageByStatus(@Param("estado") boolean estado, Pageable pageable);
    
    
    // falta el procedure
    @Query(value ="EXEC filtro_vehiculo :pageIndex,:pageSize,:filtro ", nativeQuery = true)
    List<Object[]> filtroVehiculos(
            @Param("pageIndex") Integer pageIndex, 
            @Param("pageSize") Integer pageSize,
            @Param("filtro") String filtro);
    
    
    
}
