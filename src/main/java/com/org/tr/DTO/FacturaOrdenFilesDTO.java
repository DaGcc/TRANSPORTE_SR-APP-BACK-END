/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.org.tr.DTO;

import com.org.tr.model.ArchivoFactura;
import com.org.tr.model.ArchivoOrdenServicio;
import com.org.tr.model.Factura;

public class FacturaOrdenFilesDTO {
   
    private Factura factura;
    
    private ArchivoFactura archivoFactura;
    
    private ArchivoOrdenServicio archivoOrdenServicio;

    
    
    public FacturaOrdenFilesDTO(Factura factura, ArchivoFactura archivoFactura, ArchivoOrdenServicio archivoOrdenServicio) {
        this.factura = factura;
        this.archivoFactura = archivoFactura;
        this.archivoOrdenServicio = archivoOrdenServicio;
    }
    
    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public ArchivoFactura getArchivoFactura() {
        return archivoFactura;
    }

    public void setArchivoFactura(ArchivoFactura archivoFactura) {
        this.archivoFactura = archivoFactura;
    }

    public ArchivoOrdenServicio getArchivoOrdenServicio() {
        return archivoOrdenServicio;
    }

    public void setArchivoOrdenServicio(ArchivoOrdenServicio archivoOrdenServicio) {
        this.archivoOrdenServicio = archivoOrdenServicio;
    }
    
    
    
}
