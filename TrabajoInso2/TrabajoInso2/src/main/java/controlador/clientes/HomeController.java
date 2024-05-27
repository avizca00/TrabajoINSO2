/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.clientes;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.Clientes;

/**
 *
 * @author aiviz
 */
@Named
@ViewScoped
public class HomeController implements Serializable {

    private Clientes cliente;

    @PostConstruct
    public void init() {
        cliente = new Clientes();
        cliente = (Clientes) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("cliente");
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
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
        HomeController other = (HomeController) obj;
        if (cliente == null) {
            if (other.cliente != null) {
                return false;
            }
        } else if (!cliente.equals(other.cliente)) {
            return false;
        }
        return true;
    }

    public void redirectHome() {
        try {
            FacesContext.getCurrentInstance().getExternalContext()
                    .redirect("/TrabajoInso2/faces/privado/clientes/home.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
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
            FacesContext.getCurrentInstance().getExternalContext()
                    .redirect("/TrabajoInso2/faces/privado/clientes/transferencia.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void redirectPrestamos() {
        try {
            FacesContext.getCurrentInstance().getExternalContext()
                    .redirect("/TrabajoInso2/faces/privado/clientes/prestamo.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void redirectTarjetas() {
        try {
            FacesContext.getCurrentInstance().getExternalContext()
                    .redirect("/TrabajoInso2/faces/privado/clientes/tarjeta.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void redirectRecibos() {
        try {
            FacesContext.getCurrentInstance().getExternalContext()
                    .redirect("/TrabajoInso2/faces/privado/clientes/recibo.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void redirectLogout() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            FacesContext.getCurrentInstance().getExternalContext()
                    .redirect(FacesContext.getCurrentInstance().getExternalContext().getApplicationContextPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
