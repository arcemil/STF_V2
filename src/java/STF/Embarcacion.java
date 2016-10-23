/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package STF;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "embarcacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Embarcacion.findAll", query = "SELECT e FROM Embarcacion e"),
    @NamedQuery(name = "Embarcacion.findByIdEmbarcacion", query = "SELECT e FROM Embarcacion e WHERE e.idEmbarcacion = :idEmbarcacion"),
    @NamedQuery(name = "Embarcacion.findByEstadoEmbarcacion", query = "SELECT e FROM Embarcacion e WHERE e.estadoEmbarcacion = :estadoEmbarcacion"),
    @NamedQuery(name = "Embarcacion.findByLatitud", query = "SELECT e FROM Embarcacion e WHERE e.latitud = :latitud"),
    @NamedQuery(name = "Embarcacion.findByLongitud", query = "SELECT e FROM Embarcacion e WHERE e.longitud = :longitud"),
    @NamedQuery(name = "Embarcacion.findByFecha", query = "SELECT e FROM Embarcacion e WHERE e.fecha = :fecha"),
    @NamedQuery(name = "Embarcacion.findByHora", query = "SELECT e FROM Embarcacion e WHERE e.hora = :hora")})
public class Embarcacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_EMBARCACION")
    private Short idEmbarcacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "ESTADO_EMBARCACION")
    private String estadoEmbarcacion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "LATITUD")
    private BigDecimal latitud;
    @Column(name = "LONGITUD")
    private BigDecimal longitud;
    @Size(max = 10)
    @Column(name = "fecha")
    private String fecha;
    @Size(max = 10)
    @Column(name = "hora")
    private String hora;
    @JoinColumn(name = "TIPO_EMBARCACION", referencedColumnName = "ID_EMBARCACION")
    @ManyToOne(optional = false)
    private TipoEmbarcacion tipoEmbarcacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "embarcacion")
    private Collection<Viajes> viajesCollection;

    public Embarcacion() {
    }

    public Embarcacion(Short idEmbarcacion) {
        this.idEmbarcacion = idEmbarcacion;
    }

    public Embarcacion(Short idEmbarcacion, String estadoEmbarcacion) {
        this.idEmbarcacion = idEmbarcacion;
        this.estadoEmbarcacion = estadoEmbarcacion;
    }

    public Short getIdEmbarcacion() {
        return idEmbarcacion;
    }

    public void setIdEmbarcacion(Short idEmbarcacion) {
        this.idEmbarcacion = idEmbarcacion;
    }

    public String getEstadoEmbarcacion() {
        return estadoEmbarcacion;
    }

    public void setEstadoEmbarcacion(String estadoEmbarcacion) {
        this.estadoEmbarcacion = estadoEmbarcacion;
    }

    public BigDecimal getLatitud() {
        return latitud;
    }

    public void setLatitud(BigDecimal latitud) {
        this.latitud = latitud;
    }

    public BigDecimal getLongitud() {
        return longitud;
    }

    public void setLongitud(BigDecimal longitud) {
        this.longitud = longitud;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public TipoEmbarcacion getTipoEmbarcacion() {
        return tipoEmbarcacion;
    }

    public void setTipoEmbarcacion(TipoEmbarcacion tipoEmbarcacion) {
        this.tipoEmbarcacion = tipoEmbarcacion;
    }

    @XmlTransient
    public Collection<Viajes> getViajesCollection() {
        return viajesCollection;
    }

    public void setViajesCollection(Collection<Viajes> viajesCollection) {
        this.viajesCollection = viajesCollection;
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
        if (!(object instanceof Embarcacion)) {
            return false;
        }
        Embarcacion other = (Embarcacion) object;
        if ((this.idEmbarcacion == null && other.idEmbarcacion != null) || (this.idEmbarcacion != null && !this.idEmbarcacion.equals(other.idEmbarcacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "STF.Embarcacion[ idEmbarcacion=" + idEmbarcacion + " ]";
    }
    
}
