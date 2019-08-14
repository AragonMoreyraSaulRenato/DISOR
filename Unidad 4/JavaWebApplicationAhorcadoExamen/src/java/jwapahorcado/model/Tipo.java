/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jwapahorcado.model;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author drone
 */
@Entity
@Table(name = "TIPO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipo.findAll", query = "SELECT t FROM Tipo t")
    , @NamedQuery(name = "Tipo.findByIdTipo", query = "SELECT t FROM Tipo t WHERE t.idTipo = :idTipo")
    , @NamedQuery(name = "Tipo.findByDescripcion", query = "SELECT t FROM Tipo t WHERE t.descripcion = :descripcion")})
public class Tipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TIPO")
    private Integer idTipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(mappedBy = "tipo")
    private Collection<Palabra> palabraCollection;

    public Tipo() {
    }

    public Tipo(Integer idTipo) {
        this.idTipo = idTipo;
    }

    public Tipo(Integer idTipo, String descripcion) {
        this.idTipo = idTipo;
        this.descripcion = descripcion;
    }

    public Integer getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<Palabra> getPalabraCollection() {
        return palabraCollection;
    }

    public void setPalabraCollection(Collection<Palabra> palabraCollection) {
        this.palabraCollection = palabraCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipo != null ? idTipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipo)) {
            return false;
        }
        Tipo other = (Tipo) object;
        if ((this.idTipo == null && other.idTipo != null) || (this.idTipo != null && !this.idTipo.equals(other.idTipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jwapahorcado.model.Tipo[ idTipo=" + idTipo + " ]";
    }
    
}
