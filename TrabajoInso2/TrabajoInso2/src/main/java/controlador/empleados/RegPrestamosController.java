/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.empleados;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.faces.view.facelets.FaceletContext;
import javax.inject.Named;

import EJB.CuentasFacadeLocal;
import EJB.PrestamosFacadeLocal;
import modelo.Cuentas;
import modelo.Prestamos;

/**
 *
 * @author aiviz
 */
@Named
@ViewScoped
public class RegPrestamosController implements Serializable {
    private Prestamos prestamo;
    private List<Prestamos> prestamos;

    @EJB
    private PrestamosFacadeLocal prestamosEJB;

    @EJB
    private CuentasFacadeLocal cuentasEJB;

    @PostConstruct
    public void init() {
        prestamo = new Prestamos();
        prestamos = new ArrayList<>();
        prestamos = prestamosEJB.findPrestamosPendientes();
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((prestamo == null) ? 0 : prestamo.hashCode());
        result = prime * result + ((prestamos == null) ? 0 : prestamos.hashCode());
        result = prime * result + ((prestamosEJB == null) ? 0 : prestamosEJB.hashCode());
        result = prime * result + ((cuentasEJB == null) ? 0 : cuentasEJB.hashCode());
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
        RegPrestamosController other = (RegPrestamosController) obj;
        if (prestamo == null) {
            if (other.prestamo != null)
                return false;
        } else if (!prestamo.equals(other.prestamo))
            return false;
        if (prestamos == null) {
            if (other.prestamos != null)
                return false;
        } else if (!prestamos.equals(other.prestamos))
            return false;
        if (prestamosEJB == null) {
            if (other.prestamosEJB != null)
                return false;
        } else if (!prestamosEJB.equals(other.prestamosEJB))
            return false;
        if (cuentasEJB == null) {
            if (other.cuentasEJB != null)
                return false;
        } else if (!cuentasEJB.equals(other.cuentasEJB))
            return false;
        return true;
    }

    public void aceptarDenegarPrestamo(Prestamos p, int estado) {
        try {
            setPrestamo(p);
            prestamo.setEstado(estado);
            if (estado == 2) {
                Cuentas cuenta = prestamo.getCuenta();
                cuenta.setSaldo(cuenta.getSaldo().add(prestamo.getMontoPrestamo()));
                cuentasEJB.edit(cuenta);

                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "El préstamo ha sido aceptado",
                                "El préstamo ha sido aceptado"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "El préstamo ha sido denegado",
                                "El préstamo ha sido denegado"));
            }
            prestamosEJB.edit(prestamo);
            prestamos = prestamosEJB.findPrestamosPendientes();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al aceptar/denegar el préstamo",
                            "Error al aceptar/denegar el préstamo"));
        }
    }

}
