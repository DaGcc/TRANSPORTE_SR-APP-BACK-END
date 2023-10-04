package com.org.tr.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "detalle_vehiculo")
public class DetalleVehiculo implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetalleVehiculo;

    @NotNull(message = "El campo: vehiculo, no debe ser nulo.")
    @JsonIgnoreProperties(value = {"listaDetalleVehiculo"})
    @ManyToOne
    @JoinColumn(name = "id_vehiculo", nullable = false, foreignKey = @ForeignKey(name = "fk_detalle_vehiculo_vehiculo"))
    private Vehiculo vehiculo;

    @JsonSerialize(using = ToStringSerializer.class)
    private LocalDateTime fechaSoatVenc;

    @JsonSerialize(using = ToStringSerializer.class)
    private LocalDateTime fechaCirculacionVenc;

    @JsonSerialize(using = ToStringSerializer.class)
    private LocalDateTime fechaTecnicaVenc;

    public Integer getIdDetalleVehiculo() {
        return idDetalleVehiculo;
    }

    public void setIdDetalleVehiculo(Integer idDetalleVehiculo) {
        this.idDetalleVehiculo = idDetalleVehiculo;
    }

 
    

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public LocalDateTime getFechaSoatVenc() {
        return fechaSoatVenc;
    }

    public void setFechaSoatVenc(LocalDateTime fechaSoatVenc) {
        this.fechaSoatVenc = fechaSoatVenc;
    }

    public LocalDateTime getFechaCirculacionVenc() {
        return fechaCirculacionVenc;
    }

    public void setFechaCirculacionVenc(LocalDateTime fechaCirculacionVenc) {
        this.fechaCirculacionVenc = fechaCirculacionVenc;
    }

    public LocalDateTime getFechaTecnicaVenc() {
        return fechaTecnicaVenc;
    }

    public void setFechaTecnicaVenc(LocalDateTime fechaTecnicaVenc) {
        this.fechaTecnicaVenc = fechaTecnicaVenc;
    }
    
    
}
