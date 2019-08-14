/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica01;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author drone
 */
@Entity
@Table(name = "ESTUDIANTE", catalog = "", schema = "SAUL")
@NamedQueries({
    @NamedQuery(name = "Estudiante.findAll", query = "SELECT e FROM Estudiante e")
    , @NamedQuery(name = "Estudiante.findByNoControl", query = "SELECT e FROM Estudiante e WHERE e.noControl = :noControl")
    , @NamedQuery(name = "Estudiante.findByNombre", query = "SELECT e FROM Estudiante e WHERE e.nombre = :nombre")
    , @NamedQuery(name = "Estudiante.findByEdad", query = "SELECT e FROM Estudiante e WHERE e.edad = :edad")
    , @NamedQuery(name = "Estudiante.findBySexo", query = "SELECT e FROM Estudiante e WHERE e.sexo = :sexo")
    , @NamedQuery(name = "Estudiante.findBySemestre", query = "SELECT e FROM Estudiante e WHERE e.semestre = :semestre")
    , @NamedQuery(name = "Estudiante.findByCreditos", query = "SELECT e FROM Estudiante e WHERE e.creditos = :creditos")})
public class Estudiante implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NO_CONTROL")
    private Integer noControl;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "EDAD")
    private Integer edad;
    @Column(name = "SEXO")
    private String sexo;
    @Column(name = "SEMESTRE")
    private Integer semestre;
    @Column(name = "CREDITOS")
    private Integer creditos;
    @JoinColumn(name = "CARRERA", referencedColumnName = "IDCARRERA")
    @ManyToOne(optional = false)
    private Carrera carrera;

    public Estudiante() {
    }

    public Estudiante(Integer noControl) {
        this.noControl = noControl;
    }

    public Integer getNoControl() {
        return noControl;
    }

    public void setNoControl(Integer noControl) {
        Integer oldNoControl = this.noControl;
        this.noControl = noControl;
        changeSupport.firePropertyChange("noControl", oldNoControl, noControl);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        String oldNombre = this.nombre;
        this.nombre = nombre;
        changeSupport.firePropertyChange("nombre", oldNombre, nombre);
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        Integer oldEdad = this.edad;
        this.edad = edad;
        changeSupport.firePropertyChange("edad", oldEdad, edad);
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        String oldSexo = this.sexo;
        this.sexo = sexo;
        changeSupport.firePropertyChange("sexo", oldSexo, sexo);
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        Integer oldSemestre = this.semestre;
        this.semestre = semestre;
        changeSupport.firePropertyChange("semestre", oldSemestre, semestre);
    }

    public Integer getCreditos() {
        return creditos;
    }

    public void setCreditos(Integer creditos) {
        Integer oldCreditos = this.creditos;
        this.creditos = creditos;
        changeSupport.firePropertyChange("creditos", oldCreditos, creditos);
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        Carrera oldCarrera = this.carrera;
        this.carrera = carrera;
        changeSupport.firePropertyChange("carrera", oldCarrera, carrera);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (noControl != null ? noControl.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudiante)) {
            return false;
        }
        Estudiante other = (Estudiante) object;
        if ((this.noControl == null && other.noControl != null) || (this.noControl != null && !this.noControl.equals(other.noControl))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "practica01.Estudiante[ noControl=" + noControl + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
