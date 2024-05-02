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
@Table(name = "clientes")
public class Clientes implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idcliente;

    @ManyToOne
    @JoinColumn(name = "Usuarios_idUsuario")
    private Usuarios usuario;

    @Column(name = "fechaAlta", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaAlta;

    /**
     * Obtiene el ID del cliente.
     * 
     * @return el ID del cliente
     */
    public int getId() {
        return idcliente;
    }

    /**
     * Establece el ID del cliente.
     * 
     * @param id el ID del cliente
     */
    public void setId(int id) {
        this.idcliente = id;
    }

    /**
     * Obtiene el usuario asociado al cliente.
     * 
     * @return el usuario asociado al cliente
     */
    public Usuarios getUsuario() {
        return usuario;
    }

    /**
     * Establece el usuario asociado al cliente.
     * 
     * @param usuario el usuario asociado al cliente
     */
    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    /**
     * Obtiene la fecha de alta del cliente.
     * 
     * @return la fecha de alta del cliente
     */
    public Date getFechaAlta() {
        return fechaAlta;
    }

    /**
     * Establece la fecha de alta del cliente.
     * 
     * @param fechaAlta la fecha de alta del cliente
     */
    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + idcliente;
        result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
        result = prime * result + ((fechaAlta == null) ? 0 : fechaAlta.hashCode());
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
        Clientes other = (Clientes) obj;
        if (idcliente != other.idcliente)
            return false;
        if (usuario == null) {
            if (other.usuario != null)
                return false;
        } else if (!usuario.equals(other.usuario))
            return false;
        if (fechaAlta == null) {
            if (other.fechaAlta != null)
                return false;
        } else if (!fechaAlta.equals(other.fechaAlta))
            return false;
        return true;
    }

}
