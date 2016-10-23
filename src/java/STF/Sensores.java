/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package STF;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "sensores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sensores.findAll", query = "SELECT s FROM Sensores s"),
    @NamedQuery(name = "Sensores.findByIdSensores", query = "SELECT s FROM Sensores s WHERE s.idSensores = :idSensores"),
    @NamedQuery(name = "Sensores.findByCoordenadas", query = "SELECT s FROM Sensores s WHERE s.coordenadas = :coordenadas"),
    @NamedQuery(name = "Sensores.findByEstadoSensor", query = "SELECT s FROM Sensores s WHERE s.estadoSensor = :estadoSensor"),
    @NamedQuery(name = "Sensores.findByAltura", query = "SELECT s FROM Sensores s WHERE s.altura = :altura"),
    @NamedQuery(name = "Sensores.findByLongitud", query = "SELECT s FROM Sensores s WHERE s.longitud = :longitud"),
    @NamedQuery(name = "Sensores.findByLatitud", query = "SELECT s FROM Sensores s WHERE s.latitud = :latitud"),
    @NamedQuery(name = "Sensores.findByFecha", query = "SELECT s FROM Sensores s WHERE s.fecha = :fecha"),
    @NamedQuery(name = "Sensores.findByHora", query = "SELECT s FROM Sensores s WHERE s.hora = :hora")})
public class Sensores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "ID_SENSORES")
    private String idSensores;
    @Size(max = 30)
    @Column(name = "COORDENADAS")
    private String coordenadas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ESTADO_SENSOR")
    private String estadoSensor;
    @Column(name = "ALTURA")
    private Long altura;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "LONGITUD")
    private BigDecimal longitud;
    @Column(name = "LATITUD")
    private BigDecimal latitud;
    @Size(max = 10)
    @Column(name = "fecha")
    private String fecha;
    @Size(max = 10)
    @Column(name = "hora")
    private String hora;

    public Sensores() {
    }

    public Sensores(String idSensores) {
        this.idSensores = idSensores;
    }

    public Sensores(String idSensores, String estadoSensor) {
        this.idSensores = idSensores;
        this.estadoSensor = estadoSensor;
    }

    public String getIdSensores() {
        return idSensores;
    }

    public void setIdSensores(String idSensores) {
        this.idSensores = idSensores;
    }

    public String getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(String coordenadas) {
        this.coordenadas = coordenadas;
    }

    public String getEstadoSensor() {
        return estadoSensor;
    }

    public void setEstadoSensor(String estadoSensor) {
        this.estadoSensor = estadoSensor;
    }

    public Long getAltura() {
        return altura;
    }

    public void setAltura(Long altura) {
        this.altura = altura;
    }

    public BigDecimal getLongitud() {
        return longitud;
    }

    public void setLongitud(BigDecimal longitud) {
        this.longitud = longitud;
    }

    public BigDecimal getLatitud() {
        return latitud;
    }

    public void setLatitud(BigDecimal latitud) {
        this.latitud = latitud;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSensores != null ? idSensores.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sensores)) {
            return false;
        }
        Sensores other = (Sensores) object;
        if ((this.idSensores == null && other.idSensores != null) || (this.idSensores != null && !this.idSensores.equals(other.idSensores))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "STF.Sensores[ idSensores=" + idSensores + " ]";
    }
    
}
