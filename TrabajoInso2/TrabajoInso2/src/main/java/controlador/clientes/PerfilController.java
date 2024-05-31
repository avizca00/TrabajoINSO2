/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.clientes;

import EJB.ClientesCuentasFacadeLocal;
import EJB.ClientesFacadeLocal;
import EJB.CuentasFacadeLocal;
import EJB.NotificacionesRecibosFacadeLocal;
import EJB.OperacionesFacadeLocal;
import EJB.PrestamosFacadeLocal;
import EJB.RecibosDomiciliariosFacadeLocal;
import EJB.SucursalesFacadeLocal;
import EJB.Tarjetas_De_CreditoFacadeLocal;
import EJB.TransferenciasFacadeLocal;
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
import java.util.stream.Collectors;
import modelo.Clientes;
import modelo.ClientesCuentas;
import modelo.Cuentas;
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
        cliente = (Clientes) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("cliente");
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
            Usuarios usuario = cliente.getUsuario();
            usuario.setSucursal(cuentaSeleccionada);
            usuarioEJB.edit(usuario);
            usuarioEJB.edit(cliente.getUsuario());
            cliente.setUsuario(usuario);
            clienteEJB.edit(cliente);
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("cliente");
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("cliente", cliente);
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
            Usuarios u = usuarioEJB.find(cliente.getUsuario().getIdusuario());
            borraTodaInfoCLiente(cliente);
            usuarioEJB.remove(u);
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("cliente");
            FacesContext.getCurrentInstance().getExternalContext()
                    .redirect(FacesContext.getCurrentInstance().getExternalContext().getApplicationContextPath());
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    e.toString(),
                    e.toString()));
        }
    }

    private void borraTodaInfoCLiente(Clientes cliente) {
        List<Cuentas> cuentas = new ArrayList<>();
        List<Transferencias> transferencias = new ArrayList<>();
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

        clienteEJB.remove(cliente);
    }
}
