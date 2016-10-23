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
@Table(name = "horarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Horarios.findAll", query = "SELECT h FROM Horarios h"),
    @NamedQuery(name = "Horarios.findByIdHorarios", query = "SELECT h FROM Horarios h WHERE h.idHorarios = :idHorarios"),
    @NamedQuery(name = "Horarios.findByHoraLlegada", query = "SELECT h FROM Horarios h WHERE h.horaLlegada = :horaLlegada"),
    @NamedQuery(name = "Horarios.findByHoraSalida", query = "SELECT h FROM Horarios h WHERE h.horaSalida = :horaSalida"),
    @NamedQuery(name = "Horarios.findByTipo", query = "SELECT h FROM Horarios h WHERE h.tipo = :tipo")})
public class Horarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_HORARIOS")
    private Integer idHorarios;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "HORA_LLEGADA")
    private String horaLlegada;
    @Size(max = 10)
    @Column(name = "HORA_SALIDA")
    private String horaSalida;
    @Size(max = 1)
    @Column(name = "TIPO")
    private String tipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "horarioReal")
    private Collection<Viajes> viajesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "horarioProgramado")
    private Collection<Viajes> viajesCollection1;

    public Horarios() {
    }

    public Horarios(Integer idHorarios) {
        this.idHorarios = idHorarios;
    }

    public Horarios(Integer idHorarios, String horaLlegada) {
        this.idHorarios = idHorarios;
        this.horaLlegada = horaLlegada;
    }

    public Integer getIdHorarios() {
        return idHorarios;
    }

    public void setIdHorarios(Integer idHorarios) {
        this.idHorarios = idHorarios;
    }

    public String getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(String horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public Collection<Viajes> getViajesCollection() {
        return viajesCollection;
    }

    public void setViajesCollection(Collection<Viajes> viajesCollection) {
        this.viajesCollection = viajesCollection;
    }

    @XmlTransient
    public Collection<Viajes> getViajesCollection1() {
        return viajesCollection1;
    }

    public void setViajesCollection1(Collection<Viajes> viajesCollection1) {
        this.viajesCollection1 = viajesCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHorarios != null ? idHorarios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Horarios)) {
            return false;
        }
        Horarios other = (Horarios) object;
        if ((this.idHorarios == null && other.idHorarios != null) || (this.idHorarios != null && !this.idHorarios.equals(other.idHorarios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "STF.Horarios[ idHorarios=" + idHorarios + " ]";
    }
    
}
