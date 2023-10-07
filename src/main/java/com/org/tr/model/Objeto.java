/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.org.tr.model;

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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "objeto")
public class Objeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idObjeto;

    @NotNull(message = "El campo: inventario, no debe de ser nulo.")
    @ManyToOne
    @JoinColumn(name = "id_inventario", nullable = false, foreignKey = @ForeignKey(name = "fk_objeto_inventario"))
    private Inventario inventario;

    @NotNull(message = "El campo: proveedor, no debe de ser nulo.")
    @ManyToOne
    @JoinColumn(name = "id_proveedor", nullable = false, foreignKey = @ForeignKey(name = "fk_objeto_proveedor"))
    private Proveedor proveedor;

    @NotNull(message = "El campo: nombre, no debe de ser nulo.")
    @NotEmpty(message = "El campo: nombre, no debe ser vacio.")
    @Size(min = 3, max = 60, message = "El nombre debe de tener como minimo 3 caracteres y como maximo 60.")
    @Column(name = "nombre", nullable = false, length = 60)
    private String nombre;

    @NotEmpty(message = "El campo: descripcion, no debe ser vacio.")
    @Size(min = 15, max = 160, message = "Como minimo brinda una descripción de 15 caracteres y como maximo 150.")
    @Column(name = "descripcion", length = 160, nullable = true)
    private String descripcion;

    @DecimalMin(value = "0.00", message = "El precioUnitario no puede ser negativo.")
    @Column(name = "precio_unitario", nullable = true, scale = 2)
    private BigDecimal precioUnitario;

    @Min(value = 1, message = "Como minimo brinda 1 stock del producto.")
    //@Max( value = 40, message = "Como maximo otorga 40 stocks del producto.")
    @Column(name = "stock", nullable = false)
    private Integer stock;//la compra o modificacion del stock se hara a travez de la solicitud de compra 

    @JsonSerialize(using = ToStringSerializer.class)
    @Column(nullable = true)
    private LocalDateTime fechaVenciminento;

    @NotNull(message = "El campo: estado, no debe de ser nulo.")
    @Column(name = "estado", nullable = false)
    private boolean estado;

    public Integer getIdObjeto() {
        return idObjeto;
    }

    public void setIdObjeto(Integer idObjeto) {
        this.idObjeto = idObjeto;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public LocalDateTime getFechaVenciminento() {
        return fechaVenciminento;
    }

    public void setFechaVenciminento(LocalDateTime fechaVenciminento) {
        this.fechaVenciminento = fechaVenciminento;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
