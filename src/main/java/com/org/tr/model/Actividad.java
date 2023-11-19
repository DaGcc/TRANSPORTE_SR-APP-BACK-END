/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.org.tr.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "actividad")
public class Actividad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idActividad;

    @NotNull(message = "El campo: conductor, no debe ser nulo.")
    @ManyToOne
    @JoinColumn(name = "id_conductor", nullable = false, foreignKey = @ForeignKey(name = "fk_actividad_conductor"))
    private Conductor conductor;

    @NotNull(message = "El campo: vehiculo, no debe ser nulo.")
    @ManyToOne
    @JoinColumn(name = "id_vehiculo", nullable = false, foreignKey = @ForeignKey(name = "fk_actividad_vehiculo"))
    private Vehiculo vehiculo;

    @NotNull(message = "El campo: solicitud, no debe ser nulo.")
    @ManyToOne
    @JoinColumn(name = "id_solicitud", nullable = false, foreignKey = @ForeignKey(name = "fk_actividad_solicitud"))
    private Solicitud solicitud;

    @NotNull(message = "El campo: descripcion, no debe de ser nulo.")
    @NotEmpty(message = "El campo: descripcion, no debe ser vacio.")
    @Size(min = 15, max = 200, message = "Como minimo brinda una descripción de 15 caracteres y como maximo 200")
    @Column(name = "descripcion", length = 200, nullable = false)
    private String descripcion;

    @JsonSerialize(using = ToStringSerializer.class)
    private LocalDateTime fechaCreada;

    @NotNull(message = "El campo: estado, no debe de ser nulo.")
    @Column(name = "estado", nullable = false)
    private boolean estado; //aqui si por "true" o "false"

    @JsonIgnoreProperties(value = {"actividad"}, allowSetters = true)
    @OneToMany(mappedBy = "actividad", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleActividad> listaDetalleActividad = new ArrayList<>();

    //TODO: metodos aqui
    public Integer getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(Integer idActividad) {
        this.idActividad = idActividad;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFechaCreada() {
        return fechaCreada;
    }

    public void setFechaCreada(LocalDateTime fechaCreada) {
        this.fechaCreada = fechaCreada;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public List<DetalleActividad> getListaDetalleActividad() {
        return listaDetalleActividad;
    }

    public void setListaDetalleActividad(List<DetalleActividad> listaDetalleActividad) {
        
        if (listaDetalleActividad != null && !listaDetalleActividad.isEmpty()) {
            this.listaDetalleActividad.clear();
            listaDetalleActividad.forEach(d -> {
                this.addDetalle(d);
            });
        }
    }

    public void addDetalle(DetalleActividad detalleActividad) {
        detalleActividad.setActividad(this);
        this.listaDetalleActividad.add(detalleActividad);
    }

}
