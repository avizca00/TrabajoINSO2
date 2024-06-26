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
@Table(name = "recibosDomiciliarios")
public class RecibosDomiciliarios implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idrecibosdomiciliarios;

    @ManyToOne
    @JoinColumn(name = "Cuentas_idCuenta")
    private Cuentas cuenta;

    @Column(name = "importe", precision = 15, scale = 2)
    private BigDecimal importe;

    @Column(name = "fechaEmision", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaEmision;

    @Column(name = "fechaVencimiento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;

    @Column(name = "entidadPersona", nullable = false, length = 255)
    private String entidadPersona;

    public int getIdrecibosdomiciliarios() {
        return idrecibosdomiciliarios;
    }

    public void setIdrecibosdomiciliarios(int idrecibosdomiciliarios) {
        this.idrecibosdomiciliarios = idrecibosdomiciliarios;
    }

    public Cuentas getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuentas cuenta) {
        this.cuenta = cuenta;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getEntidadPersona() {
        return entidadPersona;
    }

    public void setEntidadPersona(String entidadPersona) {
        this.entidadPersona = entidadPersona;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.idrecibosdomiciliarios;
        hash = 37 * hash + Objects.hashCode(this.cuenta);
        hash = 37 * hash + Objects.hashCode(this.importe);
        hash = 37 * hash + Objects.hashCode(this.fechaEmision);
        hash = 37 * hash + Objects.hashCode(this.fechaVencimiento);
        hash = 37 * hash + Objects.hashCode(this.entidadPersona);
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
        final RecibosDomiciliarios other = (RecibosDomiciliarios) obj;
        if (this.idrecibosdomiciliarios != other.idrecibosdomiciliarios) {
            return false;
        }
        if (!Objects.equals(this.entidadPersona, other.entidadPersona)) {
            return false;
        }
        if (!Objects.equals(this.cuenta, other.cuenta)) {
            return false;
        }
        if (!Objects.equals(this.importe, other.importe)) {
            return false;
        }
        if (!Objects.equals(this.fechaEmision, other.fechaEmision)) {
            return false;
        }
        if (!Objects.equals(this.fechaVencimiento, other.fechaVencimiento)) {
            return false;
        }
        return true;
    }

}
