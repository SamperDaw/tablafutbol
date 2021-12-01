/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "futbolistas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Futbolistas.findAll", query = "SELECT f FROM Futbolistas f"),
    @NamedQuery(name = "Futbolistas.findById", query = "SELECT f FROM Futbolistas f WHERE f.id = :id"),
    @NamedQuery(name = "Futbolistas.findByNombre", query = "SELECT f FROM Futbolistas f WHERE f.nombre = :nombre"),
    @NamedQuery(name = "Futbolistas.findByApellidos", query = "SELECT f FROM Futbolistas f WHERE f.apellidos = :apellidos"),
    @NamedQuery(name = "Futbolistas.findByDorsal", query = "SELECT f FROM Futbolistas f WHERE f.dorsal = :dorsal"),
    @NamedQuery(name = "Futbolistas.findByEquipo", query = "SELECT f FROM Futbolistas f WHERE f.equipo = :equipo")})
public class Futbolistas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dorsal")
    private int dorsal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "equipo")
    private String equipo;

    public Futbolistas() {
    }

    public Futbolistas(Integer id) {
        this.id = id;
    }

    public Futbolistas(Integer id, String nombre, String apellidos, int dorsal, String equipo) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dorsal = dorsal;
        this.equipo = equipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Futbolistas)) {
            return false;
        }
        Futbolistas other = (Futbolistas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Futbolistas[ id=" + id + " ]";
    }
    
}
