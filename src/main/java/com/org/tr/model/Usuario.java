package com.org.tr.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    @NotNull(message = "El campo: email, no debe ser nulo.")
    @NotEmpty(message = "El campo: password, no debe ser vacio.")
    @Size(min = 8, message = "El password, debe contener como minimo 8 caracteres y como maximo 15.")
    @Column(name = "password", nullable = false)
    private String password;

    @NotNull(message = "El campo: email, no debe ser nulo.")
    @Email(message = "Ingrese de manera correcta la direccion email.")
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @NotNull(message = "El campo: estado, no debe ser nulo")
    @Column(name = "estado", nullable = false)
    private boolean estado;
    
    
    @NotNull(message = "El campo: nonLocked, no debe ser nulo")
    @Column(name = "non_locked", nullable = false)
    private boolean nonLocked;

    @JsonSerialize(using = ToStringSerializer.class)
    private LocalDateTime fechaCreacion;

    //otra forma de  hacer la tabla intermedia de muchos a muchos
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_rol",
            joinColumns = {@JoinColumn(name = "id_usuario", referencedColumnName = "idUsuario")},
            inverseJoinColumns = @JoinColumn(name = "id_rol", referencedColumnName = "idRol"),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"id_usuario", "id_rol"})})
    private List<Rol> listaRole;

    public Usuario() {
        this.listaRole = new ArrayList<>();
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public boolean isNonLocked() {
        return nonLocked;
    }

    public void setNonLocked(boolean nonLocked) {
        this.nonLocked = nonLocked;
    }
    
    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Rol> getListaRole() {
        return listaRole;
    }

    public void setListaRole(List<Rol> listaRole) {
        this.listaRole = listaRole;
    }

}
