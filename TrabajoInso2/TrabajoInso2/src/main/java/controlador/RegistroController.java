/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import EJB.ClientesFacadeLocal;
import EJB.EmpleadosFacadeLocal;
import EJB.UsuariosFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
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
public class RegistroController implements Serializable{
    private Clientes cliente;
    private Empleados empleado;
    private Usuarios usuario;
    private Sucursales sucursal;
    private List<Sucursales> sucursales;

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
        sucursal = new Sucursales();
        sucursales= new ArrayList<>();
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

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public Sucursales getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursales sucursal) {
        this.sucursal = sucursal;
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

    public List<Sucursales> getSucursales() {
        return sucursales;
    }

    public void setSucursales(List<Sucursales> sucursales) {
        this.sucursales = sucursales;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.cliente);
        hash = 41 * hash + Objects.hashCode(this.empleado);
        hash = 41 * hash + Objects.hashCode(this.usuario);
        hash = 41 * hash + Objects.hashCode(this.sucursal);
        hash = 41 * hash + Objects.hashCode(this.sucursales);
        hash = 41 * hash + Objects.hashCode(this.usuarioEJB);
        hash = 41 * hash + Objects.hashCode(this.clienteEJB);
        hash = 41 * hash + Objects.hashCode(this.empleadoEJB);
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
        final RegistroController other = (RegistroController) obj;
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.empleado, other.empleado)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.sucursal, other.sucursal)) {
            return false;
        }
        if (!Objects.equals(this.sucursales, other.sucursales)) {
            return false;
        }
        if (!Objects.equals(this.usuarioEJB, other.usuarioEJB)) {
            return false;
        }
        if (!Objects.equals(this.clienteEJB, other.clienteEJB)) {
            return false;
        }
        if (!Objects.equals(this.empleadoEJB, other.empleadoEJB)) {
            return false;
        }
        return true;
    }


}