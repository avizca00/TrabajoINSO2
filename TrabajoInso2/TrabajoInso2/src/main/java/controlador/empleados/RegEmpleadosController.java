/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.empleados;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import EJB.ClientesFacadeLocal;
import EJB.EmpleadosFacadeLocal;
import EJB.SucursalesFacadeLocal;
import EJB.UsuariosFacadeLocal;
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
public class RegEmpleadosController implements Serializable {

    private List<Empleados> empleados;
    private Empleados empleadoMod;
    private Empleados empleadoReg;
    private Empleados empleado;
    private Sucursales sucursal;
    private List<Sucursales> sucursales;
    private Usuarios usuario;

    @EJB
    private SucursalesFacadeLocal sucursalEJB;

    @EJB
    private EmpleadosFacadeLocal empleadosEJB;

    @EJB
    private UsuariosFacadeLocal usuarioEJB;

    @PostConstruct
    public void init() {
        empleadoMod = new Empleados();
        usuario = new Usuarios();
        empleadoReg = new Empleados();
        empleado = new Empleados();
        empleado = (Empleados) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("empleado");
        empleados = new ArrayList<>();
        empleados = empleadosEJB.findAll();
        sucursal = new Sucursales();
        sucursales = new ArrayList<>();
        sucursales = sucursalEJB.findAll();
    }

    public List<Empleados> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleados> empleados) {
        this.empleados = empleados;
    }

    public Empleados getEmpleadoMod() {
        return empleadoMod;
    }

    public void setEmpleadoMod(Empleados empleadoMod) {
        this.empleadoMod = empleadoMod;
    }

    public Empleados getEmpleadoReg() {
        return empleadoReg;
    }

    public void setEmpleadoReg(Empleados empleadoReg) {
        this.empleadoReg = empleadoReg;
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

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((empleados == null) ? 0 : empleados.hashCode());
        result = prime * result + ((empleadoMod == null) ? 0 : empleadoMod.hashCode());
        result = prime * result + ((empleadoReg == null) ? 0 : empleadoReg.hashCode());
        result = prime * result + ((empleado == null) ? 0 : empleado.hashCode());
        result = prime * result + ((sucursal == null) ? 0 : sucursal.hashCode());
        result = prime * result + ((sucursales == null) ? 0 : sucursales.hashCode());
        result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
        result = prime * result + ((sucursalEJB == null) ? 0 : sucursalEJB.hashCode());
        result = prime * result + ((empleadosEJB == null) ? 0 : empleadosEJB.hashCode());
        result = prime * result + ((usuarioEJB == null) ? 0 : usuarioEJB.hashCode());
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
        RegEmpleadosController other = (RegEmpleadosController) obj;
        if (empleados == null) {
            if (other.empleados != null) {
                return false;
            }
        } else if (!empleados.equals(other.empleados)) {
            return false;
        }
        if (empleadoMod == null) {
            if (other.empleadoMod != null) {
                return false;
            }
        } else if (!empleadoMod.equals(other.empleadoMod)) {
            return false;
        }
        if (empleadoReg == null) {
            if (other.empleadoReg != null) {
                return false;
            }
        } else if (!empleadoReg.equals(other.empleadoReg)) {
            return false;
        }
        if (empleado == null) {
            if (other.empleado != null) {
                return false;
            }
        } else if (!empleado.equals(other.empleado)) {
            return false;
        }
        if (sucursal == null) {
            if (other.sucursal != null) {
                return false;
            }
        } else if (!sucursal.equals(other.sucursal)) {
            return false;
        }
        if (sucursales == null) {
            if (other.sucursales != null) {
                return false;
            }
        } else if (!sucursales.equals(other.sucursales)) {
            return false;
        }
        if (usuario == null) {
            if (other.usuario != null) {
                return false;
            }
        } else if (!usuario.equals(other.usuario)) {
            return false;
        }
        if (sucursalEJB == null) {
            if (other.sucursalEJB != null) {
                return false;
            }
        } else if (!sucursalEJB.equals(other.sucursalEJB)) {
            return false;
        }
        if (empleadosEJB == null) {
            if (other.empleadosEJB != null) {
                return false;
            }
        } else if (!empleadosEJB.equals(other.empleadosEJB)) {
            return false;
        }
        if (usuarioEJB == null) {
            if (other.usuarioEJB != null) {
                return false;
            }
        } else if (!usuarioEJB.equals(other.usuarioEJB)) {
            return false;
        }
        return true;
    }

    public void editarEmpleado() {
        try {
            Empleados c = empleadosEJB.find(empleadoMod.getIdempleado());
            if (!c.getUsuario().getDniUsuario().equals(empleadoMod.getUsuario().getDniUsuario())
                    && usuarioEJB.existeUsuarioPorDNI(empleadoMod.getUsuario().getDniUsuario())) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "Error: El DNI ya está en uso.", "El DNI ya está en uso."));
            } else if (!c.getUsuario().getUserName().equals(empleadoMod.getUsuario().getUserName())
                    && usuarioEJB.existeUsuarioPorUsername(empleadoMod.getUsuario().getUserName())) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "Error: El nombre de usuario ya está en uso.", "El nombre de usuario ya está en uso."));
            } else {
                Usuarios usuario = empleadoMod.getUsuario();
                Sucursales s = sucursalEJB.find(sucursal.getIdsucursal());
                usuario.setSucursal(s);
                usuarioEJB.edit(usuario);

                empleadoMod.setUsuario(usuario);
                empleadosEJB.edit(empleadoMod);
                empleados = empleadosEJB.findAll();
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "El empleado se ha editado correctamente",
                                "El empleado se ha editado correctamente"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al editar el cliente",
                            "Error al editar el cliente"));
        }
    }

    public void eliminarEmpleado() {
        try {
            Usuarios u = usuarioEJB.find(empleadoMod.getUsuario().getIdusuario());
            empleadosEJB.remove(empleadoMod);
            usuarioEJB.remove(u);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "El empleado se ha eliminado correctamente",
                            "El empleado se ha eliminado correctamente"));
            empleados = empleadosEJB.findAll();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al eliminar el empleado",
                            "Error al eliminar el cliente"));
        }
    }

    public void crearEmpleado() {
        // Verificar si ya existe un usuario con el mismo DNI
        if (usuarioEJB.existeUsuarioPorDNI(usuario.getDniUsuario())) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error: El DNI ya está en uso.", "El DNI ya está en uso."));
            return;
        }

        // Verificar si ya existe un usuario con el mismo username
        if (usuarioEJB.existeUsuarioPorUsername(usuario.getUserName())) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error: El nombre de usuario ya está en uso.", "El nombre de usuario ya está en uso."));
            return;
        }
        Sucursales s = sucursalEJB.find(sucursal.getIdsucursal());
        usuario.setSucursal(s);
        usuarioEJB.create(usuario);
        Date date = new Date();

        empleado.setUsuario(usuario);
        empleado.setFechaContratacion(date);
        empleadosEJB.create(empleado);
        usuario = new Usuarios();
        empleado = new Empleados();
        empleados = empleadosEJB.findAll();
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Info: El empleado ha sido registrado correctamente.",
                        "nfo: El empleado ha sido registrado correctamente."));
        System.out.println(sucursal.getIdsucursal());
    }
}
