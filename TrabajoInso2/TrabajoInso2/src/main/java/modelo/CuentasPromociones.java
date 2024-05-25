package modelo;


import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cuentasPromociones")
public class CuentasPromociones implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCuentasPromociones;

    @ManyToOne
    @JoinColumn(name = "Promociones_idPromociones")
    private Promociones promociones;

    @ManyToOne
    @JoinColumn(name = "Cuentas_idCuenta")
    private Cuentas cuentas;

    public int getIdCuentasPromociones() {
        return idCuentasPromociones;
    }

    public void setIdCuentasPromociones(int idCuentasPromociones) {
        this.idCuentasPromociones = idCuentasPromociones;
    }

    public Promociones getPromociones() {
        return promociones;
    }

    public void setPromociones(Promociones promociones) {
        this.promociones = promociones;
    }

    public Cuentas getCuentas() {
        return cuentas;
    }

    public void setCuentas(Cuentas cuentas) {
        this.cuentas = cuentas;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.idCuentasPromociones;
        hash = 67 * hash + Objects.hashCode(this.promociones);
        hash = 67 * hash + Objects.hashCode(this.cuentas);
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
        final CuentasPromociones other = (CuentasPromociones) obj;
        if (this.idCuentasPromociones != other.idCuentasPromociones) {
            return false;
        }
        if (!Objects.equals(this.promociones, other.promociones)) {
            return false;
        }
        if (!Objects.equals(this.cuentas, other.cuentas)) {
            return false;
        }
        return true;
    }

    
}
