/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.org.tr.repo;

import com.org.tr.model.Factura;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface IFacturaRepo extends JpaRepository<Factura ,Integer>{
    
    
    @Query(value = "FROM Factura f WHERE f.estado =:estado ")
    Page<Factura> readPageByStatus(@Param("estado") boolean estado, Pageable pageable);
    
    //!fatla ese procedure
    @Query(value ="EXEC filtro_clientes :pageIndex,:pageSize,:filtro ", nativeQuery = true)
    List<Object[]> filtroFacturas(
            @Param("pageIndex") Integer pageIndex, 
            @Param("pageSize") Integer pageSize,
            @Param("filtro") String filtro);
    
    
    
}
