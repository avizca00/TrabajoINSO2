/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author aiviz
 */
@Entity
@Table(name = "notificacionesRecibos")
public class NotificacionesRecibos implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idnotificacionesrecibos;

    @ManyToOne
    @JoinColumn(name = "RecibosDomiciliarios_idRecibosDomiciliarios")
    private RecibosDomiciliarios reciboDomiciliario;

    @Column(name = "pagoRealizado", nullable = false)
    private int pagoRealizado;

    @Column(name = "descripcion", nullable = false, length = 255)
    private String descripcion;
    
    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;

    public int getIdnotificacionesrecibos() {
        return idnotificacionesrecibos;
    }

    public void setIdnotificacionesrecibos(int idnotificacionesrecibos) {
        this.idnotificacionesrecibos = idnotificacionesrecibos;
    }

    public RecibosDomiciliarios getReciboDomiciliario() {
        return reciboDomiciliario;
    }

    public void setReciboDomiciliario(RecibosDomiciliarios reciboDomiciliario) {
        this.reciboDomiciliario = reciboDomiciliario;
    }

    public int getPagoRealizado() {
        return pagoRealizado;
    }

    public void setPagoRealizado(int pagoRealizado) {
        this.pagoRealizado = pagoRealizado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.idnotificacionesrecibos;
        hash = 47 * hash + Objects.hashCode(this.reciboDomiciliario);
        hash = 47 * hash + this.pagoRealizado;
        hash = 47 * hash + Objects.hashCode(this.descripcion);
        hash = 47 * hash + Objects.hashCode(this.fecha);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NotificacionesRecibos other = (NotificacionesRecibos) obj;
        if (this.idnotificacionesrecibos != other.idnotificacionesrecibos) {
            return false;
        }
        if (this.pagoRealizado != other.pagoRealizado) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.reciboDomiciliario, other.reciboDomiciliario)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        return true;
    }

}
