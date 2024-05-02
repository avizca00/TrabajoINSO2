package modelo;

import java.io.Serializable;
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
import modelo.Clientes;
import modelo.Cuentas;

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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.idClientesCuentas);
        hash = 19 * hash + Objects.hashCode(this.cuentas);
        hash = 19 * hash + Objects.hashCode(this.clientes);
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
        if (!Objects.equals(this.idClientesCuentas, other.idClientesCuentas)) {
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

    public void setIdClientesCuentas(Integer idClientesCuentas) {
        this.idClientesCuentas = idClientesCuentas;
    }

    public void setCuentas(Cuentas cuentas) {
        this.cuentas = cuentas;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }

    public Integer getIdClientesCuentas() {
        return idClientesCuentas;
    }

    public Cuentas getCuentas() {
        return cuentas;
    }

    public Clientes getClientes() {
        return clientes;
    }
}
