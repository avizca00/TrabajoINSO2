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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author aiviz
 */
@Entity
@Table(name = "prestamos")
public class Prestamos implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idprestamo;

    @Column(name = "fechaInicio", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;

    @Column(name = "estado", nullable = false)
    private int estado;

    @Column(name = "plazoMeses", nullable = false)
    private int plazoMeses;

    @Column(name = "tasaInteres", nullable = false, precision = 5, scale = 2)
    private BigDecimal tasaInteres;

    @Column(name = "montoPrestamo", nullable = false, precision = 15, scale = 2)
    private BigDecimal montoPrestamo;

    @ManyToOne
    @JoinColumn(name = "Cuentas_idCuenta")
    private Cuentas cuenta;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "Empleados_idEmpleado"),
            @JoinColumn(name = "Empleados_Usuarios_idUsuario")
    })
    private Empleados empleado;

    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;

    public int getIdprestamo() {
        return idprestamo;
    }

    public void setIdprestamo(int idprestamo) {
        this.idprestamo = idprestamo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getPlazoMeses() {
        return plazoMeses;
    }

    public void setPlazoMeses(int plazoMeses) {
        this.plazoMeses = plazoMeses;
    }

    public BigDecimal getTasaInteres() {
        return tasaInteres;
    }

    public void setTasaInteres(BigDecimal tasaInteres) {
        this.tasaInteres = tasaInteres;
    }

    public BigDecimal getMontoPrestamo() {
        return montoPrestamo;
    }

    public void setMontoPrestamo(BigDecimal montoPrestamo) {
        this.montoPrestamo = montoPrestamo;
    }

    public Cuentas getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuentas cuenta) {
        this.cuenta = cuenta;
    }

    public Empleados getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleados empleado) {
        this.empleado = empleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + idprestamo;
        result = prime * result + ((fechaInicio == null) ? 0 : fechaInicio.hashCode());
        result = prime * result + estado;
        result = prime * result + plazoMeses;
        result = prime * result + ((tasaInteres == null) ? 0 : tasaInteres.hashCode());
        result = prime * result + ((montoPrestamo == null) ? 0 : montoPrestamo.hashCode());
        result = prime * result + ((cuenta == null) ? 0 : cuenta.hashCode());
        result = prime * result + ((empleado == null) ? 0 : empleado.hashCode());
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
        Prestamos other = (Prestamos) obj;
        if (idprestamo != other.idprestamo)
            return false;
        if (fechaInicio == null) {
            if (other.fechaInicio != null)
                return false;
        } else if (!fechaInicio.equals(other.fechaInicio))
            return false;
        if (estado != other.estado)
            return false;
        if (plazoMeses != other.plazoMeses)
            return false;
        if (tasaInteres == null) {
            if (other.tasaInteres != null)
                return false;
        } else if (!tasaInteres.equals(other.tasaInteres))
            return false;
        if (montoPrestamo == null) {
            if (other.montoPrestamo != null)
                return false;
        } else if (!montoPrestamo.equals(other.montoPrestamo))
            return false;
        if (cuenta == null) {
            if (other.cuenta != null)
                return false;
        } else if (!cuenta.equals(other.cuenta))
            return false;
        if (empleado == null) {
            if (other.empleado != null)
                return false;
        } else if (!empleado.equals(other.empleado))
            return false;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        return true;
    }

    
    
}
