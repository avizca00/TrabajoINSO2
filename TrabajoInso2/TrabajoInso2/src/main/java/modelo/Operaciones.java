/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

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
@Table(name = "operaciones")
public class Operaciones implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idoperacion;

    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    @Column(name = "importe", nullable = false, precision = 15, scale = 2)
    private BigDecimal importe;

    @Column(name = "tipoOperacion", nullable = false, length = 45)
    private String tipoOperacion;

    @Column(name = "estado", nullable = false)
    private int estado;

    @ManyToOne
    @JoinColumn(name = "Cuentas_idCuenta")
    private Cuentas cuenta;

    public int getId() {
        return idoperacion;
    }

    public void setId(int id) {
        this.idoperacion = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Cuentas getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuentas cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + idoperacion;
        result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
        result = prime * result + ((importe == null) ? 0 : importe.hashCode());
        result = prime * result + ((tipoOperacion == null) ? 0 : tipoOperacion.hashCode());
        result = prime * result + estado;
        result = prime * result + ((cuenta == null) ? 0 : cuenta.hashCode());
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
        Operaciones other = (Operaciones) obj;
        if (idoperacion != other.idoperacion)
            return false;
        if (fecha == null) {
            if (other.fecha != null)
                return false;
        } else if (!fecha.equals(other.fecha))
            return false;
        if (importe == null) {
            if (other.importe != null)
                return false;
        } else if (!importe.equals(other.importe))
            return false;
        if (tipoOperacion == null) {
            if (other.tipoOperacion != null)
                return false;
        } else if (!tipoOperacion.equals(other.tipoOperacion))
            return false;
        if (estado != other.estado)
            return false;
        if (cuenta == null) {
            if (other.cuenta != null)
                return false;
        } else if (!cuenta.equals(other.cuenta))
            return false;
        return true;
    }

    
}
