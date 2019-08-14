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
@Table(name = "JUGADAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jugadas.findAll", query = "SELECT j FROM Jugadas j")
    , @NamedQuery(name = "Jugadas.findByIdJugada", query = "SELECT j FROM Jugadas j WHERE j.idJugada = :idJugada")
    , @NamedQuery(name = "Jugadas.findByJugador", query = "SELECT j FROM Jugadas j WHERE j.jugador = :jugador")
    , @NamedQuery(name = "Jugadas.findByGano", query = "SELECT j FROM Jugadas j WHERE j.gano = :gano")})
public class Jugadas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_JUGADA")
    private Integer idJugada;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "JUGADOR")
    private String jugador;
    @Size(max = 5)
    @Column(name = "GANO")
    private String gano;
    @JoinColumn(name = "PALABRA", referencedColumnName = "ID_PALABRA")
    @ManyToOne
    private Palabra palabra;

    public Jugadas() {
    }

    public Jugadas(Integer idJugada) {
        this.idJugada = idJugada;
    }

    public Jugadas(Integer idJugada, String jugador) {
        this.idJugada = idJugada;
        this.jugador = jugador;
    }

    public Integer getIdJugada() {
        return idJugada;
    }

    public void setIdJugada(Integer idJugada) {
        this.idJugada = idJugada;
    }

    public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    public String getGano() {
        return gano;
    }

    public void setGano(String gano) {
        this.gano = gano;
    }

    public Palabra getPalabra() {
        return palabra;
    }

    public void setPalabra(Palabra palabra) {
        this.palabra = palabra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idJugada != null ? idJugada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jugadas)) {
            return false;
        }
        Jugadas other = (Jugadas) object;
        if ((this.idJugada == null && other.idJugada != null) || (this.idJugada != null && !this.idJugada.equals(other.idJugada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jwapahorcado.model.Jugadas[ idJugada=" + idJugada + " ]";
    }
    
}
