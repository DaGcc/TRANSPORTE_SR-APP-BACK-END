
package com.org.tr.DTO;

import com.org.tr.model.Combustible;
import com.org.tr.model.TipoVehiculo;
import java.util.List;

public class TipoVehiculoCombustibleDTO {
    
    
    TipoVehiculo tipovehiculo;
    
    
    List<Combustible> listaCombustibles;

    public TipoVehiculo getTipovehiculo() {
        return tipovehiculo;
    }

    public void setTipovehiculo(TipoVehiculo tipovehiculo) {
        this.tipovehiculo = tipovehiculo;
    }

    public List<Combustible> getListaCombustibles() {
        return listaCombustibles;
    }

    public void setListaCombustibles(List<Combustible> listaCombustibles) {
        this.listaCombustibles = listaCombustibles;
    }
    
    
}
