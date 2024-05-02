/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author aiviz
 */
@Entity
@Table(name = "clientes_Has_Cuentas")
public class Clientes_Has_Cuentas implements Serializable {

    @EmbeddedId
    private ClientesHasCuentasPK clientesHasCuentasPK;

    @JoinColumn(name = "Cuentas_idCuenta")
    @ManyToOne
    private Cuentas cuentas;

    @JoinColumn(name = "Clientes_idCliente")
    @ManyToOne
    private Clientes clientes;

    public ClientesHasCuentasPK getClientesHasCuentasPK() {
        return clientesHasCuentasPK;
    }

    public void setClientesHasCuentasPK(ClientesHasCuentasPK clientesHasCuentasPK) {
        this.clientesHasCuentasPK = clientesHasCuentasPK;
    }

    public Cuentas getCuentas() {
        return cuentas;
    }

    public void setCuentas(Cuentas cuentas) {
        this.cuentas = cuentas;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.clientesHasCuentasPK);
        hash = 17 * hash + Objects.hashCode(this.cuentas);
        hash = 17 * hash + Objects.hashCode(this.clientes);
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
        final Clientes_Has_Cuentas other = (Clientes_Has_Cuentas) obj;
        if (!Objects.equals(this.clientesHasCuentasPK, other.clientesHasCuentasPK)) {
            return false;
        }
        if (!Objects.equals(this.cuentas, other.cuentas)) {
            return false;
        }
        if (!Objects.equals(this.clientes, other.clientes)) {
            return false;
        }
        return true;
    }

}
