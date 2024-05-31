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
/**
 * La clase Tarjetas_De_Credito representa una tarjeta de crédito en el sistema.
 * Contiene información como el número de tarjeta, el tipo de tarjeta, la fecha
 * de vencimiento, el CVV y el saldo disponible.
 */
@Entity
@Table(name = "tarjetasCredito")
public class Tarjetas_De_Credito implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idtarjetascredito;

    @ManyToOne
    @JoinColumn(name = "Cuentas_idCuenta")
    private Cuentas cuenta;

    @Column(name = "numeroTarjeta", unique = true, nullable = false, length = 20)
    private String numeroTarjeta;

    @Column(name = "tipoTarjeta", nullable = false, length = 45)
    private String tipoTarjeta;

    @Column(name = "fechaVencimiento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;

    @Column(name = "CVV", nullable = false, length = 4)
    private String CVV;

    @Column(name = "saldoDisponible", precision = 15, scale = 2)
    private BigDecimal saldoDisponible;

    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;

    public int getIdtarjetascredito() {
        return idtarjetascredito;
    }

    public void setIdtarjetascredito(int idtarjetascredito) {
        this.idtarjetascredito = idtarjetascredito;
    }

    public Cuentas getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuentas cuenta) {
        this.cuenta = cuenta;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(String tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getCVV() {
        return CVV;
    }

    public void setCVV(String CVV) {
        this.CVV = CVV;
    }

    public BigDecimal getSaldoDisponible() {
        return saldoDisponible;
    }

    public void setSaldoDisponible(BigDecimal saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.idtarjetascredito;
        hash = 59 * hash + Objects.hashCode(this.cuenta);
        hash = 59 * hash + Objects.hashCode(this.numeroTarjeta);
        hash = 59 * hash + Objects.hashCode(this.tipoTarjeta);
        hash = 59 * hash + Objects.hashCode(this.fechaVencimiento);
        hash = 59 * hash + Objects.hashCode(this.CVV);
        hash = 59 * hash + Objects.hashCode(this.saldoDisponible);
        hash = 59 * hash + Objects.hashCode(this.nombre);
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
        final Tarjetas_De_Credito other = (Tarjetas_De_Credito) obj;
        if (this.idtarjetascredito != other.idtarjetascredito) {
            return false;
        }
        if (!Objects.equals(this.numeroTarjeta, other.numeroTarjeta)) {
            return false;
        }
        if (!Objects.equals(this.tipoTarjeta, other.tipoTarjeta)) {
            return false;
        }
        if (!Objects.equals(this.CVV, other.CVV)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.cuenta, other.cuenta)) {
            return false;
        }
        if (!Objects.equals(this.fechaVencimiento, other.fechaVencimiento)) {
            return false;
        }
        if (!Objects.equals(this.saldoDisponible, other.saldoDisponible)) {
            return false;
        }
        return true;
    }

}
