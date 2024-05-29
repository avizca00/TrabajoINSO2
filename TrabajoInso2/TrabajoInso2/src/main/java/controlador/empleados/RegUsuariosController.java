/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.empleados;

import EJB.ClientesFacadeLocal;
import EJB.EmpleadosFacadeLocal;
import EJB.SucursalesFacadeLocal;
import EJB.UsuariosFacadeLocal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.Clientes;
import modelo.Empleados;
import modelo.Sucursales;
import modelo.Usuarios;

/**
 *
 * @author aiviz
 */
@Named
@ViewScoped
public class RegUsuariosController implements Serializable {
    private List<Clientes> clientes;
    private Clientes cliente;
    private Empleados empleado;
    private Sucursales sucursal;
    private List<Sucursales> sucursales;

    @EJB
    private SucursalesFacadeLocal sucursalEJB;

    @EJB
    private ClientesFacadeLocal clientesEJB;

    @EJB
    private EmpleadosFacadeLocal empleadosEJB;

    @EJB
    private UsuariosFacadeLocal usuarioEJB;

    @PostConstruct
    public void init() {
        cliente = new Clientes();
        empleado = new Empleados();
        empleado = (Empleados) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("empleado");
        clientes = new ArrayList<>();
        clientes = clientesEJB.findAll();
        sucursal = new Sucursales();
        sucursales = new ArrayList<>();
        sucursales = sucursalEJB.findAll();
    }

    public List<Clientes> getClientes() {
        return clientes;
    }

    public void setClientes(List<Clientes> clientes) {
        this.clientes = clientes;
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

    public Sucursales getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursales sucursal) {
        this.sucursal = sucursal;
    }

    public List<Sucursales> getSucursales() {
        return sucursales;
    }

    public void setSucursales(List<Sucursales> sucursales) {
        this.sucursales = sucursales;
    }

    public SucursalesFacadeLocal getSucursalEJB() {
        return sucursalEJB;
    }

    public void setSucursalEJB(SucursalesFacadeLocal sucursalEJB) {
        this.sucursalEJB = sucursalEJB;
    }

    public ClientesFacadeLocal getClientesEJB() {
        return clientesEJB;
    }

    public void setClientesEJB(ClientesFacadeLocal clientesEJB) {
        this.clientesEJB = clientesEJB;
    }

    public EmpleadosFacadeLocal getEmpleadosEJB() {
        return empleadosEJB;
    }

    public void setEmpleadosEJB(EmpleadosFacadeLocal empleadosEJB) {
        this.empleadosEJB = empleadosEJB;
    }

    public UsuariosFacadeLocal getUsuarioEJB() {
        return usuarioEJB;
    }

    public void setUsuarioEJB(UsuariosFacadeLocal usuarioEJB) {
        this.usuarioEJB = usuarioEJB;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((clientes == null) ? 0 : clientes.hashCode());
        result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
        result = prime * result + ((empleado == null) ? 0 : empleado.hashCode());
        result = prime * result + ((sucursal == null) ? 0 : sucursal.hashCode());
        result = prime * result + ((sucursales == null) ? 0 : sucursales.hashCode());
        result = prime * result + ((sucursalEJB == null) ? 0 : sucursalEJB.hashCode());
        result = prime * result + ((clientesEJB == null) ? 0 : clientesEJB.hashCode());
        result = prime * result + ((empleadosEJB == null) ? 0 : empleadosEJB.hashCode());
        result = prime * result + ((usuarioEJB == null) ? 0 : usuarioEJB.hashCode());
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
        RegUsuariosController other = (RegUsuariosController) obj;
        if (clientes == null) {
            if (other.clientes != null)
                return false;
        } else if (!clientes.equals(other.clientes))
            return false;
        if (cliente == null) {
            if (other.cliente != null)
                return false;
        } else if (!cliente.equals(other.cliente))
            return false;
        if (empleado == null) {
            if (other.empleado != null)
                return false;
        } else if (!empleado.equals(other.empleado))
            return false;
        if (sucursal == null) {
            if (other.sucursal != null)
                return false;
        } else if (!sucursal.equals(other.sucursal))
            return false;
        if (sucursales == null) {
            if (other.sucursales != null)
                return false;
        } else if (!sucursales.equals(other.sucursales))
            return false;
        if (sucursalEJB == null) {
            if (other.sucursalEJB != null)
                return false;
        } else if (!sucursalEJB.equals(other.sucursalEJB))
            return false;
        if (clientesEJB == null) {
            if (other.clientesEJB != null)
                return false;
        } else if (!clientesEJB.equals(other.clientesEJB))
            return false;
        if (empleadosEJB == null) {
            if (other.empleadosEJB != null)
                return false;
        } else if (!empleadosEJB.equals(other.empleadosEJB))
            return false;
        if (usuarioEJB == null) {
            if (other.usuarioEJB != null)
                return false;
        } else if (!usuarioEJB.equals(other.usuarioEJB))
            return false;
        return true;
    }

    public void editarCliente() {
        try {
            Clientes c = clientesEJB.find(cliente.getIdcliente());
            // Verificar si ya existe un usuario con el mismo DNI
            if (!c.getUsuario().getDniUsuario().equals(cliente.getUsuario().getDniUsuario())
                    && usuarioEJB.existeUsuarioPorDNI(cliente.getUsuario().getDniUsuario())) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "Error: El DNI ya está en uso.", "El DNI ya está en uso."));
            } else if (!c.getUsuario().getUserName().equals(cliente.getUsuario().getUserName())
                    && usuarioEJB.existeUsuarioPorUsername(cliente.getUsuario().getUserName())) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "Error: El nombre de usuario ya está en uso.", "El nombre de usuario ya está en uso."));
            } else {
                Usuarios usuario = cliente.getUsuario();
                Sucursales s = sucursalEJB.find(sucursal.getIdsucursal());
                usuario.setSucursal(s);
                usuarioEJB.edit(usuario);

                cliente.setUsuario(usuario);
                clientesEJB.edit(cliente);
                clientes = clientesEJB.findAll();
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "El cliente se ha editado correctamente",
                                "El cliente se ha editado correctamente"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al editar el cliente",
                            "Error al editar el cliente"));
        }
    }

    public void eliminarCliente() {
        try {
            Usuarios usuario = usuarioEJB.find(cliente.getUsuario().getIdusuario());
            clientesEJB.remove(cliente);
            usuarioEJB.remove(usuario);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "El cliente se ha eliminado correctamente",
                            "El cliente se ha eliminado correctamente"));
            clientes = clientesEJB.findAll();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al eliminar el cliente",
                            "Error al eliminar el cliente"));
        }
    }
}
