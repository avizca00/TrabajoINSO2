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
@Table(name = "transferencias")
public class Transferencias implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idtransferencias;

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

    public int getIdtransferencias() {
        return idtransferencias;
    }

    public void setIdtransferencias(int idtransferencias) {
        this.idtransferencias = idtransferencias;
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
        int hash = 3;
        hash = 97 * hash + this.idtransferencias;
        hash = 97 * hash + Objects.hashCode(this.cuentaPagador);
        hash = 97 * hash + Objects.hashCode(this.cuentaBeneficiario);
        hash = 97 * hash + Objects.hashCode(this.fecha);
        hash = 97 * hash + Objects.hashCode(this.monto);
        hash = 97 * hash + Objects.hashCode(this.concepto);
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
        final Transferencias other = (Transferencias) obj;
        if (this.idtransferencias != other.idtransferencias) {
            return false;
        }
        if (!Objects.equals(this.concepto, other.concepto)) {
            return false;
        }
        if (!Objects.equals(this.cuentaPagador, other.cuentaPagador)) {
            return false;
        }
        if (!Objects.equals(this.cuentaBeneficiario, other.cuentaBeneficiario)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        if (!Objects.equals(this.monto, other.monto)) {
            return false;
        }
        return true;
    }

    
}
