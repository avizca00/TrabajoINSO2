/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.empleados;

import controlador.clientes.*;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import EJB.ClientesCuentasFacadeLocal;
import EJB.ClientesFacadeLocal;
import EJB.CuentasFacadeLocal;
import EJB.Tarjetas_De_CreditoFacadeLocal;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.Clientes;
import modelo.ClientesCuentas;
import modelo.Cuentas;
import modelo.Tarjetas_De_Credito;

/**
 *
 * @author aiviz
 */
@Named
@ViewScoped
public class TarjetaEController implements Serializable {

    private Tarjetas_De_Credito tarjeta;
    private Tarjetas_De_Credito tarjetaModElim;
    private List<Tarjetas_De_Credito> tarjetas;
    private Clientes cliente;
    private ClientesCuentas clienteCuenta;
    private List<Cuentas> cuentas;
    private Cuentas cuenta;

    @EJB
    private Tarjetas_De_CreditoFacadeLocal tarjetaEJB;

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
        tarjeta = new Tarjetas_De_Credito();
        tarjetas = tarjetaEJB.encuentraTarejetaPorCuenta(cuentas);
        tarjetaModElim = new Tarjetas_De_Credito();
    }

    public Tarjetas_De_Credito getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjetas_De_Credito tarjeta) {
        this.tarjeta = tarjeta;
    }

    public List<Tarjetas_De_Credito> getTarjetas() {
        return tarjetas;
    }

    public void setTarjetas(List<Tarjetas_De_Credito> tarjetas) {
        this.tarjetas = tarjetas;
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

    public Tarjetas_De_CreditoFacadeLocal getTarjetaEJB() {
        return tarjetaEJB;
    }

    public void setTarjetaEJB(Tarjetas_De_CreditoFacadeLocal tarjetaEJB) {
        this.tarjetaEJB = tarjetaEJB;
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

    public Tarjetas_De_Credito getTarjetaModElim() {
        return tarjetaModElim;
    }

    public void setTarjetaModElim(Tarjetas_De_Credito tarjetaModElim) {
        this.tarjetaModElim = tarjetaModElim;
        System.out.println(this.tarjetaModElim.getIdtarjetascredito());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.tarjeta);
        hash = 89 * hash + Objects.hashCode(this.tarjetaModElim);
        hash = 89 * hash + Objects.hashCode(this.tarjetas);
        hash = 89 * hash + Objects.hashCode(this.cliente);
        hash = 89 * hash + Objects.hashCode(this.clienteCuenta);
        hash = 89 * hash + Objects.hashCode(this.cuentas);
        hash = 89 * hash + Objects.hashCode(this.cuenta);
        hash = 89 * hash + Objects.hashCode(this.tarjetaEJB);
        hash = 89 * hash + Objects.hashCode(this.cuentaEJB);
        hash = 89 * hash + Objects.hashCode(this.clie);
        hash = 89 * hash + Objects.hashCode(this.clienteCuentaEJB);
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
        final TarjetaEController other = (TarjetaEController) obj;
        if (!Objects.equals(this.tarjeta, other.tarjeta)) {
            return false;
        }
        if (!Objects.equals(this.tarjetaModElim, other.tarjetaModElim)) {
            return false;
        }
        if (!Objects.equals(this.tarjetas, other.tarjetas)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.clienteCuenta, other.clienteCuenta)) {
            return false;
        }
        if (!Objects.equals(this.cuentas, other.cuentas)) {
            return false;
        }
        if (!Objects.equals(this.cuenta, other.cuenta)) {
            return false;
        }
        if (!Objects.equals(this.tarjetaEJB, other.tarjetaEJB)) {
            return false;
        }
        if (!Objects.equals(this.cuentaEJB, other.cuentaEJB)) {
            return false;
        }
        if (!Objects.equals(this.clie, other.clie)) {
            return false;
        }
        if (!Objects.equals(this.clienteCuentaEJB, other.clienteCuentaEJB)) {
            return false;
        }
        return true;
    }

    public void redirectUsuarios() {
        try {
            FacesContext.getCurrentInstance().getExternalContext()
                    .redirect("/TrabajoInso2/faces/privado/empleados/regUsuarios.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
