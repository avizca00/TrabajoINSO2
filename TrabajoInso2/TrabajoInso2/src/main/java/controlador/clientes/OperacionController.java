/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.clientes;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import EJB.ClientesCuentasFacadeLocal;
import EJB.ClientesFacadeLocal;
import EJB.CuentasFacadeLocal;
import EJB.OperacionesFacadeLocal;
import modelo.Clientes;
import modelo.ClientesCuentas;
import modelo.Cuentas;
import modelo.Operaciones;

/**
 *
 * @author aiviz
 */
@Named
@ViewScoped
public class OperacionController implements Serializable {
    private Operaciones operacion;
    private List<Operaciones> operaciones;
    private Clientes cliente;
    private ClientesCuentas clienteCuenta;
    private List<Cuentas> cuentas;
    private Cuentas cuenta;

    @EJB
    private OperacionesFacadeLocal operacionEJB;

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
        cliente = (Clientes) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("cliente");
        cuentas = new ArrayList<>();
        cuentas = clienteCuentaEJB.cuentasPorCliente(cliente);
        operacion = new Operaciones();
        operaciones = new ArrayList<>();
        operaciones = operacionEJB.operacionesPorCuenta(cuentas);
    }

    public Operaciones getOperacion() {
        return operacion;
    }

    public void setOperacion(Operaciones operacion) {
        this.operacion = operacion;
    }

    public List<Operaciones> getOperaciones() {
        return operaciones;
    }

    public void setOperaciones(List<Operaciones> operaciones) {
        this.operaciones = operaciones;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public ClientesCuentas getClienteCuenta() {
        return clienteCuenta;
    }

    public void setClienteCuenta(ClientesCuentas clienteCuenta) {
        this.clienteCuenta = clienteCuenta;
    }

    public List<Cuentas> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuentas> cuentas) {
        this.cuentas = cuentas;
    }

    public Cuentas getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuentas cuenta) {
        this.cuenta = cuenta;
    }

    public OperacionesFacadeLocal getOperacionEJB() {
        return operacionEJB;
    }

    public void setOperacionEJB(OperacionesFacadeLocal operacionEJB) {
        this.operacionEJB = operacionEJB;
    }

    public CuentasFacadeLocal getCuentaEJB() {
        return cuentaEJB;
    }

    public void setCuentaEJB(CuentasFacadeLocal cuentaEJB) {
        this.cuentaEJB = cuentaEJB;
    }

    public ClientesFacadeLocal getClie() {
        return clie;
    }

    public void setClie(ClientesFacadeLocal clie) {
        this.clie = clie;
    }

    public ClientesCuentasFacadeLocal getClienteCuentaEJB() {
        return clienteCuentaEJB;
    }

    public void setClienteCuentaEJB(ClientesCuentasFacadeLocal clienteCuentaEJB) {
        this.clienteCuentaEJB = clienteCuentaEJB;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((operacion == null) ? 0 : operacion.hashCode());
        result = prime * result + ((operaciones == null) ? 0 : operaciones.hashCode());
        result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
        result = prime * result + ((clienteCuenta == null) ? 0 : clienteCuenta.hashCode());
        result = prime * result + ((cuentas == null) ? 0 : cuentas.hashCode());
        result = prime * result + ((cuenta == null) ? 0 : cuenta.hashCode());
        result = prime * result + ((operacionEJB == null) ? 0 : operacionEJB.hashCode());
        result = prime * result + ((cuentaEJB == null) ? 0 : cuentaEJB.hashCode());
        result = prime * result + ((clie == null) ? 0 : clie.hashCode());
        result = prime * result + ((clienteCuentaEJB == null) ? 0 : clienteCuentaEJB.hashCode());
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
        OperacionController other = (OperacionController) obj;
        if (operacion == null) {
            if (other.operacion != null)
                return false;
        } else if (!operacion.equals(other.operacion))
            return false;
        if (operaciones == null) {
            if (other.operaciones != null)
                return false;
        } else if (!operaciones.equals(other.operaciones))
            return false;
        if (cliente == null) {
            if (other.cliente != null)
                return false;
        } else if (!cliente.equals(other.cliente))
            return false;
        if (clienteCuenta == null) {
            if (other.clienteCuenta != null)
                return false;
        } else if (!clienteCuenta.equals(other.clienteCuenta))
            return false;
        if (cuentas == null) {
            if (other.cuentas != null)
                return false;
        } else if (!cuentas.equals(other.cuentas))
            return false;
        if (cuenta == null) {
            if (other.cuenta != null)
                return false;
        } else if (!cuenta.equals(other.cuenta))
            return false;
        if (operacionEJB == null) {
            if (other.operacionEJB != null)
                return false;
        } else if (!operacionEJB.equals(other.operacionEJB))
            return false;
        if (cuentaEJB == null) {
            if (other.cuentaEJB != null)
                return false;
        } else if (!cuentaEJB.equals(other.cuentaEJB))
            return false;
        if (clie == null) {
            if (other.clie != null)
                return false;
        } else if (!clie.equals(other.clie))
            return false;
        if (clienteCuentaEJB == null) {
            if (other.clienteCuentaEJB != null)
                return false;
        } else if (!clienteCuentaEJB.equals(other.clienteCuentaEJB))
            return false;
        return true;
    }

    public void creaOperacion() {
        setCuenta(cuentaEJB.find(cuenta.getIdcuenta()));

        if(operacion.getTipoOperacion().equals("Retirada")){
            if(operacion.getImporte().compareTo(cuenta.getSaldo()) == 1){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "Error: No se puede retirar más dinero del que hay en la cuenta. Saldo actual: " + cuenta.getSaldo()+"€",
                        "Error: No se puede retirar más dinero del que hay en la cuenta. Saldo actual: " + cuenta.getSaldo()+"€"));
            }else{
                try {
                    cuenta.setSaldo(cuenta.getSaldo().subtract(operacion.getImporte()));
                    cuentaEJB.edit(cuenta);
                    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                    operacion.setFecha(timestamp);
                    operacion.setEstado(0);
                    operacion.setCuenta(cuenta);
                    operacionEJB.create(operacion);
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Info: Su operación de " + operacion.getTipoOperacion() + " ha sido realizada correctamente. Saldo actual: " + cuenta.getSaldo()+"€",
                            "Info: Su operación de " + operacion.getTipoOperacion() + " ha sido realizada correctamente. Saldo actual: " + cuenta.getSaldo()+"€"));
                    operaciones = operacionEJB.operacionesPorCuenta(cuentas);
                } catch (Exception e) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            e.toString(),
                            e.toString()));
                }
            }
        }else{
            try {
                cuenta.setSaldo(cuenta.getSaldo().add(operacion.getImporte()));
                cuentaEJB.edit(cuenta);
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                operacion.setFecha(timestamp);
                operacion.setEstado(0);
                operacion.setCuenta(cuenta);
                operacionEJB.create(operacion);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Info: Su operación de " + operacion.getTipoOperacion() + " ha sido realizada correctamente. Saldo actual: " + cuenta.getSaldo()+"€",
                        "Info: Su operación de " + operacion.getTipoOperacion() + " ha sido realizada correctamente. Saldo actual: " + cuenta.getSaldo()+"€"));
                operaciones = operacionEJB.operacionesPorCuenta(cuentas);
            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        e.toString(),
                        e.toString()));
            }
        }
    }

}
