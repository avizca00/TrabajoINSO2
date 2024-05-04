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

    /**
     * Obtiene el ID del empleado.
     * @return El ID del empleado.
     */
    public int getId() {
        return idempleado;
    }

    /**
     * Establece el ID del empleado.
     * @param id El ID del empleado.
     */
    public void setId(int id) {
        this.idempleado = id;
    }

    /**
     * Obtiene el usuario asociado al empleado.
     * @return El usuario asociado al empleado.
     */
    public Usuarios getUsuario() {
        return usuario;
    }

    /**
     * Establece el usuario asociado al empleado.
     * @param usuario El usuario asociado al empleado.
     */
    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    /**
     * Obtiene la fecha de contratación del empleado.
     * @return La fecha de contratación del empleado.
     */
    public Date getFechaContratacion() {
        return fechaContratacion;
    }

    /**
     * Establece la fecha de contratación del empleado.
     * @param fechaContratacion La fecha de contratación del empleado.
     */
    public void setFechaContratacion(Date fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + idempleado;
        result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
        result = prime * result + ((fechaContratacion == null) ? 0 : fechaContratacion.hashCode());
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
        Empleados other = (Empleados) obj;
        if (idempleado != other.idempleado)
            return false;
        if (usuario == null) {
            if (other.usuario != null)
                return false;
        } else if (!usuario.equals(other.usuario))
            return false;
        if (fechaContratacion == null) {
            if (other.fechaContratacion != null)
                return false;
        } else if (!fechaContratacion.equals(other.fechaContratacion))
            return false;
        return true;
    }

}
    
