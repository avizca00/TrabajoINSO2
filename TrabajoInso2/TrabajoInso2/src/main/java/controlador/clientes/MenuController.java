/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.clientes;

import javax.inject.Named;

import org.primefaces.model.menu.MenuModel;

import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;

/**
 *
 * @author aiviz
 */
@Named
@ViewScoped
public class MenuController implements Serializable {

    @PostConstruct
    public void init() {
        System.out.println("aaa");
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
