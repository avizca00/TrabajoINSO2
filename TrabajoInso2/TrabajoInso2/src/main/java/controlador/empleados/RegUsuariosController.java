/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.empleados;

import EJB.ClientesCuentasFacadeLocal;
import EJB.ClientesFacadeLocal;
import EJB.CuentasFacade;
import EJB.CuentasFacadeLocal;
import EJB.EmpleadosFacadeLocal;
import EJB.NotificacionesRecibosFacadeLocal;
import EJB.OperacionesFacadeLocal;
import EJB.PrestamosFacadeLocal;
import EJB.RecibosDomiciliariosFacadeLocal;
import EJB.SucursalesFacadeLocal;
import EJB.Tarjetas_De_CreditoFacadeLocal;
import EJB.TransferenciasFacadeLocal;
import EJB.UsuariosFacadeLocal;
import java.io.IOException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.Clientes;
import modelo.ClientesCuentas;
import modelo.Cuentas;
import modelo.Empleados;
import modelo.NotificacionesRecibos;
import modelo.Operaciones;
import modelo.Prestamos;
import modelo.RecibosDomiciliarios;
import modelo.Sucursales;
import modelo.Tarjetas_De_Credito;
import modelo.Transferencias;
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

    @EJB
    private ClientesCuentasFacadeLocal clientesCuentasEJB;

    @EJB
    private CuentasFacadeLocal cuentasEJB;

    @EJB
    private Tarjetas_De_CreditoFacadeLocal tarjetasEJB;

    @EJB
    private TransferenciasFacadeLocal transferenciasEJB;

    @EJB
    private OperacionesFacadeLocal operacionesEJB;

    @EJB
    private PrestamosFacadeLocal prestamosEJB;

    @EJB
    private RecibosDomiciliariosFacadeLocal recibosEJB;

    @EJB
    private NotificacionesRecibosFacadeLocal notificacionesEJB;

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

    public ClientesCuentasFacadeLocal getClientesCuentasEJB() {
        return clientesCuentasEJB;
    }

    public void setClientesCuentasEJB(ClientesCuentasFacadeLocal clientesCuentasEJB) {
        this.clientesCuentasEJB = clientesCuentasEJB;
    }

    public CuentasFacadeLocal getCuentasEJB() {
        return cuentasEJB;
    }

    public void setCuentasEJB(CuentasFacadeLocal cuentasEJB) {
        this.cuentasEJB = cuentasEJB;
    }

    public Tarjetas_De_CreditoFacadeLocal getTarjetasEJB() {
        return tarjetasEJB;
    }

    public void setTarjetasEJB(Tarjetas_De_CreditoFacadeLocal tarjetasEJB) {
        this.tarjetasEJB = tarjetasEJB;
    }

    public TransferenciasFacadeLocal getTransferenciasEJB() {
        return transferenciasEJB;
    }

    public void setTransferenciasEJB(TransferenciasFacadeLocal transferenciasEJB) {
        this.transferenciasEJB = transferenciasEJB;
    }

    public OperacionesFacadeLocal getOperacionesEJB() {
        return operacionesEJB;
    }

    public void setOperacionesEJB(OperacionesFacadeLocal operacionesEJB) {
        this.operacionesEJB = operacionesEJB;
    }

    public PrestamosFacadeLocal getPrestamosEJB() {
        return prestamosEJB;
    }

    public void setPrestamosEJB(PrestamosFacadeLocal prestamosEJB) {
        this.prestamosEJB = prestamosEJB;
    }

    public RecibosDomiciliariosFacadeLocal getRecibosEJB() {
        return recibosEJB;
    }

    public void setRecibosEJB(RecibosDomiciliariosFacadeLocal recibosEJB) {
        this.recibosEJB = recibosEJB;
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
        result = prime * result + ((clientesCuentasEJB == null) ? 0 : clientesCuentasEJB.hashCode());
        result = prime * result + ((cuentasEJB == null) ? 0 : cuentasEJB.hashCode());
        result = prime * result + ((tarjetasEJB == null) ? 0 : tarjetasEJB.hashCode());
        result = prime * result + ((transferenciasEJB == null) ? 0 : transferenciasEJB.hashCode());
        result = prime * result + ((operacionesEJB == null) ? 0 : operacionesEJB.hashCode());
        result = prime * result + ((prestamosEJB == null) ? 0 : prestamosEJB.hashCode());
        result = prime * result + ((recibosEJB == null) ? 0 : recibosEJB.hashCode());
        result = prime * result + ((notificacionesEJB == null) ? 0 : notificacionesEJB.hashCode());
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
        if (clientesCuentasEJB == null) {
            if (other.clientesCuentasEJB != null)
                return false;
        } else if (!clientesCuentasEJB.equals(other.clientesCuentasEJB))
            return false;
        if (cuentasEJB == null) {
            if (other.cuentasEJB != null)
                return false;
        } else if (!cuentasEJB.equals(other.cuentasEJB))
            return false;
        if (tarjetasEJB == null) {
            if (other.tarjetasEJB != null)
                return false;
        } else if (!tarjetasEJB.equals(other.tarjetasEJB))
            return false;
        if (transferenciasEJB == null) {
            if (other.transferenciasEJB != null)
                return false;
        } else if (!transferenciasEJB.equals(other.transferenciasEJB))
            return false;
        if (operacionesEJB == null) {
            if (other.operacionesEJB != null)
                return false;
        } else if (!operacionesEJB.equals(other.operacionesEJB))
            return false;
        if (prestamosEJB == null) {
            if (other.prestamosEJB != null)
                return false;
        } else if (!prestamosEJB.equals(other.prestamosEJB))
            return false;
        if (recibosEJB == null) {
            if (other.recibosEJB != null)
                return false;
        } else if (!recibosEJB.equals(other.recibosEJB))
            return false;
        if (notificacionesEJB == null) {
            if (other.notificacionesEJB != null)
                return false;
        } else if (!notificacionesEJB.equals(other.notificacionesEJB))
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
                
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "El cliente se ha editado correctamente",
                                "El cliente se ha editado correctamente"));
            }
            clientes = clientesEJB.findAll();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al editar el cliente",
                            "Error al editar el cliente"));
        }
    }

    public void eliminarCliente() {
        try {
            Usuarios usuario = usuarioEJB.find(cliente.getUsuario().getIdusuario());
            borraTodaInfoCLiente(cliente);
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

    public void redirectCuentas() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("cliente", cliente);
            FacesContext.getCurrentInstance().getExternalContext()
                    .redirect("/TrabajoInso2/faces/privado/empleados/cuentaE.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void redirectTransferencias() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("cliente", cliente);
            FacesContext.getCurrentInstance().getExternalContext()
                    .redirect("/TrabajoInso2/faces/privado/empleados/transferenciaE.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void redirectPrestamos() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("cliente", cliente);
            FacesContext.getCurrentInstance().getExternalContext()
                    .redirect("/TrabajoInso2/faces/privado/empleados/prestamoE.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void redirectTarjetas() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("cliente", cliente);
            FacesContext.getCurrentInstance().getExternalContext()
                    .redirect("/TrabajoInso2/faces/privado/empleados/tarjetaE.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void redirectRecibos() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("cliente", cliente);
            FacesContext.getCurrentInstance().getExternalContext()
                    .redirect("/TrabajoInso2/faces/privado/empleados/reciboE.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void redirectOperaciones() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("cliente", cliente);
            FacesContext.getCurrentInstance().getExternalContext()
                    .redirect("/TrabajoInso2/faces/privado/empleados/operacionE.xhtml");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void borraTodaInfoCLiente(Clientes cliente) {
        List<Cuentas> cuentas = new ArrayList<>();
        List<Transferencias> transferencias = new ArrayList<>();
        List<NotificacionesRecibos> notificaciones = new ArrayList<>();
        List<RecibosDomiciliarios> recibos = new ArrayList<>();
        List<Operaciones> operaciones = new ArrayList<>();
        List<Tarjetas_De_Credito> tarjetas = new ArrayList<>();
        List<Prestamos> prestamos = new ArrayList<>();
        List<ClientesCuentas> clientesCuentas = new ArrayList<>();

        cuentas = clientesCuentasEJB.cuentasPorCliente(cliente);
        if (!cuentas.isEmpty()) {
            clientesCuentas = clientesCuentasEJB.findAll()
                    .stream()
                    .filter(cc -> cc.getClientes().equals(cliente))
                    .collect(Collectors.toList());
            transferencias = transferenciasEJB.transferenciasPorCuenta(cuentas);
            operaciones = operacionesEJB.operacionesPorCuenta(cuentas);
            tarjetas = tarjetasEJB.encuentraTarejetaPorCuenta(cuentas);
            prestamos = prestamosEJB.prestamosPorCuenta(cuentas);
            recibos = recibosEJB.recibosPorCuenta(cuentas);

            for (Transferencias t : transferencias) {
                transferenciasEJB.remove(t);
            }

            for (Operaciones o : operaciones) {
                operacionesEJB.remove(o);
            }

            for (Tarjetas_De_Credito t : tarjetas) {
                tarjetasEJB.remove(t);
            }

            for (Prestamos p : prestamos) {
                prestamosEJB.remove(p);
            }

            for (RecibosDomiciliarios r : recibos) {
                List<NotificacionesRecibos> notificacionesRecibos = new ArrayList<>();
                notificacionesRecibos = notificacionesEJB.notificacionesPorRecibo(r);

                for (NotificacionesRecibos n : notificacionesRecibos) {
                    notificacionesEJB.remove(n);
                }
                recibosEJB.remove(r);
            }

            for (ClientesCuentas cc : clientesCuentas) {
                clientesCuentasEJB.remove(cc);
            }

            for (Cuentas c : cuentas) {
                cuentasEJB.remove(c);
            }
        }

        clientesEJB.remove(cliente);
    }

    public NotificacionesRecibosFacadeLocal getNotificacionesEJB() {
        return notificacionesEJB;
    }

    public void setNotificacionesEJB(NotificacionesRecibosFacadeLocal notificacionesEJB) {
        this.notificacionesEJB = notificacionesEJB;
    }

}
