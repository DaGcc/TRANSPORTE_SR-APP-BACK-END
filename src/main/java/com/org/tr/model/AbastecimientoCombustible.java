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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;


@Entity
@Table( name = "abastecimiento_combustible" )
public class AbastecimientoCombustible {
  
    
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer idAbastecimientoCombustible;
    
    @NotNull( message ="El campo: vehiculo, no debe ser nulo.")
    @ManyToOne
    @JoinColumn( name = "id_vehiculo", nullable = false, 
            foreignKey = @ForeignKey(name="fk_abastecimiento_combustible_vehiculo"))
    private Vehiculo vehiculo;
    
    @DecimalMin(value = "0.00", message ="El costo no puede ser negativo.")
    @DecimalMax(value = "1999.99", message ="El costo maximo es de S/.1999.99 soles.")
    @Column(name="costo", nullable = false, scale = 2)
    private BigDecimal costo; //FALTA ESPECIFICAR COSTOS maximos
    
    @DecimalMin(value = "0.00", message ="La cantidad de combustible no puede ser negativo.")
    @Column(name ="cantidad", nullable = false, scale = 2)
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
