/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.org.tr.repo;

import com.org.tr.model.ArchivoFactura;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface IArchivoFacturaRepo extends JpaRepository<ArchivoFactura ,Integer>{
   
    @Query("FROM ArchivoFactura af WHERE af.factura.idFactura =:idFactura")
    Optional<ArchivoFactura> readArchivoByfactura(@Param("idFactura") Integer idFactura);
  
}
