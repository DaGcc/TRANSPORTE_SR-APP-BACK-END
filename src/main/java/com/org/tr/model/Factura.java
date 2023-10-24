package com.org.tr.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "factura")
public class Factura implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFactura;


    @Size(max = 30, message = "El codigoFactura debe de tener 30 digitos como maximo.")
    @Column(name = "codigo_factura", nullable = true, length = 30, unique = true)
    private String codigoFactura;

    @JsonSerialize( using = ToStringSerializer.class)
    private LocalDateTime fecha;
   
    @NotNull(message = "El campo: estado, no debe ser nulo")
    @Column(name = "estado", nullable = false)
    private boolean estado;
            
    @Valid
    @JsonIgnoreProperties(value = {"factura"}, allowSetters = true)
    @OneToOne( mappedBy = "factura", cascade = CascadeType.ALL, orphanRemoval = true)
    private OrdenServicio ordenServicio;

    public Factura() {
    }

    public Integer getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public String getCodigoFactura() {
        return codigoFactura;
    }

    public void setCodigoFactura(String codigoFactura) {
        this.codigoFactura = codigoFactura;
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

    public OrdenServicio getOrdenServicio() {
        return ordenServicio;
    }

    public void setOrdenServicio(OrdenServicio ordenServicio) {
        
        if(ordenServicio != null) ordenServicio.setFactura(this);
        
        this.ordenServicio = ordenServicio;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.idFactura);
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
        final Factura other = (Factura) obj;
        if (!Objects.equals(this.idFactura, other.idFactura)) {
            return false;
        }
        return true;
    }

}
