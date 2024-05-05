/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.Serializable;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import EJB.ClientesCuentasFacadeLocal;
import EJB.ClientesFacadeLocal;
import EJB.CuentasFacadeLocal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import modelo.Clientes;
import modelo.ClientesCuentas;
import modelo.Cuentas;

/**
 *
 * @author aiviz
 */
@Named
@ViewScoped
public class CuentaController implements Serializable {

    private Cuentas cuenta;
    private List<Cuentas> cuentas;
    private Clientes cliente;
    private ClientesCuentas clienteCuenta;

    @EJB
    private CuentasFacadeLocal cuentaEJB;

    @EJB
    private ClientesFacadeLocal clie;

    @EJB
    private ClientesCuentasFacadeLocal clienteCuentaEJB;

    @PostConstruct
    public void init() {
        cuenta = new Cuentas();
        cliente = new Clientes();
        clienteCuenta = new ClientesCuentas();
        //cliente = (Clientes) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("cliente");
        cliente = clie.encuentraPorIDUsuario(12);
        cuentas = new ArrayList<>();
    }

    public Cuentas getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuentas cuenta) {
        this.cuenta = cuenta;
    }

    public List<Cuentas> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuentas> cuentas) {
        this.cuentas = cuentas;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public CuentasFacadeLocal getCuentaEJB() {
        return cuentaEJB;
    }

    public void setCuentaEJB(CuentasFacadeLocal cuentaEJB) {
        this.cuentaEJB = cuentaEJB;
    }

    public ClientesCuentasFacadeLocal getClienteCuentaEJB() {
        return clienteCuentaEJB;
    }

    public void setClienteCuentaEJB(ClientesCuentasFacadeLocal clienteCuentaEJB) {
        this.clienteCuentaEJB = clienteCuentaEJB;
    }

    public ClientesCuentas getClienteCuenta() {
        return clienteCuenta;
    }

    public void setClienteCuenta(ClientesCuentas clienteCuenta) {
        this.clienteCuenta = clienteCuenta;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cuenta == null) ? 0 : cuenta.hashCode());
        result = prime * result + ((cuentas == null) ? 0 : cuentas.hashCode());
        result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
        result = prime * result + ((clienteCuenta == null) ? 0 : clienteCuenta.hashCode());
        result = prime * result + ((cuentaEJB == null) ? 0 : cuentaEJB.hashCode());
        result = prime * result + ((clienteCuentaEJB == null) ? 0 : clienteCuentaEJB.hashCode());
        return result;
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
        CuentaController other = (CuentaController) obj;
        if (cuenta == null) {
            if (other.cuenta != null) {
                return false;
            }
        } else if (!cuenta.equals(other.cuenta)) {
            return false;
        }
        if (cuentas == null) {
            if (other.cuentas != null) {
                return false;
            }
        } else if (!cuentas.equals(other.cuentas)) {
            return false;
        }
        if (cliente == null) {
            if (other.cliente != null) {
                return false;
            }
        } else if (!cliente.equals(other.cliente)) {
            return false;
        }
        if (clienteCuenta == null) {
            if (other.clienteCuenta != null) {
                return false;
            }
        } else if (!clienteCuenta.equals(other.clienteCuenta)) {
            return false;
        }
        if (cuentaEJB == null) {
            if (other.cuentaEJB != null) {
                return false;
            }
        } else if (!cuentaEJB.equals(other.cuentaEJB)) {
            return false;
        }
        if (clienteCuentaEJB == null) {
            if (other.clienteCuentaEJB != null) {
                return false;
            }
        } else if (!clienteCuentaEJB.equals(other.clienteCuentaEJB)) {
            return false;
        }
        return true;
    }

    public void crearCuenta() {
        try {
            Date date = new Date();
            cuenta.setFechaApertura(date);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            cuenta.setFechaUltimaTransaccion(timestamp);
            cuentaEJB.create(cuenta);
            try {
                clienteCuenta = new ClientesCuentas();
                clienteCuenta.setClientes(cliente);
                clienteCuenta.setCuentas(cuenta);
                clienteCuentaEJB.create(clienteCuenta);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Info: Su cuenta ha sido creada y asociada correctamente.",
                        "Su cuenta ha sido creada y asociada correctamente."));
            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        e.toString(),
                        e.toString()));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    e.toString(),
                    e.toString()));
        }
    }

    public ClientesFacadeLocal getClie() {
        return clie;
    }

    public void setClie(ClientesFacadeLocal clie) {
        this.clie = clie;
    }
}
