/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.org.tr.model;
import java.io.Serializable;
import java.util.Objects;
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
@Table(name = "archivo_orden_servicio")
public class ArchivoOrdenServicio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idArchivoOrdenServicio;
    
    
    @NotNull
    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "id_orden_servicio", 
            foreignKey = @ForeignKey(name ="fk_archivo_orden_servicio_orden_servicio"),
            unique = true,
            nullable = false)
    private OrdenServicio ordenServicio;

   
    @Lob
    @Basic
    private byte[] data;
    
    @Size(max = 50, message ="El nombre del archivo no debe ser mayor a 50 caracteres.")
    @Column(name = "nombre", length = 50)
    private String nombre;
    
    
    @Column(name = "type")
    private String type;
    
    

    public Integer getIdArchivoOrdenServicio() {
        return idArchivoOrdenServicio;
    }

    public void setIdArchivoOrdenServicio(Integer idArchivoOrdenServicio) {
        this.idArchivoOrdenServicio = idArchivoOrdenServicio;
    }

    public OrdenServicio getOrdenServicio() {
        return ordenServicio;
    }

    public void setOrdenServicio(OrdenServicio ordenServicio) {
        this.ordenServicio = ordenServicio;
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
    
    
    
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.idArchivoOrdenServicio);
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
        final ArchivoOrdenServicio other = (ArchivoOrdenServicio) obj;
        if (!Objects.equals(this.idArchivoOrdenServicio, other.idArchivoOrdenServicio)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}
