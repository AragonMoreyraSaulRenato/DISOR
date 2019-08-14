/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jwapahorcado.model;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author drone
 */
@Entity
@Table(name = "PALABRA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Palabra.findAll", query = "SELECT p FROM Palabra p")
    , @NamedQuery(name = "Palabra.findByIdPalabra", query = "SELECT p FROM Palabra p WHERE p.idPalabra = :idPalabra")
    , @NamedQuery(name = "Palabra.findByPalabra", query = "SELECT p FROM Palabra p WHERE p.palabra = :palabra")
    , @NamedQuery(name = "Palabra.findByNivel", query = "SELECT p FROM Palabra p WHERE p.nivel = :nivel")})
public class Palabra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PALABRA")
    private Integer idPalabra;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "PALABRA")
    private String palabra;
    @Column(name = "NIVEL")
    private Integer nivel;
    @JoinColumn(name = "TIPO", referencedColumnName = "ID_TIPO")
    @ManyToOne
    private Tipo tipo;

    public Palabra() {
    }

    public Palabra(Integer idPalabra) {
        this.idPalabra = idPalabra;
    }

    public Palabra(Integer idPalabra, String palabra) {
        this.idPalabra = idPalabra;
        this.palabra = palabra;
    }

    public Integer getIdPalabra() {
        return idPalabra;
    }

    public void setIdPalabra(Integer idPalabra) {
        this.idPalabra = idPalabra;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPalabra != null ? idPalabra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Palabra)) {
            return false;
        }
        Palabra other = (Palabra) object;
        if ((this.idPalabra == null && other.idPalabra != null) || (this.idPalabra != null && !this.idPalabra.equals(other.idPalabra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jwapahorcado.model.Palabra[ idPalabra=" + idPalabra + " ]";
    }
    
}
