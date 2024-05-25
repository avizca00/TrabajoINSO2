/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.clientes;

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
import EJB.ClientesCuentasFacadeLocal;
import EJB.CuentasFacadeLocal;
import EJB.TransferenciasFacadeLocal;
import java.math.BigDecimal;
import java.sql.Timestamp;
import modelo.Clientes;
import modelo.ClientesCuentas;
import modelo.Cuentas;
import modelo.Transferencias;

/**
 *
 * @author aiviz
 */
@Named
@ViewScoped
public class TransferenciaController implements Serializable {

    private Transferencias transferencia;
    private List<Transferencias> transferencias;
    private Clientes cliente;
    private ClientesCuentas clienteCuenta;
    private List<Cuentas> cuentas;
    private Cuentas cuentaOrigen;
    private Cuentas cuentaDestino;

    @EJB
    private TransferenciasFacadeLocal transferenciaEJB;

    @EJB
    private CuentasFacadeLocal cuentaEJB;

    @EJB
    private ClientesCuentasFacadeLocal clienteCuentaEJB;

    @PostConstruct
    public void init() {
        cuentaOrigen = new Cuentas();
        cuentaDestino = new Cuentas();
        cliente = new Clientes();
        clienteCuenta = new ClientesCuentas();
        cliente = (Clientes) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("cliente");
        cuentas = new ArrayList<>();
        cuentas = clienteCuentaEJB.cuentasPorCliente(cliente);
        transferencia = new Transferencias();
        transferencias = new ArrayList<>();
        transferencias = transferenciaEJB.transferenciasPorCuenta(cuentas);
    }

    public Transferencias getTransferencia() {
        return transferencia;
    }

    public void setTransferencia(Transferencias transferencia) {
        this.transferencia = transferencia;
    }

    public List<Transferencias> getTransferencias() {
        return transferencias;
    }

    public void setTransferencias(List<Transferencias> transferencias) {
        this.transferencias = transferencias;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public ClientesCuentas getClienteCuenta() {
        return clienteCuenta;
    }

    public void setClienteCuenta(ClientesCuentas clienteCuenta) {
        this.clienteCuenta = clienteCuenta;
    }

    public List<Cuentas> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuentas> cuentas) {
        this.cuentas = cuentas;
    }

    public Cuentas getCuentaOrigen() {
        return cuentaOrigen;
    }

    public void setCuentaOrigen(Cuentas cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }

    public Cuentas getCuentaDestino() {
        return cuentaDestino;
    }

    public void setCuentaDestino(Cuentas cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }

    public TransferenciasFacadeLocal getTransferenciaEJB() {
        return transferenciaEJB;
    }

