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

@Entity
@Table( name = "combustible" )
public class Combustible {
    
        
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer idCombustible;
    
   
    @Column( name = "tipo", nullable = false, length = 35 )
    private String tipo;

    public Combustible() {
    }
    

    public Combustible(Integer idCombustible, String tipo) {
        this.idCombustible = idCombustible;
        this.tipo = tipo;
    }
    
    
    public Integer getIdCombustible() {
        return idCombustible;
    }

    public void setIdCombustible(Integer idCombustible) {
        this.idCombustible = idCombustible;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
        
    

}
