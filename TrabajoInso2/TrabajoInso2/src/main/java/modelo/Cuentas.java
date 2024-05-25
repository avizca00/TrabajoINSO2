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
import java.util.Objects;
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
    
    @Column(name = "IBAN", unique = true, nullable = false, length = 45)
    private String IBAN;

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

    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;

    public int getIdcuenta() {
        return idcuenta;
    }

    public void setIdcuenta(int idcuenta) {
        this.idcuenta = idcuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.idcuenta;
        hash = 47 * hash + Objects.hashCode(this.tipoCuenta);
        hash = 47 * hash + Objects.hashCode(this.IBAN);
        hash = 47 * hash + Objects.hashCode(this.saldo);
        hash = 47 * hash + Objects.hashCode(this.fechaApertura);
        hash = 47 * hash + Objects.hashCode(this.tasaInteres);
        hash = 47 * hash + Objects.hashCode(this.limiteTransaccion);
        hash = 47 * hash + Objects.hashCode(this.fechaUltimaTransaccion);
        hash = 47 * hash + Objects.hashCode(this.nombre);
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
        final Cuentas other = (Cuentas) obj;
        if (this.idcuenta != other.idcuenta) {
            return false;
        }
        if (!Objects.equals(this.tipoCuenta, other.tipoCuenta)) {
            return false;
        }
        if (!Objects.equals(this.IBAN, other.IBAN)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.saldo, other.saldo)) {
            return false;
        }
        if (!Objects.equals(this.fechaApertura, other.fechaApertura)) {
            return false;
        }
        if (!Objects.equals(this.tasaInteres, other.tasaInteres)) {
            return false;
        }
        if (!Objects.equals(this.limiteTransaccion, other.limiteTransaccion)) {
            return false;
        }
        if (!Objects.equals(this.fechaUltimaTransaccion, other.fechaUltimaTransaccion)) {
            return false;
        }
        return true;
    }

}
