/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author aiviz
 */
@Entity
@Table(name = "clientes_Has_Cuentas")
public class Clientes_Has_Cuentas implements Serializable {
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "Clientes_idCliente"),
            @JoinColumn(name = "Clientes_Usuarios_idUsuario")
    })
    private Clientes cliente;

    @ManyToOne
    @JoinColumn(name = "Cuentas_idCuenta")
    private Cuentas cuenta;

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public Cuentas getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuentas cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
        result = prime * result + ((cuenta == null) ? 0 : cuenta.hashCode());
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
        Clientes_Has_Cuentas other = (Clientes_Has_Cuentas) obj;
        if (cliente == null) {
            if (other.cliente != null)
                return false;
        } else if (!cliente.equals(other.cliente))
            return false;
        if (cuenta == null) {
            if (other.cuenta != null)
                return false;
        } else if (!cuenta.equals(other.cuenta))
            return false;
        return true;
    }

    
}
