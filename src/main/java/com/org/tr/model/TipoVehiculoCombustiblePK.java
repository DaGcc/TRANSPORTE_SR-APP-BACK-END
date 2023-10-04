
package com.org.tr.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Embeddable
public class TipoVehiculoCombustiblePK implements Serializable  {

    @NotNull( message = "El campo: tipoVehiculo, no debe ser nulo.")
    @ManyToOne
    @JoinColumn(name = "id_tipo_vehiculo", nullable = false, 
            foreignKey = @ForeignKey(name="fk_tipo_vehiculo_combustible_tipo_vehiculo"))
    private TipoVehiculo tipoVehiculo;

    @NotNull( message = "El campo: combustible, no debe ser nulo.")
    @ManyToOne
    @JoinColumn(name = "id_combustible", nullable = false, 
            foreignKey = @ForeignKey(name="fk_tipo_vehiculo_combustible_combustible"))
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.tipoVehiculo);
        hash = 59 * hash + Objects.hashCode(this.combustible);
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
        final TipoVehiculoCombustiblePK other = (TipoVehiculoCombustiblePK) obj;
        if (!Objects.equals(this.tipoVehiculo, other.tipoVehiculo)) {
            return false;
        }
        if (!Objects.equals(this.combustible, other.combustible)) {
            return false;
        }
        return true;
    }
    
}
