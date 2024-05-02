/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
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
@Table(name = "recibosDomiciliarios")
public class RecibosDomiciliarios implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "Cuentas_idCuenta")
    private Cuentas cuenta;

    @Column(name = "importe", nullable = false, length = 45)
    private String importe;

    @Column(name = "fechaEmision", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaEmision;

    @Column(name = "fechaVencimiento", nullable = false, length = 45)
    private String fechaVencimiento;

    @Column(name = "estado", nullable = false)
    private int estado;

    @Column(name = "entidadPersona", nullable = false, length = 255)
    private String entidadPersona;

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

    public String getImporte() {
        return importe;
    }

    public void setImporte(String importe) {
        this.importe = importe;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getEntidadPersona() {
        return entidadPersona;
    }

    public void setEntidadPersona(String entidadPersona) {
        this.entidadPersona = entidadPersona;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((cuenta == null) ? 0 : cuenta.hashCode());
        result = prime * result + ((importe == null) ? 0 : importe.hashCode());
        result = prime * result + ((fechaEmision == null) ? 0 : fechaEmision.hashCode());
        result = prime * result + ((fechaVencimiento == null) ? 0 : fechaVencimiento.hashCode());
        result = prime * result + estado;
        result = prime * result + ((entidadPersona == null) ? 0 : entidadPersona.hashCode());
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
        RecibosDomiciliarios other = (RecibosDomiciliarios) obj;
        if (id != other.id)
            return false;
        if (cuenta == null) {
            if (other.cuenta != null)
                return false;
        } else if (!cuenta.equals(other.cuenta))
            return false;
        if (importe == null) {
            if (other.importe != null)
                return false;
        } else if (!importe.equals(other.importe))
            return false;
        if (fechaEmision == null) {
            if (other.fechaEmision != null)
                return false;
        } else if (!fechaEmision.equals(other.fechaEmision))
            return false;
        if (fechaVencimiento == null) {
            if (other.fechaVencimiento != null)
                return false;
        } else if (!fechaVencimiento.equals(other.fechaVencimiento))
            return false;
        if (estado != other.estado)
            return false;
        if (entidadPersona == null) {
            if (other.entidadPersona != null)
                return false;
        } else if (!entidadPersona.equals(other.entidadPersona))
            return false;
        return true;
    }

}
