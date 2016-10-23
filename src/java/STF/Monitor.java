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
@Table(name = "monitor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Monitor.findAll", query = "SELECT m FROM Monitor m"),
    @NamedQuery(name = "Monitor.findByIdMonitor", query = "SELECT m FROM Monitor m WHERE m.idMonitor = :idMonitor"),
    @NamedQuery(name = "Monitor.findByUsuario", query = "SELECT m FROM Monitor m WHERE m.usuario = :usuario"),
    @NamedQuery(name = "Monitor.findByContrase\u00f1a", query = "SELECT m FROM Monitor m WHERE m.contrase\u00f1a = :contrase\u00f1a"),
    @NamedQuery(name = "Monitor.findByNombre", query = "SELECT m FROM Monitor m WHERE m.nombre = :nombre"),
    @NamedQuery(name = "Monitor.findByApellido", query = "SELECT m FROM Monitor m WHERE m.apellido = :apellido"),
    @NamedQuery(name = "Monitor.findByCorreo", query = "SELECT m FROM Monitor m WHERE m.correo = :correo")})
public class Monitor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_MONITOR")
    private Short idMonitor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "USUARIO")
    private String usuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "CONTRASE\u00d1A")
    private String contraseña;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "APELLIDO")
    private String apellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "CORREO")
    private String correo;

    public Monitor() {
    }

    public Monitor(Short idMonitor) {
        this.idMonitor = idMonitor;
    }

    public Monitor(Short idMonitor, String usuario, String contraseña, String nombre, String apellido, String correo) {
        this.idMonitor = idMonitor;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
    }

    public Short getIdMonitor() {
        return idMonitor;
    }

    public void setIdMonitor(Short idMonitor) {
        this.idMonitor = idMonitor;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMonitor != null ? idMonitor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Monitor)) {
            return false;
        }
        Monitor other = (Monitor) object;
        if ((this.idMonitor == null && other.idMonitor != null) || (this.idMonitor != null && !this.idMonitor.equals(other.idMonitor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "STF.Monitor[ idMonitor=" + idMonitor + " ]";
    }
    
}
