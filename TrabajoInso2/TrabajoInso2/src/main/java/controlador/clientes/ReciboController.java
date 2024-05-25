/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.clientes;

import EJB.ClientesCuentasFacadeLocal;
import EJB.CuentasFacadeLocal;
import EJB.NotificacionesRecibosFacadeLocal;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import EJB.RecibosDomiciliariosFacadeLocal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelo.Clientes;
import modelo.Cuentas;
import modelo.NotificacionesRecibos;
import modelo.RecibosDomiciliarios;

/**
 *
 * @author aiviz
 */
@Named
@ViewScoped
public class ReciboController implements Serializable {

    private RecibosDomiciliarios recibo;
    private List<RecibosDomiciliarios> recibos;
    private Clientes cliente;
    private List<Cuentas> cuentas;
    private Cuentas cuenta;
    private NotificacionesRecibos notificacion;
    private List<NotificacionesRecibos> notificaciones;

    @EJB
    private RecibosDomiciliariosFacadeLocal reciboEJB;

    @EJB
    private CuentasFacadeLocal cuentaEJB;

    @EJB
    private ClientesCuentasFacadeLocal clienteCuentaEJB;

    @EJB
    private NotificacionesRecibosFacadeLocal notificacionEJB;

    @PostConstruct
    public void init() {
        cuenta = new Cuentas();
        cliente = new Clientes();
        cliente = (Clientes) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("cliente");
        cuentas = new ArrayList<>();
        cuentas = clienteCuentaEJB.cuentasPorCliente(cliente);
        recibos = new ArrayList<>();
        recibo = new RecibosDomiciliarios();
        recibos = reciboEJB.recibosPorCuenta(cuentas);
        notificacion = new NotificacionesRecibos();
        notificaciones = new ArrayList<>();
    }

    public RecibosDomiciliarios getRecibo() {
        return recibo;
    }

    public void setRecibo(RecibosDomiciliarios recibo) {
        this.recibo = recibo;
    }

    public List<RecibosDomiciliarios> getRecibos() {
        return recibos;
    }

    public void setRecibos(List<RecibosDomiciliarios> recibos) {
        this.recibos = recibos;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public List<Cuentas> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuentas> cuentas) {
        this.cuentas = cuentas;
    }

