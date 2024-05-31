/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.empleados;

import controlador.clientes.*;
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
import java.io.IOException;
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
public class PrestamoEController implements Serializable {

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
        if (!cuentas.isEmpty()) {
            prestamos = prestamosEJB.prestamosPorCuenta(cuentas);
        }
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

    public void redirectUsuarios() {
        try {
            FacesContext.getCurrentInstance().getExternalContext()
                    .redirect("/TrabajoInso2/faces/privado/empleados/regUsuarios.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
