/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.math.BigDecimal;
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
/**
 * La clase Tarjetas_De_Credito representa una tarjeta de crédito en el sistema.
 * Contiene información como el número de tarjeta, el tipo de tarjeta, la fecha de vencimiento,
 * el CVV y el saldo disponible.
 */
@Entity
@Table(name = "tarjetasCredito")
public class Tarjetas_De_Credito implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "Cuentas_idCuenta")
    private Cuentas cuenta;

    @Column(name = "numeroTarjeta", unique = true, nullable = false, length = 20)
    private String numeroTarjeta;

    @Column(name = "tipoTarjeta", nullable = false, length = 45)
    private String tipoTarjeta;

    @Column(name = "fechaVencimiento", nullable = false, length = 45)
    private String fechaVencimiento;

    @Column(name = "CVV", nullable = false, length = 4)
    private String CVV;

    @Column(name = "saldoDisponible", precision = 15, scale = 2)
    private BigDecimal saldoDisponible;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getCVV() {
        return CVV;
    }

    public void setCVV(String cVV) {
        CVV = cVV;
    }

    public BigDecimal getSaldoDisponible() {
        return saldoDisponible;
    }

    public void setSaldoDisponible(BigDecimal saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((cuenta == null) ? 0 : cuenta.hashCode());
        result = prime * result + ((numeroTarjeta == null) ? 0 : numeroTarjeta.hashCode());
        result = prime * result + ((tipoTarjeta == null) ? 0 : tipoTarjeta.hashCode());
        result = prime * result + ((fechaVencimiento == null) ? 0 : fechaVencimiento.hashCode());
        result = prime * result + ((CVV == null) ? 0 : CVV.hashCode());
        result = prime * result + ((saldoDisponible == null) ? 0 : saldoDisponible.hashCode());
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
        Tarjetas_De_Credito other = (Tarjetas_De_Credito) obj;
        if (id != other.id)
            return false;
        if (cuenta == null) {
            if (other.cuenta != null)
                return false;
        } else if (!cuenta.equals(other.cuenta))
            return false;
        if (numeroTarjeta == null) {
            if (other.numeroTarjeta != null)
                return false;
        } else if (!numeroTarjeta.equals(other.numeroTarjeta))
            return false;
        if (tipoTarjeta == null) {
            if (other.tipoTarjeta != null)
                return false;
        } else if (!tipoTarjeta.equals(other.tipoTarjeta))
            return false;
        if (fechaVencimiento == null) {
            if (other.fechaVencimiento != null)
                return false;
        } else if (!fechaVencimiento.equals(other.fechaVencimiento))
            return false;
        if (CVV == null) {
            if (other.CVV != null)
                return false;
        } else if (!CVV.equals(other.CVV))
            return false;
        if (saldoDisponible == null) {
            if (other.saldoDisponible != null)
                return false;
        } else if (!saldoDisponible.equals(other.saldoDisponible))
            return false;
        return true;
    }

    

}