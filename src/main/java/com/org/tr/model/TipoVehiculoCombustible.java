package com.org.tr.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@IdClass(TipoVehiculoCombustiblePK.class)
@Table(name="tipo_vehiculo_combustible", uniqueConstraints = @UniqueConstraint(columnNames = {"id_tipo_vehiculo","id_combustible"}) )
public class TipoVehiculoCombustible  implements Serializable {
    

    @Id
    private TipoVehiculo tipoVehiculo;

    @Id
    private Combustible combustible;

    
    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public Combustible getCombustible() {
        return combustible;
    }

    public void setCombustible(Combustible combustible) {
        this.combustible = combustible;
    }
    
}