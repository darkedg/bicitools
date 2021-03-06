/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bicitools.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TemporalType;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ludwing
 */
@Entity
@Table(name = "UsuarioRuta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioRuta.findAll", query = "SELECT t FROM UsuarioRuta t"),
    @NamedQuery(name = "UsuarioRuta.findByRuta", query = "SELECT t FROM UsuarioRuta t WHERE t.nombre = :ruta")})
public class UsuarioRuta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 45)
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario")
    private String usuario;
    @Size(max = 45)
   
    
    public UsuarioRuta() {
    }

    public UsuarioRuta(String nombre_) {
        this.nombre = nombre_;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nombre != null ? nombre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ruta)) {
            return false;
        }
        Ruta other = (Ruta) object;
        if ((this.nombre == null && other.getNombre ()!= null) || (this.nombre != null && !this.nombre.equals(other.getNombre() ))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bicitools.entity.Ruta[ nombre=" + nombre + " ]";
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
}
