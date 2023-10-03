/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.org.tr.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;


@Entity
@Table( name = "abastecimiento_combustible" )
public class AbastecimientoCombustible {
  
    
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer idAbastecimientoCombustible;
    
    @JoinColumn( name = "id_vehiculo", nullable = false, 
            foreignKey = @ForeignKey(name="fk_abastecimiento_combustible_vehiculo"))
    private Vehiculo vehiculo;
    
    
    @Column(name="costo", nullable = false)
    private BigDecimal costo; //FALTA ESPECIFICAR COSTOS maximos
    
    @Column(name ="cantidad", nullable = false)
    private BigDecimal cantidad;
    
    @JsonSerialize( using = ToStringSerializer.class)
    private LocalDateTime fecha;

    
    //TODO: metodos
    
    public AbastecimientoCombustible() {
    }

    public AbastecimientoCombustible(Integer idAbastecimientoCombustible, Vehiculo vehiculo, BigDecimal costo, BigDecimal cantidad, LocalDateTime fecha) {
        this.idAbastecimientoCombustible = idAbastecimientoCombustible;
        this.vehiculo = vehiculo;
        this.costo = costo;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    
    public Integer getIdAbastecimientoCombustible() {
        return idAbastecimientoCombustible;
    }

    public void setIdAbastecimientoCombustible(Integer idAbastecimientoCombustible) {
        this.idAbastecimientoCombustible = idAbastecimientoCombustible;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
    
    
    
}
