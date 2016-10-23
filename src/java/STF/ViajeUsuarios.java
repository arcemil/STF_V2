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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Julian Marin
 */
@Entity
@Table(name = "viaje_usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ViajeUsuarios.findAll", query = "SELECT v FROM ViajeUsuarios v"),
    @NamedQuery(name = "ViajeUsuarios.findByIdViaje", query = "SELECT v FROM ViajeUsuarios v WHERE v.idViaje = :idViaje")})
public class ViajeUsuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_VIAJE")
    private Short idViaje;
    @JoinColumn(name = "USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne(optional = false)
    private Usuarios usuario;
    @JoinColumn(name = "VIAJE", referencedColumnName = "ID_VIAJES")
    @ManyToOne(optional = false)
    private Viajes viaje;

    public ViajeUsuarios() {
    }

    public ViajeUsuarios(Short idViaje) {
        this.idViaje = idViaje;
    }

    public Short getIdViaje() {
        return idViaje;
    }

    public void setIdViaje(Short idViaje) {
        this.idViaje = idViaje;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public Viajes getViaje() {
        return viaje;
    }

    public void setViaje(Viajes viaje) {
        this.viaje = viaje;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idViaje != null ? idViaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ViajeUsuarios)) {
            return false;
        }
        ViajeUsuarios other = (ViajeUsuarios) object;
        if ((this.idViaje == null && other.idViaje != null) || (this.idViaje != null && !this.idViaje.equals(other.idViaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "STF.ViajeUsuarios[ idViaje=" + idViaje + " ]";
    }
    
}
