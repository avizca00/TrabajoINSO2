/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.empleados;

import controlador.clientes.*;
import java.io.Serializable;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import EJB.ClientesCuentasFacadeLocal;
import EJB.ClientesFacadeLocal;
import EJB.CuentasFacadeLocal;
import EJB.NotificacionesRecibosFacadeLocal;
import EJB.OperacionesFacadeLocal;
import EJB.PrestamosFacadeLocal;
import EJB.RecibosDomiciliariosFacadeLocal;
import EJB.Tarjetas_De_CreditoFacadeLocal;
import EJB.TransferenciasFacadeLocal;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import modelo.Clientes;
import modelo.ClientesCuentas;
import modelo.Cuentas;
import modelo.NotificacionesRecibos;
import modelo.Operaciones;
import modelo.Prestamos;
import modelo.RecibosDomiciliarios;
import modelo.Tarjetas_De_Credito;
import modelo.Transferencias;
import modelo.Usuarios;

/**
 *
 * @author aiviz
 */
@Named
@ViewScoped
public class CuentaEController implements Serializable {

    private Cuentas cuenta;
    private List<Cuentas> cuentas;
    private Clientes cliente;
    private ClientesCuentas clienteCuenta;

    @EJB
    private CuentasFacadeLocal cuentaEJB;

    @EJB
    private ClientesFacadeLocal clie;

    @EJB
    private ClientesCuentasFacadeLocal clienteCuentaEJB;

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
        cuenta = new Cuentas();
        cliente = new Clientes();
        clienteCuenta = new ClientesCuentas();
        cliente = (Clientes) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("cliente");
        cuentas = new ArrayList<>();
        cuentas = clienteCuentaEJB.cuentasPorCliente(cliente);
    }

    public Cuentas getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuentas cuenta) {
        this.cuenta = cuenta;
    }

    public List<Cuentas> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuentas> cuentas) {
        this.cuentas = cuentas;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public CuentasFacadeLocal getCuentaEJB() {
        return cuentaEJB;
    }

    public void setCuentaEJB(CuentasFacadeLocal cuentaEJB) {
        this.cuentaEJB = cuentaEJB;
    }

    public ClientesCuentasFacadeLocal getClienteCuentaEJB() {
        return clienteCuentaEJB;
    }

    public void setClienteCuentaEJB(ClientesCuentasFacadeLocal clienteCuentaEJB) {
        this.clienteCuentaEJB = clienteCuentaEJB;
    }

    public ClientesCuentas getClienteCuenta() {
        return clienteCuenta;
    }

    public void setClienteCuenta(ClientesCuentas clienteCuenta) {
        this.clienteCuenta = clienteCuenta;
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
        result = prime * result + ((cuenta == null) ? 0 : cuenta.hashCode());
        result = prime * result + ((cuentas == null) ? 0 : cuentas.hashCode());
        result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
        result = prime * result + ((clienteCuenta == null) ? 0 : clienteCuenta.hashCode());
        result = prime * result + ((cuentaEJB == null) ? 0 : cuentaEJB.hashCode());
        result = prime * result + ((clie == null) ? 0 : clie.hashCode());
        result = prime * result + ((clienteCuentaEJB == null) ? 0 : clienteCuentaEJB.hashCode());
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
        CuentaEController other = (CuentaEController) obj;
        if (cuenta == null) {
            if (other.cuenta != null)
                return false;
        } else if (!cuenta.equals(other.cuenta))
            return false;
        if (cuentas == null) {
            if (other.cuentas != null)
                return false;
        } else if (!cuentas.equals(other.cuentas))
            return false;
        if (cliente == null) {
            if (other.cliente != null)
                return false;
        } else if (!cliente.equals(other.cliente))
            return false;
        if (clienteCuenta == null) {
            if (other.clienteCuenta != null)
                return false;
        } else if (!clienteCuenta.equals(other.clienteCuenta))
            return false;
        if (cuentaEJB == null) {
            if (other.cuentaEJB != null)
                return false;
        } else if (!cuentaEJB.equals(other.cuentaEJB))
            return false;
        if (clie == null) {
            if (other.clie != null)
                return false;
        } else if (!clie.equals(other.clie))
            return false;
        if (clienteCuentaEJB == null) {
            if (other.clienteCuentaEJB != null)
                return false;
        } else if (!clienteCuentaEJB.equals(other.clienteCuentaEJB))
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

    public void redirectUsuarios() {
        try {
            FacesContext.getCurrentInstance().getExternalContext()
                    .redirect("/TrabajoInso2/faces/privado/empleados/regUsuarios.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ClientesFacadeLocal getClie() {
        return clie;
    }

    public void setClie(ClientesFacadeLocal clie) {
        this.clie = clie;
    }

    public void eliminarCuenta() {
        try {
            borrarInfoCuenta();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "La cuenta se ha eliminado correctamente",
                            "La cuenta se ha eliminado correctamente"));
            cuentas = clienteCuentaEJB.cuentasPorCliente(cliente);
        } catch (Exception e) {
            System.out.println(e.toString());
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al eliminar la cuenta",
                            "Error al eliminar la cuenta"));
        }
    }

    public void borrarInfoCuenta() {
        List<Cuentas> cs = new ArrayList<>();
        cs.add(cuenta);
        List<Transferencias> transferencias = new ArrayList<>();
        List<RecibosDomiciliarios> recibos = new ArrayList<>();
        List<Operaciones> operaciones = new ArrayList<>();
        List<Tarjetas_De_Credito> tarjetas = new ArrayList<>();
        List<Prestamos> prestamos = new ArrayList<>();
        List<ClientesCuentas> clientesCuentas = new ArrayList<>();

        clientesCuentas = clienteCuentaEJB.findAll()
                .stream()
                .filter(cc -> cc.getCuentas().equals(cuenta))
                .collect(Collectors.toList());
        transferencias = transferenciasEJB.transferenciasPorCuenta(cs);
        operaciones = operacionesEJB.operacionesPorCuenta(cs);
        tarjetas = tarjetasEJB.encuentraTarejetaPorCuenta(cs);
        prestamos = prestamosEJB.prestamosPorCuenta(cs);
        recibos = recibosEJB.recibosPorCuenta(cs);

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
            clienteCuentaEJB.remove(cc);
        }

        cs.forEach((c) -> {
            cuentaEJB.remove(c);
        });
    }
}
