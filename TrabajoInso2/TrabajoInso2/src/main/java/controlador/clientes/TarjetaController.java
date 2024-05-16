/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.clientes;

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
import java.io.Serializable;
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
public class TarjetaController implements Serializable {
    private Tarjetas_De_Credito tarjeta;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((tarjeta == null) ? 0 : tarjeta.hashCode());
        result = prime * result + ((tarjetas == null) ? 0 : tarjetas.hashCode());
        result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
        result = prime * result + ((clienteCuenta == null) ? 0 : clienteCuenta.hashCode());
        result = prime * result + ((cuentas == null) ? 0 : cuentas.hashCode());
        result = prime * result + ((cuenta == null) ? 0 : cuenta.hashCode());
        result = prime * result + ((tarjetaEJB == null) ? 0 : tarjetaEJB.hashCode());
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
        TarjetaController other = (TarjetaController) obj;
        if (tarjeta == null) {
            if (other.tarjeta != null)
                return false;
        } else if (!tarjeta.equals(other.tarjeta))
            return false;
        if (tarjetas == null) {
            if (other.tarjetas != null)
                return false;
        } else if (!tarjetas.equals(other.tarjetas))
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
        if (tarjetaEJB == null) {
            if (other.tarjetaEJB != null)
                return false;
        } else if (!tarjetaEJB.equals(other.tarjetaEJB))
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

    public void crearTarjeta() {
        try {
            creaCVVAleatorio();
            creaNumeroTarjetaAleatorio();
            tarjeta.setFechaVencimiento("Hoy");
            tarjeta.setCuenta(cuenta);
            tarjetaEJB.create(tarjeta);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Info: Su tarjeta de " + tarjeta.getTipoTarjeta() + " ha sido creada y asociada correctamente.",
                    "Info: Su tarjeta de " + tarjeta.getTipoTarjeta() + " ha sido creada y asociada correctamente."));
            tarjetas = tarjetaEJB.encuentraTarejetaPorCuenta(cuentas);
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    e.toString(),
                    e.toString()));
        }
    }

    public void creaNumeroTarjetaAleatorio() {
        String numeroTarjeta = "";
        for (int i = 0; i < 20; i++) {
            numeroTarjeta += (int) (Math.random() * 10);
        }
        tarjeta.setNumeroTarjeta(numeroTarjeta);
    }

    public void creaCVVAleatorio() {
        String cvv = "";
        for (int i = 0; i < 4; i++) {
            cvv += (int) (Math.random() * 10);
        }
        tarjeta.setCVV(cvv);
    }

    // Implementar

    public void eliminarTarjeta(Tarjetas_De_Credito tarjeta) {

        System.out.println("Tarjeta: " + tarjeta);
        try {
            tarjetaEJB.remove(tarjeta);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Info: Su tarjeta de " + tarjeta.getTipoTarjeta() + " ha sido eliminada correctamente.",
                    "Info: Su tarjeta de " + tarjeta.getTipoTarjeta() + " ha sido eliminada correctamente."));
            tarjetas = tarjetaEJB.encuentraTarejetaPorCuenta(cuentas);
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    e.toString(),
                    e.toString()));
        }
    }

    public void editarTarjeta(Tarjetas_De_Credito tarjeta) {
        tarjetaEJB.edit(tarjeta);
        // tarjetas = tarjetaEJB.encuentraTarejetaPorCuenta(cuentas);
    }

    public void seleccionaTarjeta(Tarjetas_De_Credito tarjeta) {
        this.tarjeta = tarjeta;

        System.out.println("Tarjeta: " + tarjeta.getNombre());
    }

}
