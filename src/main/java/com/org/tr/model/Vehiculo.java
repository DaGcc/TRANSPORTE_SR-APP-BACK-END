/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.org.tr.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table( name = "vehiculo" )
public class Vehiculo {
    
    
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer idVehiculo;
    
    
    @NotNull( message ="El campo: tipoVehiculo, no debe ser nulo.")
    @ManyToOne
    @JoinColumn( name ="id_tipoVehiculo", nullable = false)
    private TipoVehiculo tipoVehiculo;
    
    @NotNull( message ="El campo: placa, no debe ser nulo.")
    @NotEmpty( message ="El campo: placa, no debe de estar vacio.")
    @Size(min = 7, max = 7, message = "El numero de placa del vehiculo debe de tener 7 digitos")
    @Column(name = "placa", nullable = false, length = 7, unique = true)
    private String placa;
    
    
    @Lob
    @Basic
    private byte[] foto;
    
    
    @NotNull( message ="no debe ser nulo")
    @NotEmpty( message ="no debe de estar vacio")
    @Size(min = 2, max = 20, message = "El color del vehiculo debe de tener como minimo 2 digitos y como maximo 20")
    @Column(name = "color_vehiculo", nullable = false, length = 20)
    private String colorVehiculo;
    
    @NotNull( message ="no debe ser nulo")
    @NotEmpty( message ="no debe de estar vacio")
    @Column(name = "alto", nullable = false, length = 10)
    private String alto;//tratarlo como string??
    
    
    @NotNull( message ="no debe ser nulo")
    @NotEmpty( message ="no debe de estar vacio")
    @Column(name = "ancho", nullable = false, length = 10)
    private String ancho;//tratarlo como string??
    
    @NotNull( message ="no debe ser nulo")
    @NotEmpty( message ="no debe de estar vacio")
    @Column(name = "capacidad_maxima", nullable = false, length = 10)
    private String capacidadMaxima;//tratarlo como string??
    
 
    @NotNull
    @Column( name = "estado", nullable = false )
    private boolean estado; 
   
    
    
    
}
