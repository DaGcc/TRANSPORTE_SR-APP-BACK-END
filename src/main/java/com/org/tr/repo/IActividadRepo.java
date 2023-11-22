/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.org.tr.repo;

import com.org.tr.model.Actividad;
import com.org.tr.model.DetalleActividad;
import com.org.tr.model.Horario;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface IActividadRepo extends JpaRepository<Actividad ,Integer>{
    
    
    @Query(value = "FROM Actividad cd WHERE cd.estado =:estado ")
    Page<Actividad> readPageByStatus(@Param("estado") boolean estado, Pageable pageable);
    
    
    //?? falta el ex para esta entidad
    @Query(value ="EXEC filtro_conductores :pageIndex,:pageSize,:filtro ", nativeQuery = true)
    List<Object[]> filtroActividads(
            @Param("pageIndex") Integer pageIndex, 
            @Param("pageSize") Integer pageSize,
            @Param("filtro") String filtro);
    
    
    @Query("SELECT ac.listaDetalleActividad FROM Actividad ac WHERE ac.conductor.email =:email")
    List<DetalleActividad> listarDetalleActividadesPorEmailConductor(@Param("email") String email);
    
    
}
