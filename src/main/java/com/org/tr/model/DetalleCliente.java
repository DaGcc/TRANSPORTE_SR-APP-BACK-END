/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.org.tr.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "detalle_cliente")
public class DetalleCliente implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetalleCliente;

    @NotNull( message ="El campo: cliente, no debe ser nulo." )
    @JsonIgnoreProperties(value = {"detalleCliente"})
    @OneToOne //@OneToOne(targetEntity = Cliente.class)
    @JoinColumn(name = "id_cliente", nullable = false, unique = true, 
            foreignKey = @ForeignKey(name = "fk_detalle_cliente_cliente"))
    private Cliente cliente;
   
    @NotNull( message ="El campo: genero, no debe ser nulo." )
    @ManyToOne
    @JoinColumn(name = "id_genero", nullable = false, 
            foreignKey = @ForeignKey(name = "fk_detalle_cliente_genero"))
    private Genero genero;

    @NotNull( message ="El campo: apellidoPaterno, no debe ser nulo." )
    @NotEmpty( message ="El campo: apellidoPaterno, no debe ser vacio." )
    @Size(min = 3, max = 35, message = "El apellido paterno debe de tener como minimo 3 caracteres y como maximo 35.")
    @Column(name = "apellido_paterno", nullable = false, length = 35)
    private String apellidoPaterno;

    @NotNull( message ="El campo: apellidoMaterno, no debe ser nulo." )
    @NotEmpty( message ="El campo: apellidoMaterno, no debe ser vacio." )
    @Size(min = 3, max = 35, message = "El apellido materno debe de tener como minimo 3 caracteres y como maximo 35.")
    @Column(name = "apellido_materno", nullable = false, length = 35)
    private String apellidoMaterno;
    
    @NotNull( message ="El campo: dni, no debe ser nulo." )
    @NotEmpty( message ="El campo: dni, no debe ser vacio." )
    @Size(min = 8, max = 8, message = "El dni debe de tener 8 digitos")
    @Column(name = "dni", nullable = false, length = 8, unique = true)
    private String dni;
    
    @NotNull( message ="El campo: edad, no debe ser nulo." )
    @NotEmpty( message ="El campo: edad, no debe ser vacio." )
    @Size( min = 2, max = 3, message = "La edad solo se aceptan mayores de 18, y con un maxiom de 3 caracteres.")
    @Column( name = "edad", nullable = false, length = 3 )
    private String edad;
    
    @Lob
    @Basic
    private byte[] foto; 

    public DetalleCliente() {
    }

    public Integer getIdDetalleCliente() {
        return idDetalleCliente;
    }

    public void setIdDetalleCliente(Integer idDetalleCliente) {
        this.idDetalleCliente = idDetalleCliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    
    
}
