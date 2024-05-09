/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import EJB.ClientesFacadeLocal;
import EJB.EmpleadosFacadeLocal;
import EJB.UsuariosFacadeLocal;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.Empleados;
import modelo.Usuarios;
import modelo.Clientes;

@Named
@ViewScoped
public class InicioController implements Serializable {

    private Clientes cliente;
    private Empleados empleado;
    private Usuarios usuario;

    @EJB
    private UsuariosFacadeLocal usuarioEJB;

    @EJB
    private ClientesFacadeLocal clienteEJB;

    @EJB
    private EmpleadosFacadeLocal empleadoEJB;

    @PostConstruct
    public void init() {
        usuario = new Usuarios();
        cliente = new Clientes();
        empleado = new Empleados();
    }

    public void login() {
        try {
            Usuarios usuarioAutenticado = usuarioEJB.encuentraUsuarioPorUsernameAndPassword(usuario.getUserName(),
                    usuario.getContrasenia());

            if (usuarioAutenticado != null) {
                cliente = clienteEJB.encuentraPorIDUsuario(usuarioAutenticado.getId());
                empleado = empleadoEJB.encuentraPorIDUsuario(usuarioAutenticado.getId());
                if (cliente != null) {
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("cliente", cliente);
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/TrabajoInso2/faces/privado/clientes/home.xhtml");
                } else {
                    //FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("empleado", empleado);
                    FacesContext.getCurrentInstance().getExternalContext().redirect("pagina_empleado.xhtml");
                }
            } else {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: Credenciales inválidas", "Credenciales inválidas");
                FacesContext.getCurrentInstance().addMessage(null, message);
            }
        } catch (IOException e) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                    "Error al intentar iniciar sesión");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public Empleados getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleados empleado) {
        this.empleado = empleado;
    }

    public UsuariosFacadeLocal getUsuarioEJB() {
        return usuarioEJB;
    }

    public void setUsuarioEJB(UsuariosFacadeLocal usuarioEJB) {
        this.usuarioEJB = usuarioEJB;
    }

    public ClientesFacadeLocal getClienteEJB() {
        return clienteEJB;
    }

    public void setClienteEJB(ClientesFacadeLocal clienteEJB) {
        this.clienteEJB = clienteEJB;
    }

    public EmpleadosFacadeLocal getEmpleadoEJB() {
        return empleadoEJB;
    }

    public void setEmpleadoEJB(EmpleadosFacadeLocal empleadoEJB) {
        this.empleadoEJB = empleadoEJB;
    }

    public void redirect() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/TrabajoInso2/faces/publico/registro.xhtml");
        } catch (IOException e) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                    "Error al intentar redirigir a la página de registro");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

}
