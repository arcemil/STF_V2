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
@Table(name = "canoero")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Canoero.findAll", query = "SELECT c FROM Canoero c"),
    @NamedQuery(name = "Canoero.findByIdCanoero", query = "SELECT c FROM Canoero c WHERE c.idCanoero = :idCanoero"),
    @NamedQuery(name = "Canoero.findByPrimerNombre", query = "SELECT c FROM Canoero c WHERE c.primerNombre = :primerNombre"),
    @NamedQuery(name = "Canoero.findBySegundoNombre", query = "SELECT c FROM Canoero c WHERE c.segundoNombre = :segundoNombre"),
    @NamedQuery(name = "Canoero.findByPrimerApellido", query = "SELECT c FROM Canoero c WHERE c.primerApellido = :primerApellido"),
    @NamedQuery(name = "Canoero.findBySegundoApellido", query = "SELECT c FROM Canoero c WHERE c.segundoApellido = :segundoApellido"),
    @NamedQuery(name = "Canoero.findByCedula", query = "SELECT c FROM Canoero c WHERE c.cedula = :cedula"),
    @NamedQuery(name = "Canoero.findByTelefono", query = "SELECT c FROM Canoero c WHERE c.telefono = :telefono")})
public class Canoero implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CANOERO")
    private Short idCanoero;
    @Size(max = 30)
    @Column(name = "PRIMER_NOMBRE")
    private String primerNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "SEGUNDO_NOMBRE")
    private String segundoNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "PRIMER_APELLIDO")
    private String primerApellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "SEGUNDO_APELLIDO")
    private String segundoApellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CEDULA")
    private String cedula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "TELEFONO")
    private String telefono;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "canoero")
    private Collection<Viajes> viajesCollection;

    public Canoero() {
    }

    public Canoero(Short idCanoero) {
        this.idCanoero = idCanoero;
    }

    public Canoero(Short idCanoero, String segundoNombre, String primerApellido, String segundoApellido, String cedula, String telefono) {
        this.idCanoero = idCanoero;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.cedula = cedula;
        this.telefono = telefono;
    }

    public Short getIdCanoero() {
        return idCanoero;
    }

    public void setIdCanoero(Short idCanoero) {
        this.idCanoero = idCanoero;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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
        hash += (idCanoero != null ? idCanoero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Canoero)) {
            return false;
        }
        Canoero other = (Canoero) object;
        if ((this.idCanoero == null && other.idCanoero != null) || (this.idCanoero != null && !this.idCanoero.equals(other.idCanoero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "STF.Canoero[ idCanoero=" + idCanoero + " ]";
    }
    
}
