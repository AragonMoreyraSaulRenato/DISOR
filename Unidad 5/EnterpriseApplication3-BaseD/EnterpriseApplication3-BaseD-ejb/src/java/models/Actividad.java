/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author drone
 */
@Entity
@Table(name = "ACTIVIDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Actividad.findAll", query = "SELECT a FROM Actividad a")
    , @NamedQuery(name = "Actividad.findByIdAct", query = "SELECT a FROM Actividad a WHERE a.idAct = :idAct")
    , @NamedQuery(name = "Actividad.findByNombre", query = "SELECT a FROM Actividad a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "Actividad.findByDescripcion", query = "SELECT a FROM Actividad a WHERE a.descripcion = :descripcion")})
public class Actividad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ACT")
    private Integer idAct;
    @Size(max = 30)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 50)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(mappedBy = "idAct")
    private List<Medicion> medicionList;

    public Actividad() {
    }

    public Actividad(Integer idAct) {
        this.idAct = idAct;
    }

    public Integer getIdAct() {
        return idAct;
    }

    public void setIdAct(Integer idAct) {
        this.idAct = idAct;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Medicion> getMedicionList() {
        return medicionList;
    }

    public void setMedicionList(List<Medicion> medicionList) {
        this.medicionList = medicionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAct != null ? idAct.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actividad)) {
            return false;
        }
        Actividad other = (Actividad) object;
        if ((this.idAct == null && other.idAct != null) || (this.idAct != null && !this.idAct.equals(other.idAct))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Actividad[ idAct=" + idAct + " ]";
    }
    
}
