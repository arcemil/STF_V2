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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Julian Marin
 */
@Entity
@Table(name = "problemas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Problemas.findAll", query = "SELECT p FROM Problemas p"),
    @NamedQuery(name = "Problemas.findByIdProblemas", query = "SELECT p FROM Problemas p WHERE p.idProblemas = :idProblemas"),
    @NamedQuery(name = "Problemas.findByTitulo", query = "SELECT p FROM Problemas p WHERE p.titulo = :titulo"),
    @NamedQuery(name = "Problemas.findByDetalle", query = "SELECT p FROM Problemas p WHERE p.detalle = :detalle")})
public class Problemas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PROBLEMAS")
    private Integer idProblemas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "TITULO")
    private String titulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "DETALLE")
    private String detalle;
    @JoinColumn(name = "VIAJE", referencedColumnName = "ID_VIAJES")
    @ManyToOne(optional = false)
    private Viajes viaje;

    public Problemas() {
    }

    public Problemas(Integer idProblemas) {
        this.idProblemas = idProblemas;
    }

    public Problemas(Integer idProblemas, String titulo, String detalle) {
        this.idProblemas = idProblemas;
        this.titulo = titulo;
        this.detalle = detalle;
    }

    public Integer getIdProblemas() {
        return idProblemas;
    }

    public void setIdProblemas(Integer idProblemas) {
        this.idProblemas = idProblemas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
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
        hash += (idProblemas != null ? idProblemas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Problemas)) {
            return false;
        }
        Problemas other = (Problemas) object;
        if ((this.idProblemas == null && other.idProblemas != null) || (this.idProblemas != null && !this.idProblemas.equals(other.idProblemas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "STF.Problemas[ idProblemas=" + idProblemas + " ]";
    }
    
}
