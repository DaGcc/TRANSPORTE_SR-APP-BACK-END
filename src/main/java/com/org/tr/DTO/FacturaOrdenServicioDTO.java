/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.org.tr.DTO;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//sirve como ayuda para las validaciones
public class FacturaOrdenServicioDTO {
    
    /**
     * Atributos de factura
     */
    private Integer idFactura;

    @NotNull(message ="El campo: codigoFactura, no debe ser nulo.")
    @NotEmpty(message ="El campo: codigoFactura, no debe eestar vacio.")
    @Size(max = 30, message = "El codigoFactura debe de tener 30 digitos como maximo.")
    private String codigoFactura;

    @NotNull(message ="El campo: fechaFactura, no debe ser nulo.")
    @NotEmpty(message ="El campo: fechaFactura, no debe eestar vacio.")
    private String fechaFactura;
   
    @NotNull(message = "El campo: estado, no debe ser nulo")
    private boolean estadoFactura;
       
    
    
    /**
     * Atributos de la clase OrdenServicio
     */
    
    private Integer idOrdenServicio;
    
    @NotNull(message ="El campo: codigoOrden, no debe ser nulo.")
    @NotEmpty(message ="El campo: codigoOrden, no debe eestar vacio.")
    @Size(max = 30, message = "El codigoOrden debe de tener como maximo 30 digitos.")
    private String codigoOrden;
    
    @NotNull(message ="El campo: fechaOrden, no debe ser nulo.")
    @NotEmpty(message ="El campo: fechaOrden, no debe eestar vacio.")
    private String fechaOrden;

    @NotNull(message = "El campo: estado, no debe ser nulo")
    private boolean estadoOrden;

    
    
    //Todo: metodos aqui
    
    public Integer getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public String getCodigoFactura() {
        return codigoFactura;
    }

    public void setCodigoFactura(String codigoFactura) {
        this.codigoFactura = codigoFactura;
    }

    public String getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(String fechaFactura) {
        this.fechaFactura = fechaFactura;
    }
    
    
    public boolean isEstadoFactura() {
        return estadoFactura;
    }

    public void setEstadoFactura(boolean estadoFactura) {
        this.estadoFactura = estadoFactura;
    }

    public Integer getIdOrdenServicio() {
        return idOrdenServicio;
    }

    public void setIdOrdenServicio(Integer idOrdenServicio) {
        this.idOrdenServicio = idOrdenServicio;
    }

    public String getCodigoOrden() {
        return codigoOrden;
    }

    public void setCodigoOrden(String codigoOrden) {
        this.codigoOrden = codigoOrden;
    }

    public String getFechaOrden() {
        return fechaOrden;
    }

    public void setFechaOrden(String fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    

    public boolean isEstadoOrden() {
        return estadoOrden;
    }

    public void setEstadoOrden(boolean estadoOrden) {
        this.estadoOrden = estadoOrden;
    }
    
    
    

}
