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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tipo_vehiculo")//electrico | conbustible
public class TipoVehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipoVehiculo;

    @Column(name = "tipo", nullable = false, length = 60)
    private String tipo;

    @NotNull(message = "El campo: capacidadMaxima, no debe ser nulo.")
    @NotEmpty(message = "El campo: capacidadMaxima, no debe de estar vacio.")
    @Column(name = "capacidad_maxima", nullable = false, length = 10)
    private String capacidadMaxima;//tratarlo como string??

    
    @NotNull(message = "El campo: descripcion, no debe de ser nulo.")
    @NotEmpty(message = "El campo: descripcion, no debe ser vacio.")
    @Size(min = 15, max = 200, message = "Como minimo brinda una descripción de 15 caracteres y como maximo 200.")
    @Column(name = "descripcion", length = 200, nullable = false)
    private String descripcion;
    
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

    public String getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(String capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
