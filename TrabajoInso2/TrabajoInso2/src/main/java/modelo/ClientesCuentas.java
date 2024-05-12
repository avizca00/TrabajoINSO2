package modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "clientesCuentas")
public class ClientesCuentas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idClientesCuentas;

    @ManyToOne
    @JoinColumn(name = "Cuentas_idCuenta")
    private Cuentas cuentas;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "Clientes_idCliente"),
            @JoinColumn(name = "Clientes_Usuarios_idUsuario")
    })
    private Clientes clientes;

    public int getIdClientesCuentas() {
        return idClientesCuentas;
    }

    public void setIdClientesCuentas(int idClientesCuentas) {
        this.idClientesCuentas = idClientesCuentas;
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
        int hash = 3;
        hash = 11 * hash + this.idClientesCuentas;
        hash = 11 * hash + Objects.hashCode(this.cuentas);
        hash = 11 * hash + Objects.hashCode(this.clientes);
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
        final ClientesCuentas other = (ClientesCuentas) obj;
        if (this.idClientesCuentas != other.idClientesCuentas) {
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
