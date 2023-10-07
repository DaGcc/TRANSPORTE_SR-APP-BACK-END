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
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "mantenimiento")
public class Mantenimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMantenimiento;

    @NotNull(message = "El campo: vehiculo, no debe ser nulo.")
    @ManyToOne
    @JoinColumn(name = "id_vehiculo", nullable = false, foreignKey = @ForeignKey(name = "fk_mantenimiento_vehiculo"))
    private Vehiculo vehiculo;

    @NotNull(message = "El campo: local, no debe de ser nulo.")
    @NotEmpty(message = "El campo: local, no debe ser vacio.")
    @Size(min = 2, max = 80, message = "El campo local tiene como minimo 2 caracteres y como maximo 80.")
    @Column(name = "local", length = 80, nullable = false)
    private String local;

    @JsonSerialize(using = ToStringSerializer.class)
    private LocalDateTime fechaSupervicion;

    @NotNull(message = "El campo: descripcion, no debe de ser nulo.")
    @NotEmpty(message = "El campo: descripcion, no debe ser vacio.")
    @Size(min = 15, max = 160, message = "Como minimo brinda una descripción de 15 caracteres y como maximo 150.")
    @Column(name = "descripcion", length = 160, nullable = false)
    private String descripcion;

    @DecimalMin(value = "0.00", message = "El costoManoObra no puede ser negativo.")
    @Column(name = "costo_mano_obra", nullable = true, scale = 2)
    private BigDecimal costoManoObra;

    @DecimalMin(value = "0.00", message = "El gastoNeto no puede ser negativo.")
    @Column(name = "gasto_neto", nullable = true, scale = 2)
    private BigDecimal gastoNeto;

    @NotNull(message = "El campo: estadoAccion, no debe de ser nulo.")
    @NotEmpty(message = "El campo: estadoAccion, no debe ser vacio.")
    @Size(max = 40, message = "El campo estadoAccion debe de tener como maximo 40 caracteres.")
    @Column(name = "estado_accion", nullable = false, length = 40)
    private String estadoAccion;

    @NotNull(message = "El campo: estado, no debe de ser nulo.")
    @Column(name = "estado", nullable = false)
    private boolean estado;
    
    @JsonIgnoreProperties(value = {"mantenimiento"}, allowSetters = true)
    @OneToMany(mappedBy = "mantenimiento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleMantenimiento> listaDetalleMantenimiento;

    public Integer getIdMantenimiento() {
        return idMantenimiento;
    }

    public void setIdMantenimiento(Integer idMantenimiento) {
        this.idMantenimiento = idMantenimiento;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public LocalDateTime getFechaSupervicion() {
        return fechaSupervicion;
    }

    public void setFechaSupervicion(LocalDateTime fechaSupervicion) {
        this.fechaSupervicion = fechaSupervicion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getCostoManoObra() {
        return costoManoObra;
    }

    public void setCostoManoObra(BigDecimal costoManoObra) {
        this.costoManoObra = costoManoObra;
    }

    public BigDecimal getGastoNeto() {
        return gastoNeto;
    }

    public void setGastoNeto(BigDecimal gastoNeto) {
        this.gastoNeto = gastoNeto;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public List<DetalleMantenimiento> getListaDetalleMantenimiento() {
        return listaDetalleMantenimiento;
    }

    public void setListaDetalleMantenimiento(List<DetalleMantenimiento> listaDetalleMantenimiento) {
        this.listaDetalleMantenimiento = listaDetalleMantenimiento;
    }

    public String getEstadoAccion() {
        return estadoAccion;
    }

    public void setEstadoAccion(String estadoAccion) {
        this.estadoAccion = estadoAccion;
    }

}
