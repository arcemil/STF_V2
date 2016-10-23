/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package STF;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Julian Marin
 */
@Entity
@Table(name = "viajes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Viajes.findAll", query = "SELECT v FROM Viajes v"),
    @NamedQuery(name = "Viajes.findByIdViajes", query = "SELECT v FROM Viajes v WHERE v.idViajes = :idViajes"),
    @NamedQuery(name = "Viajes.findByOrigen", query = "SELECT v FROM Viajes v WHERE v.origen = :origen"),
    @NamedQuery(name = "Viajes.findByDestino", query = "SELECT v FROM Viajes v WHERE v.destino = :destino"),
    @NamedQuery(name = "Viajes.findByFecha", query = "SELECT v FROM Viajes v WHERE v.fecha = :fecha"),
    @NamedQuery(name = "Viajes.findByProblema", query = "SELECT v FROM Viajes v WHERE v.problema = :problema")})
public class Viajes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_VIAJES")
    private Integer idViajes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ORIGEN")
    private short origen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DESTINO")
    private short destino;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "PROBLEMA")
    private Integer problema;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "viaje")
    private Collection<Problemas> problemasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "viaje")
    private Collection<ViajeUsuarios> viajeUsuariosCollection;
    @JoinColumn(name = "CANOERO", referencedColumnName = "ID_CANOERO")
    @ManyToOne(optional = false)
    private Canoero canoero;
    @JoinColumn(name = "EMBARCACION", referencedColumnName = "ID_EMBARCACION")
    @ManyToOne(optional = false)
    private Embarcacion embarcacion;
    @JoinColumn(name = "HORARIO_REAL", referencedColumnName = "ID_HORARIOS")
    @ManyToOne(optional = false)
    private Horarios horarioReal;
    @JoinColumn(name = "HORARIO_PROGRAMADO", referencedColumnName = "ID_HORARIOS")
    @ManyToOne(optional = false)
    private Horarios horarioProgramado;

    public Viajes() {
    }

    public Viajes(Integer idViajes) {
        this.idViajes = idViajes;
    }

    public Viajes(Integer idViajes, short origen, short destino, Date fecha) {
        this.idViajes = idViajes;
        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;
    }

    public Integer getIdViajes() {
        return idViajes;
    }

    public void setIdViajes(Integer idViajes) {
        this.idViajes = idViajes;
    }

    public short getOrigen() {
        return origen;
    }

    public void setOrigen(short origen) {
        this.origen = origen;
    }

    public short getDestino() {
        return destino;
    }

    public void setDestino(short destino) {
        this.destino = destino;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getProblema() {
        return problema;
    }

    public void setProblema(Integer problema) {
        this.problema = problema;
    }

    @XmlTransient
    public Collection<Problemas> getProblemasCollection() {
        return problemasCollection;
    }

    public void setProblemasCollection(Collection<Problemas> problemasCollection) {
        this.problemasCollection = problemasCollection;
    }

    @XmlTransient
    public Collection<ViajeUsuarios> getViajeUsuariosCollection() {
        return viajeUsuariosCollection;
    }

    public void setViajeUsuariosCollection(Collection<ViajeUsuarios> viajeUsuariosCollection) {
        this.viajeUsuariosCollection = viajeUsuariosCollection;
    }

    public Canoero getCanoero() {
        return canoero;
    }

    public void setCanoero(Canoero canoero) {
        this.canoero = canoero;
    }

    public Embarcacion getEmbarcacion() {
        return embarcacion;
    }

    public void setEmbarcacion(Embarcacion embarcacion) {
        this.embarcacion = embarcacion;
    }

    public Horarios getHorarioReal() {
        return horarioReal;
    }

    public void setHorarioReal(Horarios horarioReal) {
        this.horarioReal = horarioReal;
    }

    public Horarios getHorarioProgramado() {
        return horarioProgramado;
    }

    public void setHorarioProgramado(Horarios horarioProgramado) {
        this.horarioProgramado = horarioProgramado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idViajes != null ? idViajes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Viajes)) {
            return false;
        }
        Viajes other = (Viajes) object;
        if ((this.idViajes == null && other.idViajes != null) || (this.idViajes != null && !this.idViajes.equals(other.idViajes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "STF.Viajes[ idViajes=" + idViajes + " ]";
    }
    
}
