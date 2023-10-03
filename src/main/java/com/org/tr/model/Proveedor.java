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

    @NotNull
    @NotEmpty
    @Size(min = 11, max = 11, message = "El RUC debe de tener once digitos.")
    @Column(name = "ruc", nullable = false, length = 11, unique = true)
    private String ruc;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 35, message = "El nombre debe de tener como minimo 3 caracteres y como maximo 35.")
    @Column(name = "nombre", nullable = false, length = 35)
    private String nombre;

    @NotNull
    @NotEmpty
    @Size(min = 9, max = 9, message = "El número de telefono debe de tener 9 digitos.")
    @Column(name = "telefono", nullable = true, length = 9, unique = true)
    private String telefono;

    @NotNull
    @Email
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "direccion", length = 100, nullable = false)
    private String direccion;

    @NotNull
    @Column(name = "estado", nullable = false)
    private boolean estado;

}
