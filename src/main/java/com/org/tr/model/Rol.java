
package com.org.tr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="rol")
public class Rol {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idRol;
    
    @Size(min=2,max=45,message="EL CAMPO NOMBRE DEL ROL DEBE TENER COMO MINIMO 2 CARACTERES")
    @Column(name="nombre",nullable = false, length=50,unique=true)
    private String nombre;
    
    @NotNull(message = "El campo: descripcion, no debe de ser nulo.")
    @NotEmpty(message = "El campo: descripcion, no debe ser vacio.")
    @Size(min = 10, max = 150, message = "Como minimo brinda una descripción de 10 caracteres y como maximo 150.")
    @Column(name = "descripcion", length = 150, nullable = false)
    private String descripcion;
    
    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
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
    
    
}
