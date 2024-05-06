/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.persistence.Entity;
import javax.persistence.Table;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author aiviz
 */
@Entity
@Table(name = "cuentas")
public class Cuentas implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idcuenta;

    @Column(name = "tipoCuenta", nullable = false, length = 45)
    private String tipoCuenta;

    @Column(name = "saldo", nullable = false, precision = 15, scale = 2)
    private BigDecimal saldo;

    @Column(name = "fechaApertura", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaApertura;

    @Column(name = "tasaInteres", nullable = false, precision = 5, scale = 2)
    private BigDecimal tasaInteres;

    @Column(name = "limiteTransaccion", precision = 15, scale = 2)
    private BigDecimal limiteTransaccion;

    @Column(name = "fechaUltimaTransaccion", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaUltimaTransaccion;

    public int getId() {
        return idcuenta;
    }

    public void setId(int id) {
        this.idcuenta = id;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Date getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public BigDecimal getTasaInteres() {
        return tasaInteres;
    }

    public void setTasaInteres(BigDecimal tasaInteres) {
        this.tasaInteres = tasaInteres;
    }

    public BigDecimal getLimiteTransaccion() {
        return limiteTransaccion;
    }

    public void setLimiteTransaccion(BigDecimal limiteTransaccion) {
        this.limiteTransaccion = limiteTransaccion;
    }

    public Date getFechaUltimaTransaccion() {
        return fechaUltimaTransaccion;
    }

    public void setFechaUltimaTransaccion(Date fechaUltimaTransaccion) {
        this.fechaUltimaTransaccion = fechaUltimaTransaccion;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + idcuenta;
        result = prime * result + ((tipoCuenta == null) ? 0 : tipoCuenta.hashCode());
        result = prime * result + ((saldo == null) ? 0 : saldo.hashCode());
        result = prime * result + ((fechaApertura == null) ? 0 : fechaApertura.hashCode());
        result = prime * result + ((tasaInteres == null) ? 0 : tasaInteres.hashCode());
        result = prime * result + ((limiteTransaccion == null) ? 0 : limiteTransaccion.hashCode());
        result = prime * result + ((fechaUltimaTransaccion == null) ? 0 : fechaUltimaTransaccion.hashCode());
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
        Cuentas other = (Cuentas) obj;
        if (idcuenta != other.idcuenta)
            return false;
        if (tipoCuenta == null) {
            if (other.tipoCuenta != null)
                return false;
        } else if (!tipoCuenta.equals(other.tipoCuenta))
            return false;
        if (saldo == null) {
            if (other.saldo != null)
                return false;
        } else if (!saldo.equals(other.saldo))
            return false;
        if (fechaApertura == null) {
            if (other.fechaApertura != null)
                return false;
        } else if (!fechaApertura.equals(other.fechaApertura))
            return false;
        if (tasaInteres == null) {
            if (other.tasaInteres != null)
                return false;
        } else if (!tasaInteres.equals(other.tasaInteres))
            return false;
        if (limiteTransaccion == null) {
            if (other.limiteTransaccion != null)
                return false;
        } else if (!limiteTransaccion.equals(other.limiteTransaccion))
            return false;
        if (fechaUltimaTransaccion == null) {
            if (other.fechaUltimaTransaccion != null)
                return false;
        } else if (!fechaUltimaTransaccion.equals(other.fechaUltimaTransaccion))
            return false;
        return true;
    }

}
