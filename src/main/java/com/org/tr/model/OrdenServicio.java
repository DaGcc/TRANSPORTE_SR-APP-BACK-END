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
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "orden_servicio")
public class OrdenServicio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOrdenServicio;
    
    @JsonIgnoreProperties( value = {"ordenServicio"})
    @OneToOne
    @JoinColumn(name = "id_factura", 
            foreignKey = @ForeignKey(name ="fk_orden_servicio_factura"),
            unique = true)
    private Factura factura;

    @Size(max = 30, message = "El codigo debe de tener como maximo 30 digitos.")
    @Column(name = "codigo_orden", nullable = true, length = 30, unique = true)
    private String codigoOrden;
    
    @JsonSerialize( using = ToStringSerializer.class)
    private LocalDateTime fecha;

    @NotNull(message = "El campo: estado, no debe ser nulo")
    @Column(name = "estado", nullable = false)
    private boolean estado;
    
    public OrdenServicio() {
    }

    public Integer getIdOrdenServicio() {
        return idOrdenServicio;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public void setIdOrdenServicio(Integer idOrdenServicio) {
        this.idOrdenServicio = idOrdenServicio;
    }

    public String getCodigoOrden() {
        return codigoOrden;
    }

    public void setCodigoOrden(String codigoOrden) {
        this.codigoOrden = codigoOrden;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }


    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
    
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.idOrdenServicio);
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
        final OrdenServicio other = (OrdenServicio) obj;
        if (!Objects.equals(this.idOrdenServicio, other.idOrdenServicio)) {
            return false;
        }
        return true;
    }
    
    
}
