/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author aiviz
 */
@Entity
@Table(name = "notificaciones_De_Recibos")
public class Notificaciones_de_Recibos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "RecibosDomiciliarios_idRecibosDomiciliarios")
    private Recibos_Domiciliados reciboDomiciliario;

    @Column(name = "pagoRealizado", nullable = false)
    private int pagoRealizado;

    @Column(name = "descripcion", nullable = false, length = 255)
    private String descripcion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Recibos_Domiciliados getReciboDomiciliario() {
        return reciboDomiciliario;
    }

    public void setReciboDomiciliario(Recibos_Domiciliados reciboDomiciliario) {
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((reciboDomiciliario == null) ? 0 : reciboDomiciliario.hashCode());
        result = prime * result + pagoRealizado;
        result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Notificaciones_de_Recibos other = (Notificaciones_de_Recibos) obj;
        if (id != other.id)
            return false;
        if (reciboDomiciliario == null) {
            if (other.reciboDomiciliario != null)
                return false;
        } else if (!reciboDomiciliario.equals(other.reciboDomiciliario))
            return false;
        if (pagoRealizado != other.pagoRealizado)
            return false;
        if (descripcion == null) {
            if (other.descripcion != null)
                return false;
        } else if (!descripcion.equals(other.descripcion))
            return false;
        return true;
    }

    
}
