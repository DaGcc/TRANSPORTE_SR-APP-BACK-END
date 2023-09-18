/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.org.tr.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table( name = "cliente" )
public class Cliente implements Serializable {
    
       
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer idCliente;
    
    @Size( min = 11, max = 11, message = "El RUC debe de tener once digitos." )
    @Column( name = "ruc", nullable = true, length = 11, unique = true )
    private String ruc; 
    
    @NotNull
    @NotEmpty
    @Size( min = 3, max = 35, message = "El nombre debe de tener como minimo 3 caracteres y como maximo 35." )
    @Column( name = "nombres", nullable = false, length = 35 )
    private String nombres;
    
    @NotNull
    @NotEmpty
    @Size( min = 9, max = 9, message = "El número de telefono debe de tener 9 digitos." )
    @Column( name = "telefono", nullable = true, length = 9, unique = true )
    private String telefono;
    
    @NotNull
    @Email
    @Column( name = "email", nullable = false, unique = true )
    private String email;
    
    @NotNull
    @Column( name = "estado", nullable = false )
    private boolean estado; 

    @NotNull
    @ManyToOne
    @JoinColumn( name="id_tipo_cliente",nullable = false, foreignKey = @ForeignKey( name = "fk_cliente_tipo_cliente" )  )
    private TipoCliente tipoCliente;
    
    
    @JsonIgnoreProperties( value = {"cliente"}, allowSetters = true )
    @OneToOne( mappedBy="cliente" , cascade = CascadeType.ALL , orphanRemoval = true )
    private DetalleCliente detalleCliente;
    
    public Cliente() {
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getNombre() {
        return nombres;
    }

    public void setNombre(String nombres) {
        this.nombres = nombres;
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

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public DetalleCliente getDetalleCliente() {
        return detalleCliente;
    }

    public void setDetalleCliente(DetalleCliente detalleCliente) {
        this.detalleCliente = detalleCliente;
    }
    
    
    
    
}