    public void setTransferenciaEJB(TransferenciasFacadeLocal transferenciaEJB) {
        this.transferenciaEJB = transferenciaEJB;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((transferencia == null) ? 0 : transferencia.hashCode());
        result = prime * result + ((transferencias == null) ? 0 : transferencias.hashCode());
        result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
        result = prime * result + ((clienteCuenta == null) ? 0 : clienteCuenta.hashCode());
        result = prime * result + ((cuentas == null) ? 0 : cuentas.hashCode());
        result = prime * result + ((cuentaOrigen == null) ? 0 : cuentaOrigen.hashCode());
        result = prime * result + ((cuentaDestino == null) ? 0 : cuentaDestino.hashCode());
        result = prime * result + ((transferenciaEJB == null) ? 0 : transferenciaEJB.hashCode());
        result = prime * result + ((cuentaEJB == null) ? 0 : cuentaEJB.hashCode());
        result = prime * result + ((clienteCuentaEJB == null) ? 0 : clienteCuentaEJB.hashCode());
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
        TransferenciaController other = (TransferenciaController) obj;
        if (transferencia == null) {
            if (other.transferencia != null) {
                return false;
            }
        } else if (!transferencia.equals(other.transferencia)) {
            return false;
        }
        if (transferencias == null) {
            if (other.transferencias != null) {
                return false;
            }
        } else if (!transferencias.equals(other.transferencias)) {
            return false;
        }
        if (cliente == null) {
            if (other.cliente != null) {
                return false;
            }
        } else if (!cliente.equals(other.cliente)) {
            return false;
        }
        if (clienteCuenta == null) {
            if (other.clienteCuenta != null) {
                return false;
            }
        } else if (!clienteCuenta.equals(other.clienteCuenta)) {
            return false;
        }
        if (cuentas == null) {
            if (other.cuentas != null) {
                return false;
            }
        } else if (!cuentas.equals(other.cuentas)) {
            return false;
        }
        if (cuentaOrigen == null) {
            if (other.cuentaOrigen != null) {
                return false;
            }
        } else if (!cuentaOrigen.equals(other.cuentaOrigen)) {
            return false;
        }
        if (cuentaDestino == null) {
            if (other.cuentaDestino != null) {
                return false;
            }
        } else if (!cuentaDestino.equals(other.cuentaDestino)) {
            return false;
        }
        if (transferenciaEJB == null) {
            if (other.transferenciaEJB != null) {
                return false;
            }
        } else if (!transferenciaEJB.equals(other.transferenciaEJB)) {
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
        return true;
    }

    public void realizarTransferencia() {
        cuentaOrigen = cuentaEJB.find(cuentaOrigen.getIdcuenta());
        cuentaDestino = cuentaEJB.encuentraCuentaPorIBAN(cuentaDestino.getIBAN());

        if (cuentaDestino == null) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "No existe ninguna cuenta beneficiaria con el IBAN introducido. Pruebe otra vez",
                            "No existe ninguna cuenta beneficiaria con el IBAN introducido. Pruebe otra vez"));
        } else if (cuentaOrigen.getSaldo().compareTo(transferencia.getMonto()) == -1) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "El importe de la transferencia es superior al saldo de su cuenta. Saldo actual: "
                                    + cuentaOrigen.getSaldo() + "€",
                            "El importe de la transferencia es superior al saldo de su cuenta. Saldo actual: "
                                    + cuentaOrigen.getSaldo() + "€"));
        } else if (cuentaOrigen.getIBAN().equals(cuentaDestino.getIBAN())) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "No puede realizar una transferencia a la misma cuenta",
                            "No puede realizar una transferencia a la misma cuenta"));
        } else if (transferencia.getMonto().compareTo(new BigDecimal(0)) == 0) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "El importe de la transferencia no puede ser 0",
                            "El importe de la transferencia no puede ser 0"));
        } else if (transferencia.getMonto().compareTo(new BigDecimal(0)) == -1) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "El importe de la transferencia no puede ser negativo",
                            "El importe de la transferencia no puede ser negativo"));
        } else if (cuentaOrigen.getLimiteTransaccion().compareTo(transferencia.getMonto()) == -1) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "El importe de la transferencia supera el límite de transacción de su cuenta. Límite actual: "
                                    + cuentaOrigen.getLimiteTransaccion() + "€",
                            "El importe de la transferencia supera el límite de transacción de su cuenta. Límite actual: "
                                    + cuentaOrigen.getLimiteTransaccion() + "€"));
        } else {
            cuentaOrigen.setSaldo(cuentaOrigen.getSaldo().subtract(transferencia.getMonto()));
            cuentaDestino.setSaldo(cuentaDestino.getSaldo().add(transferencia.getMonto()));

            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            cuentaOrigen.setFechaUltimaTransaccion(timestamp);
            cuentaDestino.setFechaUltimaTransaccion(timestamp);

            Date date = new Date();
            transferencia.setFecha(date);

            cuentaEJB.edit(cuentaOrigen);
            cuentaEJB.edit(cuentaDestino);
            transferencia.setCuentaPagador(cuentaOrigen);
            transferencia.setCuentaBeneficiario(cuentaDestino);
            transferenciaEJB.create(transferencia);
            transferencias = transferenciaEJB.transferenciasPorCuenta(cuentas);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Transferencia realizada con éxito",
                            "Transferencia realizada con éxito"));
        }
    }
}
