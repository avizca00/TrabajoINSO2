/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.clientes;

import javax.inject.Named;

import EJB.ClientesCuentasFacadeLocal;
import modelo.Clientes;
import modelo.Cuentas;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

/**
 *
 * @author aiviz
 */
@Named
@ViewScoped
public class MenuController implements Serializable {

    @EJB
    private ClientesCuentasFacadeLocal clientesCuentasEJB;

    private List<Cuentas> cuentas;
    
    private String error;

    @PostConstruct
    public void init() {
    }

    public String getError() {
        return error;
    }

    public void setError(String Error) {
        this.error = Error;
    }

    
    public ClientesCuentasFacadeLocal getClientesCuentasEJB() {
        return clientesCuentasEJB;
    }

    public void setClientesCuentasEJB(ClientesCuentasFacadeLocal clientesCuentasEJB) {
        this.clientesCuentasEJB = clientesCuentasEJB;
    }

    public List<Cuentas> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuentas> cuentas) {
        this.cuentas = cuentas;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.clientesCuentasEJB);
        hash = 47 * hash + Objects.hashCode(this.cuentas);
        hash = 47 * hash + Objects.hashCode(this.error);
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
        final MenuController other = (MenuController) obj;
        if (!Objects.equals(this.error, other.error)) {
            return false;
        }
        if (!Objects.equals(this.clientesCuentasEJB, other.clientesCuentasEJB)) {
            return false;
        }
        if (!Objects.equals(this.cuentas, other.cuentas)) {
            return false;
        }
        return true;
    }

    public void redirectPerfil() {
        try {
            FacesContext.getCurrentInstance().getExternalContext()
                    .redirect("/TrabajoInso2/faces/privado/clientes/perfil.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void redirectCuentas() {
        try {
            FacesContext.getCurrentInstance().getExternalContext()
                    .redirect("/TrabajoInso2/faces/privado/clientes/cuenta.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void redirectTransferencias() {
        try {
            if (!compruebaCuentas()) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(
                                "No tienes cuentas asociadas, Crea una cuenta para poder realizar transferencias.",
                                "No tienes cuentas asociadas, Crea una cuenta para poder realizar transferencias."));
            } else {
                FacesContext.getCurrentInstance().getExternalContext()
                        .redirect("/TrabajoInso2/faces/privado/clientes/transferencia.xhtml");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void redirectPrestamos() {
        try {
            if (!compruebaCuentas()) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(
                                "No tienes cuentas asociadas, Crea una cuenta para poder solicitar un préstamo.",
                                "No tienes cuentas asociadas, Crea una cuenta para poder solicitar un préstamo."));
            } else {
                FacesContext.getCurrentInstance().getExternalContext()
                        .redirect("/TrabajoInso2/faces/privado/clientes/prestamo.xhtml");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void redirectTarjetas() {
        try {
            if (!compruebaCuentas()) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(
                                "No tienes cuentas asociadas, Crea una cuenta para poder solicitar una tarjeta.",
                                "No tienes cuentas asociadas, Crea una cuenta para poder solicitar una tarjeta."));
            } else {
                FacesContext.getCurrentInstance().getExternalContext()
                        .redirect("/TrabajoInso2/faces/privado/clientes/tarjeta.xhtml");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void redirectRecibos() {
        try {
            if (!compruebaCuentas()) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage("No tienes cuentas asociadas, Crea una cuenta para poder ver tus recibos.",
                                "No tienes cuentas asociadas, Crea una cuenta para poder ver tus recibos."));
            } else {
                FacesContext.getCurrentInstance().getExternalContext()
                        .redirect("/TrabajoInso2/faces/privado/clientes/recibo.xhtml");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void redirectLogout() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("cliente");
            FacesContext.getCurrentInstance().getExternalContext()
                    .redirect(FacesContext.getCurrentInstance().getExternalContext().getApplicationContextPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void redirectOperaciones() {
        System.out.println(getError());
        try {
            if (!compruebaCuentas()) {
                errorMsg("operaciones");
            } else {
                FacesContext.getCurrentInstance().getExternalContext()
                        .redirect("/TrabajoInso2/faces/privado/clientes/operacion.xhtml");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean compruebaCuentas() {
        Clientes c = (Clientes) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("cliente");
        cuentas = clientesCuentasEJB.cuentasPorCliente(c);
        if (cuentas.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
    
    private void errorMsg(String input){
        setError("No tienes cuentas asociadas, Crea una cuenta para poder ver tus :"+input);        
    }
}
