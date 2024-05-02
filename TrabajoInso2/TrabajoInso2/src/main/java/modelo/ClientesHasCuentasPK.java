/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ClientesHasCuentasPK implements Serializable {

    @Column(name = "Clientes_idCliente")
    private int clientesIdCliente;

    @Column(name = "Clientes_Usuarios_idUsuario")
    private int clientesUsuariosIdUsuario;

    @Column(name = "Cuentas_idCuenta")
    private int cuentasIdCuenta;

    public int getClientesIdCliente() {
        return clientesIdCliente;
    }

    public void setClientesIdCliente(int clientesIdCliente) {
        this.clientesIdCliente = clientesIdCliente;
    }

    public int getClientesUsuariosIdUsuario() {
        return clientesUsuariosIdUsuario;
    }

    public void setClientesUsuariosIdUsuario(int clientesUsuariosIdUsuario) {
        this.clientesUsuariosIdUsuario = clientesUsuariosIdUsuario;
    }

    public int getCuentasIdCuenta() {
        return cuentasIdCuenta;
    }

    public void setCuentasIdCuenta(int cuentasIdCuenta) {
        this.cuentasIdCuenta = cuentasIdCuenta;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.clientesIdCliente;
        hash = 47 * hash + this.clientesUsuariosIdUsuario;
        hash = 47 * hash + this.cuentasIdCuenta;
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
        final ClientesHasCuentasPK other = (ClientesHasCuentasPK) obj;
        if (this.clientesIdCliente != other.clientesIdCliente) {
            return false;
        }
        if (this.clientesUsuariosIdUsuario != other.clientesUsuariosIdUsuario) {
            return false;
        }
        if (this.cuentasIdCuenta != other.cuentasIdCuenta) {
            return false;
        }
        return true;
    }
    
    
}