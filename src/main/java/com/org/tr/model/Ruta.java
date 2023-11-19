/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.org.tr.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ruta")
public class Ruta  implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRuta;

    @JsonIgnoreProperties(value = {"listaRutas"})
    @ManyToOne
    @JoinColumn(
            name = "id_detalle_actividad",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_ruta_detalle_actividad")
    )
    private DetalleActividad detalleActividad;

    @NotEmpty(message = "El campo: nombre, no debe ser vacio")
    @Size(max = 95, message = "El nombre del lugar debe de tener como maximo 95 caracteres.")
    @Column(name = "nombre", nullable = false, length = 95)
    private String nombre;

    @Column(name = "longitud", nullable = false)
    private String longitud;

    @Column(name = "latitud", nullable = false)
    private String latitud;

    @NotNull(message = "El campo: estado, no debe ser nulo")
    @Column(name = "estado", nullable = false)
    private boolean estado;

    
    public Integer getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(Integer idRuta) {
        this.idRuta = idRuta;
    }

    public DetalleActividad getDetalleActividad() {
        return detalleActividad;
    }

    public void setDetalleActividad(DetalleActividad detalleActividad) {
        this.detalleActividad = detalleActividad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
    
    
}
