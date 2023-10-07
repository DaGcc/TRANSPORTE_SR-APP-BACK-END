package com.org.tr.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "detalle_mantenimiento")
public class DetalleMantenimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetalleMantenimiento;

    @JsonIgnoreProperties(value = {"listaDetalleMantenimiento"})
    @ManyToOne
    @JoinColumn(name = "id_mantenimiento", nullable = false, foreignKey = @ForeignKey(name = "fk_detalle_mantenimiento_mantenimiento"))
    private Mantenimiento mantenimiento;

    @NotNull(message = "El campo: objeto, no debe de ser nulo.")
    @ManyToOne
    @JoinColumn(name = "id_objeto", nullable = false, foreignKey = @ForeignKey(name = "fk_detalle_mantenimiento_bjeto"))
    private Objeto objeto;

    @DecimalMin(value = "0.00", message = "La cantidad usar del objeto no puede ser negativo.")
    @Column(name = "cantidad", nullable = false, scale = 2)
    private BigDecimal cantidad;

    @JsonSerialize(using = ToStringSerializer.class)
    private LocalDateTime fecha;

    @NotNull(message = "El campo: estado, no debe de ser nulo.")
    @Column(name = "estado", nullable = false)
    private boolean estado;

    public Integer getIdDetalleMantenimiento() {
        return idDetalleMantenimiento;
    }

    public void setIdDetalleMantenimiento(Integer idDetalleMantenimiento) {
        this.idDetalleMantenimiento = idDetalleMantenimiento;
    }

    public Mantenimiento getMantenimiento() {
        return mantenimiento;
    }

    public void setMantenimiento(Mantenimiento mantenimiento) {
        this.mantenimiento = mantenimiento;
    }

    public Objeto getObjeto() {
        return objeto;
    }

    public void setObjeto(Objeto objeto) {
        this.objeto = objeto;
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

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    
}
