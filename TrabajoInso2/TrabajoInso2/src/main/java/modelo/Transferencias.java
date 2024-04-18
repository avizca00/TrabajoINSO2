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
@Table(name = "transferencias")
public class Transferencias implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "Cuentas_idCuentaPagador")
    private Cuentas cuentaPagador;

    @ManyToOne
    @JoinColumn(name = "Cuentas_idCuentaBeneficiario")
    private Cuentas cuentaBeneficiario;

    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @Column(name = "monto", nullable = false, precision = 15, scale = 2)
    private BigDecimal monto;

    @Column(name = "concepto", nullable = false, length = 200)
    private String concepto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cuentas getCuentaPagador() {
        return cuentaPagador;
    }

    public void setCuentaPagador(Cuentas cuentaPagador) {
        this.cuentaPagador = cuentaPagador;
    }

    public Cuentas getCuentaBeneficiario() {
        return cuentaBeneficiario;
    }

    public void setCuentaBeneficiario(Cuentas cuentaBeneficiario) {
        this.cuentaBeneficiario = cuentaBeneficiario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((cuentaPagador == null) ? 0 : cuentaPagador.hashCode());
        result = prime * result + ((cuentaBeneficiario == null) ? 0 : cuentaBeneficiario.hashCode());
        result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
        result = prime * result + ((monto == null) ? 0 : monto.hashCode());
        result = prime * result + ((concepto == null) ? 0 : concepto.hashCode());
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
        Transferencias other = (Transferencias) obj;
        if (id != other.id)
            return false;
        if (cuentaPagador == null) {
            if (other.cuentaPagador != null)
                return false;
        } else if (!cuentaPagador.equals(other.cuentaPagador))
            return false;
        if (cuentaBeneficiario == null) {
            if (other.cuentaBeneficiario != null)
                return false;
        } else if (!cuentaBeneficiario.equals(other.cuentaBeneficiario))
            return false;
        if (fecha == null) {
            if (other.fecha != null)
                return false;
        } else if (!fecha.equals(other.fecha))
            return false;
        if (monto == null) {
            if (other.monto != null)
                return false;
        } else if (!monto.equals(other.monto))
            return false;
        if (concepto == null) {
            if (other.concepto != null)
                return false;
        } else if (!concepto.equals(other.concepto))
            return false;
        return true;
    }

    // Getters and setters
}
