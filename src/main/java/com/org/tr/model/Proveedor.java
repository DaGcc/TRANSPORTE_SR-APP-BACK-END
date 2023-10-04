/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.org.tr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "proveedor")
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProveedor;

    @NotNull(message = "El campo: ruc, no debe ser nulo.")
    @NotEmpty(message = "El campo: ruc, no debe de estar vacio.")
    @Size(min = 11, max = 11, message = "El RUC debe de tener once digitos.")
    @Column(name = "ruc", nullable = false, length = 11, unique = true)
    private String ruc;

    @NotNull(message = "El campo: nombre, no debe ser nulo.")
    @NotEmpty(message = "El campo: nombre, no debe de estar vacio.")
    @Size(min = 3, max = 35, message = "El nombre debe de tener como minimo 3 caracteres y como maximo 35.")
    @Column(name = "nombre", nullable = false, length = 35)
    private String nombre;

    @NotNull(message = "El campo: telefono, no debe ser nulo.")
    @NotEmpty(message = "El campo: telefono, no debe de estar vacio.")
    @Size(min = 9, max = 9, message = "El número de telefono debe de tener 9 digitos.")
    @Column(name = "telefono", nullable = true, length = 9, unique = true)
    private String telefono;

    @NotNull(message = "El campo: email, no debe ser nulo.")
    @Email(message = "Ingrese de manera correcta la direccion email.")
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @NotNull(message = "El campo: direccion, no debe ser nulo.")
    @NotEmpty(message = "El campo: direccion, no debe de estar vacio.")
    @Size(min = 2, max = 100, message = "La direccion debe de tener 2 digitos como minimo y 100 como maximo.")
    @Column(name = "direccion", length = 100, nullable = false)
    private String direccion;

    @NotNull(message = "El campo: estado, no debe ser nulo.")
    @Column(name = "estado", nullable = false)
    private boolean estado;
    

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    
    
}
