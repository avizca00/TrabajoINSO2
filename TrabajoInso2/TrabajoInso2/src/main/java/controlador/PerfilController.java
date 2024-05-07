/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import EJB.ClientesFacadeLocal;
import EJB.SucursalesFacadeLocal;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import EJB.UsuariosFacadeLocal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import modelo.Clientes;
import modelo.Sucursales;
import modelo.Usuarios;

/**
 *
 * @author aiviz
 */
@Named
@ViewScoped
public class PerfilController implements Serializable {

    private Clientes cliente;
    private List<Sucursales> sucursales;
    private Sucursales cuentaSeleccionada;

    @EJB
    private ClientesFacadeLocal clienteEJB;

    @EJB
    private UsuariosFacadeLocal usuarioEJB;
    
    @EJB
    private SucursalesFacadeLocal sucursalEJB;

    @PostConstruct
    public void init() {
        cliente = new Clientes();
        cliente = clienteEJB.find(2);
        sucursales = new ArrayList<>();
        cuentaSeleccionada = new Sucursales();
        cuentaSeleccionada = cliente.getUsuario().getSucursal();
        sucursales = sucursalEJB.findAll();
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public ClientesFacadeLocal getClienteEJB() {
        return clienteEJB;
    }

    public void setClienteEJB(ClientesFacadeLocal clienteEJB) {
        this.clienteEJB = clienteEJB;
    }

    public UsuariosFacadeLocal getUsuarioEJB() {
        return usuarioEJB;
    }

    public void setUsuarioEJB(UsuariosFacadeLocal usuarioEJB) {
        this.usuarioEJB = usuarioEJB;
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

    public Sucursales getCuentaSeleccionada() {
        return cuentaSeleccionada;
    }

    public void setCuentaSeleccionada(Sucursales cuentaSeleccionada) {
        this.cuentaSeleccionada = cuentaSeleccionada;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.cliente);
        hash = 53 * hash + Objects.hashCode(this.sucursales);
        hash = 53 * hash + Objects.hashCode(this.cuentaSeleccionada);
        hash = 53 * hash + Objects.hashCode(this.clienteEJB);
        hash = 53 * hash + Objects.hashCode(this.usuarioEJB);
        hash = 53 * hash + Objects.hashCode(this.sucursalEJB);
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
        final PerfilController other = (PerfilController) obj;
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.sucursales, other.sucursales)) {
            return false;
        }
        if (!Objects.equals(this.cuentaSeleccionada, other.cuentaSeleccionada)) {
            return false;
        }
        if (!Objects.equals(this.clienteEJB, other.clienteEJB)) {
            return false;
        }
        if (!Objects.equals(this.usuarioEJB, other.usuarioEJB)) {
            return false;
        }
        if (!Objects.equals(this.sucursalEJB, other.sucursalEJB)) {
            return false;
        }
        return true;
    }

    public void actualizar() {
        try {
            cuentaSeleccionada = sucursalEJB.find(cuentaSeleccionada.getIdsucursal());
            cliente.getUsuario().setSucursal(cuentaSeleccionada);
            System.out.println(cliente.getUsuario().getSucursal().getIdsucursal());
            System.out.println(cliente.getUsuario().getSucursal().getNombre());
            usuarioEJB.edit(cliente.getUsuario());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Los datos de su perfil han sido actualizados correctamente",
                    "Datos actualizados"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    e.toString(),
                    e.toString()));
        }
    }

    public void eliminar() {
        try {
            clienteEJB.remove(cliente);
            usuarioEJB.remove(cliente.getUsuario());
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    e.toString(),
                    e.toString()));
        }
    }
}
