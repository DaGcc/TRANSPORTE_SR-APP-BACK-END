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
import java.util.Objects;
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
@Table(name = "solicitud")
public class Solicitud implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSolicitud;

    @NotNull(message = "El campo: servicio, no debe ser nulo.")
    @ManyToOne
    @JoinColumn(name = "id_servicio", nullable = false, foreignKey = @ForeignKey(name = "fk_solicitud_servicio"))
    private Servicio servicio;

    @NotNull(message = "El campo: cliente, no debe de ser nulo.")
    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false, foreignKey = @ForeignKey(name = "fk_solicitud_cliente"))
    private Cliente cliente;

    @NotNull(message = "El campo: descripcion, no debe de ser nulo.")
    @NotEmpty(message = "El campo: descripcion, no debe ser vacio.")
    @Size(min = 15, max = 150, message = "Como minimo brinda una descripción de 15 caracteres y como maximo 150.")
    @Column(name = "descripcion", length = 150, nullable = false)
    private String descripcion;

    @JsonSerialize(using = ToStringSerializer.class)
    private LocalDateTime fechaSolicitada;

    @NotNull(message = "El campo: estado, no debe de ser nulo.")
    @Column(name = "estado", nullable = false)
    private boolean estado; //aqui si por "true" o "false"

    @JsonIgnoreProperties(value = {"solicitud"}, allowSetters = true)
    @OneToMany(mappedBy = "solicitud", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleSolicitud> listaDetalleSolicitud;

    public Solicitud() {
        this.listaDetalleSolicitud = new ArrayList();
    }

    public Integer getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(Integer idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFechaSolicitada() {
        return fechaSolicitada;
    }

    public void setFechaSolicitada(LocalDateTime fechaSolicitada) {
        this.fechaSolicitada = fechaSolicitada;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public List<DetalleSolicitud> getListaDetalleSolicitud() {
        return listaDetalleSolicitud;
    }

    public void setListaDetalleSolicitud(List<DetalleSolicitud> listaDetalleSolicitud) {

        this.listaDetalleSolicitud.clear();

        //Buena practica, para evitar errores relacionados con punteros nulos o listas vacías.
        // inicializada != null          &   contenga elementos
        if (listaDetalleSolicitud != null && !listaDetalleSolicitud.isEmpty()) {
            listaDetalleSolicitud.forEach(l -> {
                l.setSolicitud(this);
                this.listaDetalleSolicitud.add(l);
            });

            //listaDetalleSolicitud.forEach(this::addDetalleSolicitud);
        }
    }

    public void addDetalleSolicitud(DetalleSolicitud detalleSolicitud) {
        detalleSolicitud.setSolicitud(this);
        this.listaDetalleSolicitud.add(detalleSolicitud);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.idSolicitud);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Solicitud other = (Solicitud) obj;
        if (!Objects.equals(this.idSolicitud, other.idSolicitud)) {
            return false;
        }
        return true;
    }

}
