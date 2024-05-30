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
import javax.validation.constraints.Null;

import EJB.ClientesCuentasFacadeLocal;
import EJB.ClientesFacadeLocal;
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
import java.util.stream.Collectors;
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
public class SucursalesController implements Serializable {

    private List<Sucursales> sucursales;
    private Sucursales sucursal;
    private Sucursales sucursalModElim;

    @EJB
    private SucursalesFacadeLocal sucursalEJB;

    @EJB
    private UsuariosFacadeLocal usuarioEJB;

    @EJB
    private ClientesFacadeLocal clientesEJB;

    @EJB
    private EmpleadosFacadeLocal empleadosEJB;

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
        sucursal = new Sucursales();
        sucursalModElim = new Sucursales();
        sucursales = new ArrayList<>();
        sucursales = sucursalEJB.findAll();
    }

    public List<Sucursales> getSucursales() {
        return sucursales;
    }

    public void setSucursales(List<Sucursales> sucursales) {
        this.sucursales = sucursales;
    }

    public Sucursales getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursales sucursal) {
        this.sucursal = sucursal;
    }

    public SucursalesFacadeLocal getSucursalEJB() {
        return sucursalEJB;
    }

    public void setSucursalEJB(SucursalesFacadeLocal sucursalEJB) {
        this.sucursalEJB = sucursalEJB;
    }

    public UsuariosFacadeLocal getUsuarioEJB() {
        return usuarioEJB;
    }

    public void setUsuarioEJB(UsuariosFacadeLocal usuarioEJB) {
        this.usuarioEJB = usuarioEJB;
    }

    public Sucursales getSucursalModElim() {
        return sucursalModElim;
    }

    public void setSucursalModElim(Sucursales sucursalModElim) {
        this.sucursalModElim = sucursalModElim;
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

    public NotificacionesRecibosFacadeLocal getNotificacionesEJB() {
        return notificacionesEJB;
    }

    public void setNotificacionesEJB(NotificacionesRecibosFacadeLocal notificacionesEJB) {
        this.notificacionesEJB = notificacionesEJB;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((sucursales == null) ? 0 : sucursales.hashCode());
        result = prime * result + ((sucursal == null) ? 0 : sucursal.hashCode());
        result = prime * result + ((sucursalModElim == null) ? 0 : sucursalModElim.hashCode());
        result = prime * result + ((sucursalEJB == null) ? 0 : sucursalEJB.hashCode());
        result = prime * result + ((usuarioEJB == null) ? 0 : usuarioEJB.hashCode());
        result = prime * result + ((clientesEJB == null) ? 0 : clientesEJB.hashCode());
        result = prime * result + ((empleadosEJB == null) ? 0 : empleadosEJB.hashCode());
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
        SucursalesController other = (SucursalesController) obj;
        if (sucursales == null) {
            if (other.sucursales != null)
                return false;
        } else if (!sucursales.equals(other.sucursales))
            return false;
        if (sucursal == null) {
            if (other.sucursal != null)
                return false;
        } else if (!sucursal.equals(other.sucursal))
            return false;
        if (sucursalModElim == null) {
            if (other.sucursalModElim != null)
                return false;
        } else if (!sucursalModElim.equals(other.sucursalModElim))
            return false;
        if (sucursalEJB == null) {
            if (other.sucursalEJB != null)
                return false;
        } else if (!sucursalEJB.equals(other.sucursalEJB))
            return false;
        if (usuarioEJB == null) {
            if (other.usuarioEJB != null)
                return false;
        } else if (!usuarioEJB.equals(other.usuarioEJB))
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

    public void editarSucursal() {
        try {
            Sucursales sucursalAux = sucursalEJB.find(sucursalModElim.getIdsucursal());
            if (!sucursalAux.getNombre().equals(sucursalModElim.getNombre())
                    && sucursalEJB.existeSucursalConNombre(sucursalModElim.getNombre())) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ya existe una sucursal con ese nombre",
                                "Ya existe una sucursal con ese nombre"));
            } else if (!sucursalAux.getUbicacion().equals(sucursalModElim.getUbicacion())
                    && sucursalEJB.existeSucursalConDireccion(sucursalModElim.getUbicacion())) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ya existe una sucursal con esa dirección",
                                "Ya existe una sucursal con esa dirección"));
            } else if (!sucursalAux.getTelefono().equals(sucursalModElim.getTelefono())
                    && sucursalEJB.existeSucursalConTelefono(sucursalModElim.getTelefono())) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ya existe una sucursal con ese telefono",
                                "Ya existe una sucursal con ese telefono"));
            } else if (!sucursalAux.getCorreoElectronico().equals(sucursalModElim.getCorreoElectronico())
                    && sucursalEJB.existeSucursalConCorreo(sucursalModElim.getCorreoElectronico())) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ya existe una sucursal con ese correo",
                                "Ya existe una sucursal con ese correo"));
            } else {
                sucursalEJB.edit(sucursalModElim);
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "La sucursal se ha editado correctamente",
                                "La sucursal se ha editado correctamente"));
            }
            sucursales = sucursalEJB.findAll();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al editar el cliente",
                            "Error al editar el cliente"));
        }
    }

    public void eliminarSucursal() {
        try {
            Sucursales s = sucursalEJB.find(sucursal.getIdsucursal());
            borraInfoUsuarios(s);
            sucursalEJB.remove(s);
            sucursales = sucursalEJB.findAll();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "El empleado se ha eliminado correctamente",
                            "El empleado se ha eliminado correctamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al eliminar el empleado",
                            "Error al eliminar el cliente"));
        }
    }

    public void crearSucursal() {
        if (sucursalEJB.existeSucursalConNombre(sucursal.getNombre())) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ya existe una sucursal con ese nombre",
                            "Ya existe una sucursal con ese nombre"));
        } else if (sucursalEJB.existeSucursalConDireccion(sucursal.getUbicacion())) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ya existe una sucursal con esa dirección",
                            "Ya existe una sucursal con esa dirección"));
        } else if (sucursalEJB.existeSucursalConTelefono(sucursal.getTelefono())) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ya existe una sucursal con ese telefono",
                            "Ya existe una sucursal con ese telefono"));
        } else if (sucursalEJB.existeSucursalConCorreo(sucursal.getCorreoElectronico())) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ya existe una sucursal con ese correo",
                            "Ya existe una sucursal con ese correo"));
        } else {
            try {
                sucursalEJB.create(sucursal);
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "La sucursal se ha creado correctamente",
                                "La sucursal se ha creado correctamente"));
                sucursales = sucursalEJB.findAll();
            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al crear la sucursal",
                                "Error al crear la sucursal"));
            }
        }
    }

    private void borraInfoUsuarios(Sucursales sucursal) {
        List<Cuentas> cuentas = new ArrayList<>();
        List<Transferencias> transferencias = new ArrayList<>();
        List<RecibosDomiciliarios> recibos = new ArrayList<>();
        List<Operaciones> operaciones = new ArrayList<>();
        List<Tarjetas_De_Credito> tarjetas = new ArrayList<>();
        List<Prestamos> prestamos = new ArrayList<>();
        List<ClientesCuentas> clientesCuentas = new ArrayList<>();
        List<Clientes> clientes = clientesEJB.findAll();
        List<Empleados> empleados = empleadosEJB.findAll();
        List<Usuarios> usuarios = usuarioEJB.findAll();

        usuarios = usuarios.stream()
                .filter(u -> u.getSucursal().equals(sucursal))
                .collect(Collectors.toList());

        for (Usuarios u : usuarios) {
            Clientes cliente = clientes.stream()
                    .filter(c -> c.getUsuario().equals(u))
                    .findFirst()
                    .orElse(null);
            Empleados empleado = empleados.stream()
                    .filter(e -> e.getUsuario().equals(u))
                    .findFirst()
                    .orElse(null);
            if (cliente != null) {
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

            if (empleado != null) {
                empleadosEJB.remove(empleado);
            }

            usuarioEJB.remove(u);
        }
    }
}
