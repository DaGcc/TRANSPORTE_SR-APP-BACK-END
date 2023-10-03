/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.org.tr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "tipo_vehiculo" )//electrico | conbustible
public class TipoVehiculo {
    
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer idTipoVehiculo;
      
    
    @Column( name = "tipo", nullable = false, length = 60 )
    private String tipo;

    public TipoVehiculo() {
    }

    public TipoVehiculo(Integer idTipoVehiculo, String tipo) {
        this.idTipoVehiculo = idTipoVehiculo;
        this.tipo = tipo;
    }

    
    public Integer getIdTipoVehiculo() {
        return idTipoVehiculo;
    }

    public void setIdTipoVehiculo(Integer idTipoVehiculo) {
        this.idTipoVehiculo = idTipoVehiculo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
    
}
