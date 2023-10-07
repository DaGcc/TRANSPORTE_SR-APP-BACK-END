/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.org.tr.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "conductor")
public class Conductor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idConductor;

    @NotNull(message = "El campo: nombres, no debe de ser nulo.")
    @NotEmpty(message = "El campo: nombres, no debe ser vacio.")
    @Size(min = 3, max = 35, message = "El nombre debe de tener como minimo 3 caracteres y como maximo 35.")
    @Column(name = "nombres", nullable = false, length = 35)
    private String nombres;

    @NotNull(message = "El campo: genero, no debe de ser nulo.")
    @ManyToOne
    @JoinColumn(name = "id_genero", nullable = false,
            foreignKey = @ForeignKey(name = "fk_conductor_genero"))
    private Genero genero;

    @NotNull(message = "El campo: apellidoPaterno, no debe de ser nulo.")
    @NotEmpty(message = "El campo: apellidoPaterno, no debe ser vacio.")
    @Size(min = 3, max = 35, message = "El apellido paterno debe de tener como minimo 3 caracteres y como maximo 35.")
    @Column(name = "apellido_paterno", nullable = false, length = 35)
    private String apellidoPaterno;

    @NotNull(message = "El campo: apellidoMaterno, no debe de ser nulo.")
    @NotEmpty(message = "El campo: apellidoMaterno, no debe ser vacio.")
    @Size(min = 3, max = 35, message = "El apellido materno debe de tener como minimo 3 caracteres y como maximo 35.")
    @Column(name = "apellido_materno", nullable = false, length = 35)
    private String apellidoMaterno;

    @NotNull(message = "El campo: dni, no debe de ser nulo.")
    @NotEmpty(message = "El campo: dni, no debe ser vacio.")
    @Size(min = 8, max = 8, message = "El dni debe de tener 8 digitos")
    @Column(name = "dni", nullable = false, length = 8, unique = true)
    private String dni;

    @NotNull(message = "El campo: edad, no debe de ser nulo.")
    @NotEmpty(message = "El campo: edad, no debe ser vacio.")
    @Column(name = "edad", nullable = false)
    private String edad;

    @NotEmpty(message = "El campo: telefono, no debe ser vacio.")
    @Size(min = 9, max = 9, message = "El número de telefono debe de tener 9 digitos.")
    @Column(name = "telefono", nullable = true, length = 9, unique = true)
    private String telefono;

    @NotNull
    @Email
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Lob
    @Basic
    private byte[] foto;

    
    @NotNull(message = "El campo: estado, no debe ser nulo")
    @Column(name = "estado", nullable = false)
    private boolean estado;

    public Conductor() {
    }

    public Conductor(Integer idConductor, String nombres, Genero genero, String apellidoPaterno, String apellidoMaterno, String dni, String edad, String telefono, String email, byte[] foto, boolean estado) {
        this.idConductor = idConductor;
        this.nombres = nombres;
        this.genero = genero;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.dni = dni;
        this.edad = edad;
        this.telefono = telefono;
        this.email = email;
        this.foto = foto;
        this.estado = estado;
    }

    //TODO: metodos 
    public Integer getIdConductor() {
        return idConductor;
    }

    public void setIdConductor(Integer idConductor) {
        this.idConductor = idConductor;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
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

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
}
