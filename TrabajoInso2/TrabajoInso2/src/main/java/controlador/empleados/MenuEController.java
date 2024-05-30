/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.empleados;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;

/**
 *
 * @author aiviz
 */
@Named
@ViewScoped
public class MenuEController implements Serializable {

    @PostConstruct
    public void init() {
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

    public void redirectUsuarios() {
        try {
            FacesContext.getCurrentInstance().getExternalContext()
                    .redirect("/TrabajoInso2/faces/privado/empleados/regUsuarios.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void redirectEmpleados() {
        try {
            FacesContext.getCurrentInstance().getExternalContext()
                    .redirect("/TrabajoInso2/faces/privado/empleados/regEmpleados.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void redirectPrestamos() {
        try {
            FacesContext.getCurrentInstance().getExternalContext()
                    .redirect("/TrabajoInso2/faces/privado/empleados/regPrestamos.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void redirectSucursales() {
        try {
            FacesContext.getCurrentInstance().getExternalContext()
                    .redirect("/TrabajoInso2/faces/privado/empleados/sucursales.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void redirectPromociones() {
        try {
            FacesContext.getCurrentInstance().getExternalContext()
                    .redirect("/TrabajoInso2/faces/privado/empleados/promociones.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
