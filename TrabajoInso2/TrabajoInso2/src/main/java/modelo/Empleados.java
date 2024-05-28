/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
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
 * Representa a un empleado en el sistema.
 */
@Entity
@Table(name = "empleados")
public class Empleados implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idempleado;

    @ManyToOne
    @JoinColumn(name = "Usuarios_idUsuario")
    private Usuarios usuario;

    @Column(name = "fechaContratacion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaContratacion;

    public int getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(int idempleado) {
        this.idempleado = idempleado;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public Date getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(Date fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.idempleado;
        hash = 79 * hash + Objects.hashCode(this.usuario);
        hash = 79 * hash + Objects.hashCode(this.fechaContratacion);
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
        final Empleados other = (Empleados) obj;
        if (this.idempleado != other.idempleado) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.fechaContratacion, other.fechaContratacion)) {
            return false;
        }
        return true;
    }

}
    
