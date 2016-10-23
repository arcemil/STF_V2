/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package STF;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author Julian Marin
 */
@Entity
@Table(name = "tipo__embarcacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoEmbarcacion.findAll", query = "SELECT t FROM TipoEmbarcacion t"),
    @NamedQuery(name = "TipoEmbarcacion.findByIdEmbarcacion", query = "SELECT t FROM TipoEmbarcacion t WHERE t.idEmbarcacion = :idEmbarcacion"),
    @NamedQuery(name = "TipoEmbarcacion.findByCapacidad", query = "SELECT t FROM TipoEmbarcacion t WHERE t.capacidad = :capacidad"),
    @NamedQuery(name = "TipoEmbarcacion.findByNombre", query = "SELECT t FROM TipoEmbarcacion t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TipoEmbarcacion.findByCalado", query = "SELECT t FROM TipoEmbarcacion t WHERE t.calado = :calado")})
public class TipoEmbarcacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_EMBARCACION")
    private Short idEmbarcacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CAPACIDAD")
    private int capacidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CALADO")
    private long calado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoEmbarcacion")
    private Collection<Embarcacion> embarcacionCollection;

    public TipoEmbarcacion() {
    }

    public TipoEmbarcacion(Short idEmbarcacion) {
        this.idEmbarcacion = idEmbarcacion;
    }

    public TipoEmbarcacion(Short idEmbarcacion, int capacidad, String nombre, long calado) {
        this.idEmbarcacion = idEmbarcacion;
        this.capacidad = capacidad;
        this.nombre = nombre;
        this.calado = calado;
    }

    public Short getIdEmbarcacion() {
        return idEmbarcacion;
    }

    public void setIdEmbarcacion(Short idEmbarcacion) {
        this.idEmbarcacion = idEmbarcacion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getCalado() {
        return calado;
    }

    public void setCalado(long calado) {
        this.calado = calado;
    }

    @XmlTransient
    public Collection<Embarcacion> getEmbarcacionCollection() {
        return embarcacionCollection;
    }

    public void setEmbarcacionCollection(Collection<Embarcacion> embarcacionCollection) {
        this.embarcacionCollection = embarcacionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmbarcacion != null ? idEmbarcacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoEmbarcacion)) {
            return false;
        }
        TipoEmbarcacion other = (TipoEmbarcacion) object;
        if ((this.idEmbarcacion == null && other.idEmbarcacion != null) || (this.idEmbarcacion != null && !this.idEmbarcacion.equals(other.idEmbarcacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "STF.TipoEmbarcacion[ idEmbarcacion=" + idEmbarcacion + " ]";
    }
    
}
