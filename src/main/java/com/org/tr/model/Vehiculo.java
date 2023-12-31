package com.org.tr.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "vehiculo")
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVehiculo;

    @NotNull(message = "El campo: tipoVehiculo, no debe ser nulo.")
    @ManyToOne
    @JoinColumn(name = "id_tipo_vehiculo", nullable = false, foreignKey = @ForeignKey(name = "fk_vehiculo_tipo_vehiculo"))
    private TipoVehiculo tipoVehiculo;

    @NotNull(message = "El campo: placa, no debe ser nulo.")
    @NotEmpty(message = "El campo: placa, no debe de estar vacio.")
    @Size(min = 7, max = 7, message = "El numero de placa del vehiculo debe de tener 7 digitos")
    @Column(name = "placa", nullable = false, length = 7, unique = true)
    private String placa;

    @Lob
    @Basic
    private byte[] foto;

    @NotNull(message = "no debe ser nulo")
    @NotEmpty(message = "no debe de estar vacio")
    @Size(min = 2, max = 20, message = "El color del vehiculo debe de tener como minimo 2 digitos y como maximo 20")
    @Column(name = "color_vehiculo", nullable = false, length = 20)
    private String colorVehiculo;

    @NotNull(message = "El campo: alto, no debe ser nulo.")
    @NotEmpty(message = "El campo: alto, no debe de estar vacio.")
    @Column(name = "alto", nullable = false, length = 10)
    private String alto;//tratarlo como string??

    @NotNull(message = "El campo: ancho, no debe ser nulo.")
    @NotEmpty(message = "El campo: ancho, no debe de estar vacio.")
    @Column(name = "ancho", nullable = false, length = 10)
    private String ancho;//tratarlo como string??

    @NotNull(message = "El campo: estado, no debe ser nulo.")
    @Column(name = "estado", nullable = false)
    private boolean estado;

    @JsonIgnoreProperties(value = {"vehiculo"}, allowSetters = true)
    @OneToMany(mappedBy = "vehiculo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleVehiculo> listaDetalleVehiculo;

    public Vehiculo() {
        this.listaDetalleVehiculo = new ArrayList<DetalleVehiculo>();
    }

    public Integer getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Integer idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getColorVehiculo() {
        return colorVehiculo;
    }

    public void setColorVehiculo(String colorVehiculo) {
        this.colorVehiculo = colorVehiculo;
    }

    public String getAlto() {
        return alto;
    }

    public void setAlto(String alto) {
        this.alto = alto;
    }

    public String getAncho() {
        return ancho;
    }

    public void setAncho(String ancho) {
        this.ancho = ancho;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public List<DetalleVehiculo> getListaDetalleVehiculo() {
        return listaDetalleVehiculo;
    }

    public void setListaDetalleVehiculo(List<DetalleVehiculo> listaDetalleVehiculo) {
        this.listaDetalleVehiculo.clear();
        if(listaDetalleVehiculo != null && !listaDetalleVehiculo.isEmpty()){
            listaDetalleVehiculo.forEach( this :: agregarDetalle );
        }
        
    }
    
    
    public void agregarDetalle( DetalleVehiculo detalleVehiculo) { 
        detalleVehiculo.setVehiculo(this);
        this.listaDetalleVehiculo.add(detalleVehiculo);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.idVehiculo);
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
        final Vehiculo other = (Vehiculo) obj;
        if (!Objects.equals(this.idVehiculo, other.idVehiculo)) {
            return false;
        }
        return true;
    }
    
    

}
