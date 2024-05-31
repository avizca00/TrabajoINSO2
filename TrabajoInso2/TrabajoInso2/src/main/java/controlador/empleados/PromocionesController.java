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
import javax.inject.Named;

import EJB.PromocionesFacadeLocal;
import modelo.Promociones;

/**
 *
 * @author aiviz
 */
@Named
@ViewScoped
public class PromocionesController implements Serializable {

    private List<Promociones> promociones;
    private Promociones promocion;
    private Promociones promocionMod;

    @EJB
    private PromocionesFacadeLocal promocionesEJB;

    @PostConstruct
    public void init() {
        promociones = new ArrayList<>();
        promociones = promocionesEJB.findAll();
        promocion = new Promociones();
    }

    public List<Promociones> getPromociones() {
        return promociones;
    }

    public void setPromociones(List<Promociones> promociones) {
        this.promociones = promociones;
    }

    public Promociones getPromocion() {
        return promocion;
    }

    public void setPromocion(Promociones promocion) {
        this.promocion = promocion;
    }

    public Promociones getPromocionMod() {
        return promocionMod;
    }

    public void setPromocionMod(Promociones promocionMod) {
        this.promocionMod = promocionMod;
    }

    public PromocionesFacadeLocal getPromocionesEJB() {
        return promocionesEJB;
    }

    public void setPromocionesEJB(PromocionesFacadeLocal promocionesEJB) {
        this.promocionesEJB = promocionesEJB;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((promociones == null) ? 0 : promociones.hashCode());
        result = prime * result + ((promocion == null) ? 0 : promocion.hashCode());
        result = prime * result + ((promocionMod == null) ? 0 : promocionMod.hashCode());
        result = prime * result + ((promocionesEJB == null) ? 0 : promocionesEJB.hashCode());
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
        PromocionesController other = (PromocionesController) obj;
        if (promociones == null) {
            if (other.promociones != null)
                return false;
        } else if (!promociones.equals(other.promociones))
            return false;
        if (promocion == null) {
            if (other.promocion != null)
                return false;
        } else if (!promocion.equals(other.promocion))
            return false;
        if (promocionMod == null) {
            if (other.promocionMod != null)
                return false;
        } else if (!promocionMod.equals(other.promocionMod))
            return false;
        if (promocionesEJB == null) {
            if (other.promocionesEJB != null)
                return false;
        } else if (!promocionesEJB.equals(other.promocionesEJB))
            return false;
        return true;
    }

    public void crearPromocion() {
        try {
            if (!compruebaFechas(promocion)) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                        javax.faces.application.FacesMessage.SEVERITY_ERROR,
                        "La fecha de inicio debe ser anterior a la fecha de fin",
                        "La fecha de inicio debe ser anterior a la fecha de fin"));
            } else {
                promocionesEJB.create(promocion);
            }
            promociones = promocionesEJB.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void eliminarPromocion() {
        try {
            promocionesEJB.remove(promocion);
            promociones = promocionesEJB.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void modificarPromocion() {
        try {
            if (compruebaFechas(promocionMod)) {
                promocionesEJB.edit(promocionMod);
            }
            promociones = promocionesEJB.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean compruebaFechas(Promociones promocion) {
        return promocion.getFechaInicio().before(promocion.getFechaFin());
    }
}
