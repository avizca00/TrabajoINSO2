/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author aiviz
 */
public class Cuentas_Has_Promociones {
    @ManyToOne
    @JoinColumn(name = "Cuentas_idCuenta")
    private Cuentas cuenta;

    @ManyToOne
    @JoinColumn(name = "Promociones_idPromociones")
    private Promociones promocion;

    public Cuentas getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuentas cuenta) {
        this.cuenta = cuenta;
    }

    public Promociones getPromocion() {
        return promocion;
    }

    public void setPromocion(Promociones promocion) {
        this.promocion = promocion;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cuenta == null) ? 0 : cuenta.hashCode());
        result = prime * result + ((promocion == null) ? 0 : promocion.hashCode());
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
        Cuentas_Has_Promociones other = (Cuentas_Has_Promociones) obj;
        if (cuenta == null) {
            if (other.cuenta != null)
                return false;
        } else if (!cuenta.equals(other.cuenta))
            return false;
        if (promocion == null) {
            if (other.promocion != null)
                return false;
        } else if (!promocion.equals(other.promocion))
            return false;
        return true;
    }

    
}
