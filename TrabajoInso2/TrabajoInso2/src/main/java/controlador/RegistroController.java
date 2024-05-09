/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import EJB.ClientesFacadeLocal;
import EJB.EmpleadosFacadeLocal;
import EJB.SucursalesFacadeLocal;
import EJB.UsuariosFacadeLocal;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
public class RegistroController implements Serializable {

    private Clientes cliente;
    private Empleados empleado;
    private Usuarios usuario;
    private Sucursales sucursal;
    private List<Sucursales> sucursales;
    private String rol;
    private String confirmPassword;

    @EJB
    private UsuariosFacadeLocal usuarioEJB;

    @EJB
    private ClientesFacadeLocal clienteEJB;

    @EJB
    private EmpleadosFacadeLocal empleadoEJB;

    @EJB
    private SucursalesFacadeLocal sucursalEJB;

    @PostConstruct
    public void init() {
        usuario = new Usuarios();
        cliente = new Clientes();
        empleado = new Empleados();
        sucursal = new Sucursales();
        sucursales = new ArrayList<>();
        sucursales = sucursalEJB.findAll();
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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public SucursalesFacadeLocal getSucursalEJB() {
        return sucursalEJB;
    }

    public void setSucursalEJB(SucursalesFacadeLocal sucursalEJB) {
        this.sucursalEJB = sucursalEJB;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.cliente);
        hash = 23 * hash + Objects.hashCode(this.empleado);
        hash = 23 * hash + Objects.hashCode(this.usuario);
        hash = 23 * hash + Objects.hashCode(this.sucursal);
        hash = 23 * hash + Objects.hashCode(this.sucursales);
        hash = 23 * hash + Objects.hashCode(this.rol);
        hash = 23 * hash + Objects.hashCode(this.confirmPassword);
        hash = 23 * hash + Objects.hashCode(this.usuarioEJB);
        hash = 23 * hash + Objects.hashCode(this.clienteEJB);
        hash = 23 * hash + Objects.hashCode(this.empleadoEJB);
        hash = 23 * hash + Objects.hashCode(this.sucursalEJB);
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
        if (!Objects.equals(this.rol, other.rol)) {
            return false;
        }
        if (!Objects.equals(this.confirmPassword, other.confirmPassword)) {
            return false;
        }
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
        if (!Objects.equals(this.sucursalEJB, other.sucursalEJB)) {
            return false;
        }
        return true;
    }

    public void registrar() {
        if (!usuario.getContrasenia().equals(confirmPassword)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: Las contraseñas no coinciden.", "Las contraseñas no coinciden."));
            return;
        }

        // Verificar si ya existe un usuario con el mismo DNI
        if (usuarioEJB.existeUsuarioPorDNI(usuario.getDniUsuario())) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: El DNI ya está en uso.", "El DNI ya está en uso."));
            return;
        }

        // Verificar si ya existe un usuario con el mismo username
        if (usuarioEJB.existeUsuarioPorUsername(usuario.getUserName())) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: El nombre de usuario ya está en uso.", "El nombre de usuario ya está en uso."));
            return;
        }

        Sucursales s = new Sucursales();
        s = sucursalEJB.find(sucursal.getIdsucursal());
        usuario.setSucursal(sucursal);
        usuarioEJB.create(usuario);
        Date date = new Date();

        if (rol.equals("Cliente")) {
            cliente.setUsuario(usuario);
            cliente.setFechaAlta(date);
            clienteEJB.create(cliente);

        } else {
            empleado.setUsuario(usuario);
            empleado.setFechaContratacion(date);
            empleadoEJB.create(empleado);
        }

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info: Su "+rol+" ha sido registrado exitosamente", "El nombre de usuario ya está en uso."));

    }

    public void redirect() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }

}
