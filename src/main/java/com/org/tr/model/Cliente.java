/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.org.tr.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Objects;
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
    
    @NotNull( message = "El campo: nombres, no debe de ser nulo.")
    @NotEmpty( message = "El campo: nombres, no debe ser vacio." )
    @Size( min = 3, max = 35, message = "El nombre debe de tener como minimo 3 caracteres y como maximo 35." )
    @Column( name = "nombres", nullable = false, length = 35 )
    private String nombres;
    
    
    @NotEmpty( message = "El campo: telefono, no debe ser vacio." )
    @Size( min = 9, max = 9, message = "El número de telefono debe de tener 9 digitos." )
    @Column( name = "telefono", nullable = true, length = 9, unique = true )
    private String telefono;
    
    @NotNull( message ="El campo: email, no debe ser nulo." )
    @Email( message = "Ingrese de manera correcta la direccion email.")
    @Column( name = "email", nullable = false, unique = true )
    private String email;
    
    
    @NotNull(message = "El campo: estado, no debe ser nulo")
    @Column(name = "estado", nullable = false)
    private boolean estado;

    @NotNull( message ="El campo: tipoCliente, no debe ser nulo." )
    @ManyToOne
    @JoinColumn( name="id_tipo_cliente",nullable = false, foreignKey = @ForeignKey( name = "fk_cliente_tipo_cliente" )  )
    private TipoCliente tipoCliente;
    
    
    //no envies este campo si deseas eliminar su detalle
    @JsonIgnoreProperties( value = {"cliente"}, allowSetters = true )
    @OneToOne( mappedBy="cliente", cascade = CascadeType.ALL , orphanRemoval = true )
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

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    //TODO: metodos

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
        /**
         * Pero es mejor no, por motivos de que el orphanremoval no funcionaria correctamente
         * ya que el set se ejecutaria y siempre se le estableseria un cliente al detalleCliente
         * 
         *  detalleCliente.setCliente(this); //este es el problema, siempre le setea un cliente, aunque no lo enviemos en el JSON
         *  //evitamos logica en el service
         *  this.detalleCliente = detalleCliente;
         * 
         * Ahora, con una logica adicional de esta forma evitariamos el problema antes mencionado:
         */
        if(detalleCliente != null){
            detalleCliente.setCliente(this);
            //evitamos logica en el service
        }
        this.detalleCliente = detalleCliente;

    }
    
    public void removerDetalleCliente(){
        this.detalleCliente.setCliente(null);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + Objects.hashCode(this.idCliente);
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
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.idCliente, other.idCliente)) {
            return false;
        }
        return true;
    }
    
    
    
}
