/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.clientes;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import EJB.ClientesCuentasFacadeLocal;
import EJB.CuentasFacadeLocal;
import EJB.EmpleadosFacadeLocal;
import EJB.PrestamosFacadeLocal;
import modelo.Clientes;
import modelo.Cuentas;
import modelo.Empleados;
import modelo.Prestamos;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author aiviz
 */
@Named
@ViewScoped
public class PrestamoController implements Serializable {

    private Cuentas cuenta;
    private Prestamos prestamo;
    private List<Prestamos> prestamos;
    private List<Cuentas> cuentas;
    private Clientes cliente;

    @EJB
    private PrestamosFacadeLocal prestamosEJB;

    @EJB
    private CuentasFacadeLocal cuentasEJB;

    @EJB
    private ClientesCuentasFacadeLocal clienteCuentaEJB;

    @PostConstruct
    public void init() {
        cuenta = new Cuentas();
        cliente = new Clientes();
        cliente = (Clientes) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("cliente");
        cuentas = new ArrayList<>();
        cuentas = clienteCuentaEJB.cuentasPorCliente(cliente);
        prestamo = new Prestamos();
        prestamos = new ArrayList<>();
        prestamos = prestamosEJB.prestamosPorCuenta(cuentas);
    }

    public Cuentas getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuentas cuenta) {
        this.cuenta = cuenta;
    }

    public Prestamos getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamos prestamo) {
        this.prestamo = prestamo;
    }

    public List<Prestamos> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(List<Prestamos> prestamos) {
        this.prestamos = prestamos;
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

    public PrestamosFacadeLocal getPrestamosEJB() {
        return prestamosEJB;
    }

    public void setPrestamosEJB(PrestamosFacadeLocal prestamosEJB) {
        this.prestamosEJB = prestamosEJB;
    }

    public CuentasFacadeLocal getCuentasEJB() {
        return cuentasEJB;
    }

    public void setCuentasEJB(CuentasFacadeLocal cuentasEJB) {
        this.cuentasEJB = cuentasEJB;
    }

    public ClientesCuentasFacadeLocal getClienteCuentaEJB() {
        return clienteCuentaEJB;
    }

    public void setClienteCuentaEJB(ClientesCuentasFacadeLocal clienteCuentaEJB) {
        this.clienteCuentaEJB = clienteCuentaEJB;
    }

    public void crearPrestamo() {
        cuenta = cuentasEJB.find(cuenta.getIdcuenta());
        int monto = prestamo.getMontoPrestamo().compareTo(BigDecimal.ZERO);
        int interes = prestamo.getTasaInteres().compareTo(BigDecimal.ZERO);

        if (monto < 0 || monto == 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "El monto del préstamo no puede ser negativo", "El monto del préstamo no puede ser negativo"));
        } else if (interes < 0 || interes == 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "La tasa de interés no puede ser negativa", "La tasa de interés no puede ser negativa"));
        } else if (prestamo.getPlazoMeses() == 0 || prestamo.getPlazoMeses() < 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "El plazo de meses no puede ser negativo o igual a 0",
                    "El plazo de meses no puede ser negativo o igual a 0"));
        } else {
            try {
                prestamo.setCuenta(cuenta);
                prestamo.setEstado(0);
                prestamo.setFechaInicio(new Date());
                prestamosEJB.create(prestamo);
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "El préstamo se ha creado correctamente",
                                "El préstamo se ha creado correctamente"));
                prestamos = prestamosEJB.prestamosPorCuenta(cuentas);
            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al crear el préstamo: " + e.toString(),
                                "Error al crear el préstamo: " + e.toString()));
            }
        }
    }

    public void pagarPrestamo(Prestamos prestamo) {
        int monto = prestamo.getMontoPrestamo().compareTo(prestamo.getCuenta().getSaldo());
        if (monto > 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "El monto del préstamo no puede ser mayor al saldo de la cuenta. Saldo de la cuenta: "
                            + prestamo.getCuenta().getSaldo() + " Monto del prestamo: "
                            + prestamo.getMontoPrestamo(),
                    "El monto del préstamo no puede ser mayor al saldo de la cuenta. Saldo de la cuenta: "
                            + prestamo.getCuenta().getSaldo() + " Monto del prestamo: "
                            + prestamo.getMontoPrestamo()));
        } else {
            try {
                BigDecimal saldo = prestamo.getCuenta().getSaldo().subtract(prestamo.getMontoPrestamo().add(prestamo
                        .getMontoPrestamo().multiply(prestamo.getTasaInteres().divide(BigDecimal.valueOf(100)))));
                cuenta = prestamo.getCuenta();
                cuenta.setSaldo(saldo);
                cuentasEJB.edit(cuenta);

                prestamo.setEstado(1);
                prestamosEJB.edit(prestamo);
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "El préstamo se ha pagado correctamente",
                                "El préstamo se ha pagado correctamente"));
                prestamos = prestamosEJB.prestamosPorCuenta(cuentas);
            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al pagar el préstamo",
                                "Error al pagar el préstamo"));
            }
        }

    }

}