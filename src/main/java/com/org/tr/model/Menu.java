package com.org.tr.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="menu")
public class Menu {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idMenu;

    @Column(name="nombre",nullable=false,length=70)
    private String nombre;
    
    @Column(name="icon",length=50)
    private String icon;
    
    @Column(name="url",nullable=false,length=100)
    private String url;
    
    
    @ManyToMany(fetch=FetchType.EAGER,cascade={CascadeType.ALL})
    @JoinTable(name="menu_rol",joinColumns=@JoinColumn(name="id_menu",referencedColumnName="idMenu"),
            inverseJoinColumns=@JoinColumn(name="id_rol",referencedColumnName="idRol"),
            uniqueConstraints={@UniqueConstraint(columnNames={"id_menu","id_rol"})})
    private List<Rol> roles;

    public Integer getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Integer idMenu) {
        this.idMenu = idMenu;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }   
    
}