    public Cuentas getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuentas cuenta) {
        this.cuenta = cuenta;
    }

    public RecibosDomiciliariosFacadeLocal getReciboEJB() {
        return reciboEJB;
    }

    public void setReciboEJB(RecibosDomiciliariosFacadeLocal reciboEJB) {
        this.reciboEJB = reciboEJB;
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

    public NotificacionesRecibos getNotificacion() {
        return notificacion;
    }

    public void setNotificacion(NotificacionesRecibos notificacion) {
        this.notificacion = notificacion;
    }

    public List<NotificacionesRecibos> getNotificaciones() {
        return notificaciones;
    }

    public void setNotificaciones(List<NotificacionesRecibos> notificaciones) {
        this.notificaciones = notificaciones;
    }

    public NotificacionesRecibosFacadeLocal getNotificacionEJB() {
        return notificacionEJB;
    }

    public void setNotificacionEJB(NotificacionesRecibosFacadeLocal notificacionEJB) {
        this.notificacionEJB = notificacionEJB;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((recibo == null) ? 0 : recibo.hashCode());
        result = prime * result + ((recibos == null) ? 0 : recibos.hashCode());
        result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
        result = prime * result + ((cuentas == null) ? 0 : cuentas.hashCode());
        result = prime * result + ((cuenta == null) ? 0 : cuenta.hashCode());
        result = prime * result + ((notificacion == null) ? 0 : notificacion.hashCode());
        result = prime * result + ((notificaciones == null) ? 0 : notificaciones.hashCode());
        result = prime * result + ((reciboEJB == null) ? 0 : reciboEJB.hashCode());
        result = prime * result + ((cuentaEJB == null) ? 0 : cuentaEJB.hashCode());
        result = prime * result + ((clienteCuentaEJB == null) ? 0 : clienteCuentaEJB.hashCode());
        result = prime * result + ((notificacionEJB == null) ? 0 : notificacionEJB.hashCode());
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
        ReciboController other = (ReciboController) obj;
        if (recibo == null) {
            if (other.recibo != null) {
                return false;
            }
        } else if (!recibo.equals(other.recibo)) {
            return false;
        }
        if (recibos == null) {
            if (other.recibos != null) {
                return false;
            }
        } else if (!recibos.equals(other.recibos)) {
            return false;
        }
        if (cliente == null) {
            if (other.cliente != null) {
                return false;
            }
        } else if (!cliente.equals(other.cliente)) {
            return false;
        }
        if (cuentas == null) {
            if (other.cuentas != null) {
                return false;
            }
        } else if (!cuentas.equals(other.cuentas)) {
            return false;
        }
        if (cuenta == null) {
            if (other.cuenta != null) {
                return false;
            }
        } else if (!cuenta.equals(other.cuenta)) {
            return false;
        }
        if (notificacion == null) {
            if (other.notificacion != null) {
                return false;
            }
        } else if (!notificacion.equals(other.notificacion)) {
            return false;
        }
        if (notificaciones == null) {
            if (other.notificaciones != null) {
                return false;
            }
        } else if (!notificaciones.equals(other.notificaciones)) {
            return false;
        }
        if (reciboEJB == null) {
            if (other.reciboEJB != null) {
                return false;
            }
        } else if (!reciboEJB.equals(other.reciboEJB)) {
            return false;
        }
        if (cuentaEJB == null) {
            if (other.cuentaEJB != null) {
                return false;
            }
        } else if (!cuentaEJB.equals(other.cuentaEJB)) {
            return false;
        }
        if (clienteCuentaEJB == null) {
            if (other.clienteCuentaEJB != null) {
                return false;
            }
        } else if (!clienteCuentaEJB.equals(other.clienteCuentaEJB)) {
            return false;
        }
        if (notificacionEJB == null) {
            if (other.notificacionEJB != null) {
                return false;
            }
        } else if (!notificacionEJB.equals(other.notificacionEJB)) {
            return false;
        }
        return true;
    }

    public void creaRecibo() {

        int a = recibo.getImporte().compareTo(BigDecimal.ZERO);
        cuenta = cuentaEJB.find(cuenta.getIdcuenta());

        if (a == -1 || a == 0) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "El importe del recibo no puede ser 0 o negativo. Introduzca un importe válido",
                            "El importe del recibo no puede ser 0 o negativo. Introduzca un importe válido"));
        } else if (recibo.getFechaVencimiento() == null) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "La fecha de emisión del recibo no puede estar vacía. Introduzca una fecha válida",
                            "La fecha de emisión del recibo no puede estar vacía. Introduzca una fecha válida"));
        } else if (recibo.getFechaVencimiento().before(new Date())) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "La fecha de emisión del recibo no puede ser anterior a la fecha actual. Introduzca una fecha válida",
                            "La fecha de emisión del recibo no puede ser anterior a la fecha actual. Introduzca una fecha válida"));
        } else if (cuenta == null) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "No se ha seleccionado una cuenta. Seleccione una cuenta",
                            "No se ha seleccionado una cuenta. Seleccione una cuenta"));
        } else if (notificacion.getDescripcion() == null) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "No se ha introducido una descripción. Introduzca una descripción",
                            "No se ha introducido una descripción. Introduzca una descripción"));
        } else {
            try {
                recibo.setCuenta(cuenta);
                Date fechDate = new Date();
                recibo.setFechaEmision(fechDate);

                reciboEJB.create(recibo);
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO,
                                "Recibo creado con éxito",
                                "Recibo creado con éxito"));
                try {
                    notificacion.setPagoRealizado(1);
                    notificacion.setReciboDomiciliario(recibo);
                    notificacionEJB.create(notificacion);
                } catch (Exception e) {
                    FacesContext.getCurrentInstance().addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                    "Error al crear la notificación",
                                    "Error al crear la notificación"));
                }
            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                "Error al obtener las notificaciones",
                                "Error al obtener las notificaciones"));
            }
        }
    }

}
