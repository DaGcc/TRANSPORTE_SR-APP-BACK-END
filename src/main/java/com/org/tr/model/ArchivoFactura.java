/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.org.tr.model;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "archivo_factura")
public class ArchivoFactura implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idArchivoFactura;
    
    
    @NotNull
    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "id_factura", 
            foreignKey = @ForeignKey(name ="fk_archivo_factura_factura"),
            unique = true, nullable = false)
    private Factura factura;

   
    @Lob
    @Basic
    private byte[] data;
    
    @Size(max = 50, message ="El nombre del archivo no debe ser mayor a 50 caracteres.")
    @Column(name = "nombre", length = 50)
    private String nombre;
    
    
    @Column(name = "type")
    private String type;
    
    

    public Integer getIdArchivoFactura() {
        return idArchivoFactura;
    }

    public void setIdArchivoFactura(Integer idArchivoFactura) {
        this.idArchivoFactura = idArchivoFactura;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
}
