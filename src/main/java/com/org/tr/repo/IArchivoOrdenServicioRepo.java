/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.org.tr.repo;

import com.org.tr.model.ArchivoFactura;
import com.org.tr.model.ArchivoOrdenServicio;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IArchivoOrdenServicioRepo extends JpaRepository<ArchivoOrdenServicio, Integer> {

    @Query("FROM ArchivoOrdenServicio aos WHERE aos.ordenServicio.idOrdenServicio =:idOrdenServicio")
    Optional<ArchivoOrdenServicio> readArchivoByOrdenServicio(@Param("idOrdenServicio") Integer idOrdenServicio);

}
