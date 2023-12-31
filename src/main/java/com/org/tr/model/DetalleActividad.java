/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.org.tr.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import java.math.BigDecimal;
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
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "detalle_actividad")
public class DetalleActividad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetalleActividad;

    @JsonIgnoreProperties(value = {"listaDetalleActividad"})
    @ManyToOne
    @JoinColumn(name = "id_actividad", nullable = false, foreignKey = @ForeignKey(name = "fk_detalle_actividad_actividad"))
    private Actividad actividad;

    @NotNull(message = "El campo: descripcion, no debe de ser nulo.")
    @NotEmpty(message = "El campo: descripcion, no debe ser vacio.")
    @Size(min = 15, max = 200, message = "Como minimo brinda una descripción de 15 caracteres y como maximo 200.")
    @Column(name = "descripcion", length = 200, nullable = false)
    private String descripcion;

    @Min(value = 0, message = "El costo debe de ser mayor o igual a 0.")
    @Column(name = "costo", nullable = false)
    private BigDecimal costo;

    @JsonSerialize(using = ToStringSerializer.class)
    private LocalDateTime fecha;

    @NotNull(message = "El campo: estadoAccion, no debe de ser nulo.")
    @NotEmpty(message = "El campo: estadoAccion, no debe ser vacio.")
    @Size(max = 40, message = "El campo estadoAccion debe de tener como maximo 40 caracteres.")
    @Column(name = "estado_accion", nullable = false, length = 40)
    private String estadoAccion;

    @NotNull(message = "El campo: estado, no debe de ser nulo.")
    @Column(name = "estado", nullable = false)
    private boolean estado;

    @Valid
    @JsonIgnoreProperties(value = {"detalleActividad"}, allowSetters = true)
    @OneToMany(mappedBy = "detalleActividad", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Horario> listaHorarios = new ArrayList<>();

    @Valid
    @JsonIgnoreProperties(value = {"detalleActividad"}, allowSetters = true)
    @OneToMany(mappedBy = "detalleActividad", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ruta> listaRutas = new ArrayList<>();

    //constructor
    public DetalleActividad() {
    }

    //TODO: metodos
    public Integer getIdDetalleActividad() {
        return idDetalleActividad;
    }

    public void setIdDetalleActividad(Integer idDetalleActividad) {
        this.idDetalleActividad = idDetalleActividad;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public String getEstadoAccion() {
        return estadoAccion;
    }

    public void setEstadoAccion(String estadoAccion) {
        this.estadoAccion = estadoAccion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public List<Horario> getListaHorarios() {
        return listaHorarios;
    }

    public void setListaHorarios(List<Horario> listaHorarios) {
        if (listaHorarios != null && !listaHorarios.isEmpty()) {
            this.listaHorarios.clear();
            listaHorarios.forEach(d -> {
                this.addHorario(d);
            });
        }
    }

    public void addHorario(Horario horario) {
        horario.setDetalleActividad(this);
        this.listaHorarios.add(horario);
    }

    public List<Ruta> getListaRutas() {
        return listaRutas;
    }

    public void setListaRutas(List<Ruta> listaRutas) {

        if (listaRutas != null && !listaRutas.isEmpty()) {
            this.listaRutas.clear();
            listaRutas.forEach(d -> {
                this.addRuta(d);
            });
        }
    }

    public void addRuta(Ruta ruta) {
        ruta.setDetalleActividad(this);
        this.listaRutas.add(ruta);
    }

}
