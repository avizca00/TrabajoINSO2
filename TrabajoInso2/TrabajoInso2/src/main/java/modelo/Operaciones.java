/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "operaciones")
public class Operaciones implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idoperaciones;

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

    public int getIdoperacion() {
        return idoperaciones;
    }

    public void setIdoperacion(int idoperacion) {
        this.idoperaciones = idoperacion;
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
        int hash = 3;
        hash = 67 * hash + this.idoperaciones;
        hash = 67 * hash + Objects.hashCode(this.fecha);
        hash = 67 * hash + Objects.hashCode(this.importe);
        hash = 67 * hash + Objects.hashCode(this.tipoOperacion);
        hash = 67 * hash + this.estado;
        hash = 67 * hash + Objects.hashCode(this.cuenta);
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
        final Operaciones other = (Operaciones) obj;
        if (this.idoperaciones != other.idoperaciones) {
            return false;
        }
        if (this.estado != other.estado) {
            return false;
        }
        if (!Objects.equals(this.tipoOperacion, other.tipoOperacion)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        if (!Objects.equals(this.importe, other.importe)) {
            return false;
        }
        if (!Objects.equals(this.cuenta, other.cuenta)) {
            return false;
        }
        return true;
    }

    
}
