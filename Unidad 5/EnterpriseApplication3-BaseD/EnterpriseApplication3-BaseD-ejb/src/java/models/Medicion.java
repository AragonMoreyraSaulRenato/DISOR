/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author drone
 */
@Entity
@Table(name = "MEDICION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medicion.findAll", query = "SELECT m FROM Medicion m")
    , @NamedQuery(name = "Medicion.findByIdMedicion", query = "SELECT m FROM Medicion m WHERE m.idMedicion = :idMedicion")
    , @NamedQuery(name = "Medicion.findByFecha", query = "SELECT m FROM Medicion m WHERE m.fecha = :fecha")
    , @NamedQuery(name = "Medicion.findByPeso", query = "SELECT m FROM Medicion m WHERE m.peso = :peso")
    , @NamedQuery(name = "Medicion.findByCintura", query = "SELECT m FROM Medicion m WHERE m.cintura = :cintura")
    , @NamedQuery(name = "Medicion.findByCadera", query = "SELECT m FROM Medicion m WHERE m.cadera = :cadera")
    , @NamedQuery(name = "Medicion.findByIdPersona", query = "SELECT m FROM Medicion m WHERE m.idPersona = :idPersona")
    , @NamedQuery(name = "Medicion.findByFechaAndId", query = "SELECT m FROM Medicion m WHERE m.idPersona = :idPersona AND m.fecha = :fecha")})
public class Medicion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_MEDICION")
    private Integer idMedicion;
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PESO")
    private Double peso;
    @Column(name = "CINTURA")
    private Integer cintura;
    @Column(name = "CADERA")
    private Integer cadera;
    @JoinColumn(name = "ID_ACT", referencedColumnName = "ID_ACT")
    @ManyToOne
    private Actividad idAct;
    @JoinColumn(name = "ID_PERSONA", referencedColumnName = "ID_PERSONA")
    @ManyToOne
    private Persona idPersona;

    public Medicion() {
    }

    public Medicion(Integer idMedicion) {
        this.idMedicion = idMedicion;
    }

    public Integer getIdMedicion() {
        return idMedicion;
    }

    public void setIdMedicion(Integer idMedicion) {
        this.idMedicion = idMedicion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Integer getCintura() {
        return cintura;
    }

    public void setCintura(Integer cintura) {
        this.cintura = cintura;
    }

    public Integer getCadera() {
        return cadera;
    }

    public void setCadera(Integer cadera) {
        this.cadera = cadera;
    }

    public Actividad getIdAct() {
        return idAct;
    }

    public void setIdAct(Actividad idAct) {
        this.idAct = idAct;
    }

    public Persona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Persona idPersona) {
        this.idPersona = idPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMedicion != null ? idMedicion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medicion)) {
            return false;
        }
        Medicion other = (Medicion) object;
        if ((this.idMedicion == null && other.idMedicion != null) || (this.idMedicion != null && !this.idMedicion.equals(other.idMedicion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Medicion[ idMedicion=" + idMedicion + " ]";
    }
    
}
