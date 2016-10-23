/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package STF;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Julian Marin
 */
@Entity
@Table(name = "puertos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Puertos.findAll", query = "SELECT p FROM Puertos p"),
    @NamedQuery(name = "Puertos.findByIdPuerto", query = "SELECT p FROM Puertos p WHERE p.idPuerto = :idPuerto"),
    @NamedQuery(name = "Puertos.findByNombrePuerto", query = "SELECT p FROM Puertos p WHERE p.nombrePuerto = :nombrePuerto"),
    @NamedQuery(name = "Puertos.findByCoordenadas", query = "SELECT p FROM Puertos p WHERE p.coordenadas = :coordenadas")})
public class Puertos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PUERTO")
    private Short idPuerto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOMBRE_PUERTO")
    private String nombrePuerto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "COORDENADAS")
    private String coordenadas;

    public Puertos() {
    }

    public Puertos(Short idPuerto) {
        this.idPuerto = idPuerto;
    }

    public Puertos(Short idPuerto, String nombrePuerto, String coordenadas) {
        this.idPuerto = idPuerto;
        this.nombrePuerto = nombrePuerto;
        this.coordenadas = coordenadas;
    }

    public Short getIdPuerto() {
        return idPuerto;
    }

    public void setIdPuerto(Short idPuerto) {
        this.idPuerto = idPuerto;
    }

    public String getNombrePuerto() {
        return nombrePuerto;
    }

    public void setNombrePuerto(String nombrePuerto) {
        this.nombrePuerto = nombrePuerto;
    }

    public String getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(String coordenadas) {
        this.coordenadas = coordenadas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPuerto != null ? idPuerto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Puertos)) {
            return false;
        }
        Puertos other = (Puertos) object;
        if ((this.idPuerto == null && other.idPuerto != null) || (this.idPuerto != null && !this.idPuerto.equals(other.idPuerto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "STF.Puertos[ idPuerto=" + idPuerto + " ]";
    }
    
}
