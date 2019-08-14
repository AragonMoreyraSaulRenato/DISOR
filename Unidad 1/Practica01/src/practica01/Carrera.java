/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica01;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author drone
 */
@Entity
@Table(name = "CARRERA", catalog = "", schema = "SAUL")
@NamedQueries({
    @NamedQuery(name = "Carrera.findAll", query = "SELECT c FROM Carrera c")
    , @NamedQuery(name = "Carrera.findByIdcarrera", query = "SELECT c FROM Carrera c WHERE c.idcarrera = :idcarrera")
    , @NamedQuery(name = "Carrera.findByNombre", query = "SELECT c FROM Carrera c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Carrera.findByCreditos", query = "SELECT c FROM Carrera c WHERE c.creditos = :creditos")})
public class Carrera implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDCARRERA")
    private Integer idcarrera;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "CREDITOS")
    private Integer creditos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carrera")
    private List<Estudiante> estudianteList;

    public Carrera() {
    }

    public Carrera(Integer idcarrera) {
        this.idcarrera = idcarrera;
    }

    public Integer getIdcarrera() {
        return idcarrera;
    }

    public void setIdcarrera(Integer idcarrera) {
        Integer oldIdcarrera = this.idcarrera;
        this.idcarrera = idcarrera;
        changeSupport.firePropertyChange("idcarrera", oldIdcarrera, idcarrera);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        String oldNombre = this.nombre;
        this.nombre = nombre;
        changeSupport.firePropertyChange("nombre", oldNombre, nombre);
    }

    public Integer getCreditos() {
        return creditos;
    }

    public void setCreditos(Integer creditos) {
        Integer oldCreditos = this.creditos;
        this.creditos = creditos;
        changeSupport.firePropertyChange("creditos", oldCreditos, creditos);
    }

    public List<Estudiante> getEstudianteList() {
        return estudianteList;
    }

    public void setEstudianteList(List<Estudiante> estudianteList) {
        this.estudianteList = estudianteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcarrera != null ? idcarrera.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carrera)) {
            return false;
        }
        Carrera other = (Carrera) object;
        if ((this.idcarrera == null && other.idcarrera != null) || (this.idcarrera != null && !this.idcarrera.equals(other.idcarrera))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "practica01.Carrera[ idcarrera=" + idcarrera + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
