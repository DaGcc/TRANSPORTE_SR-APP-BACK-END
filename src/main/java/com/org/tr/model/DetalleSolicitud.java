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
@Table(name = "detalle_solicitud")
public class DetalleSolicitud implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetalleSolicitud;

    @NotNull(message = "El campo: solicitud, no debe de ser nulo.")
    @JsonIgnoreProperties(value = {"listaDetalleSolicitud"})
    @ManyToOne
    @JoinColumn(name = "id_solicitud", nullable = false, foreignKey = @ForeignKey(name = "fk_detalle_solicitud_solicitud"))
    private Solicitud solicitud;

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

    public Integer getIdDetalleSolicitud() {
        return idDetalleSolicitud;
    }

    public void setIdDetalleSolicitud(Integer idDetalleSolicitud) {
        this.idDetalleSolicitud = idDetalleSolicitud;
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
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

    

}
