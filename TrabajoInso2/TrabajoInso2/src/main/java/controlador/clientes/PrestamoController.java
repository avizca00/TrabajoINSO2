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
    private Empleados empleado;
    private List<Empleados> empleados;
    private Clientes cliente;

    @EJB
    private PrestamosFacadeLocal prestamosEJB;

    @EJB
    private CuentasFacadeLocal cuentasEJB;

    @EJB
    private EmpleadosFacadeLocal empleadosEJB;

    @EJB
    private ClientesCuentasFacadeLocal clienteCuentaEJB;

    @PostConstruct
    public void init() {
        cuenta = new Cuentas();
        cliente = new Clientes();
        cliente = (Clientes) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("cliente");
        cuentas = new ArrayList<>();
        cuentas = clienteCuentaEJB.cuentasPorCliente(cliente);
        empleado = new Empleados();
        empleados = new ArrayList<>();
        empleados = empleadosEJB.findAll();
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

    public Empleados getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleados empleado) {
        this.empleado = empleado;
    }

    public List<Empleados> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleados> empleados) {
        this.empleados = empleados;
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

    public EmpleadosFacadeLocal getEmpleadosEJB() {
        return empleadosEJB;
    }

    public void setEmpleadosEJB(EmpleadosFacadeLocal empleadosEJB) {
        this.empleadosEJB = empleadosEJB;
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
        result = prime * result + ((cuenta == null) ? 0 : cuenta.hashCode());
        result = prime * result + ((prestamo == null) ? 0 : prestamo.hashCode());
        result = prime * result + ((prestamos == null) ? 0 : prestamos.hashCode());
        result = prime * result + ((cuentas == null) ? 0 : cuentas.hashCode());
        result = prime * result + ((empleado == null) ? 0 : empleado.hashCode());
        result = prime * result + ((empleados == null) ? 0 : empleados.hashCode());
        result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
        result = prime * result + ((prestamosEJB == null) ? 0 : prestamosEJB.hashCode());
        result = prime * result + ((cuentasEJB == null) ? 0 : cuentasEJB.hashCode());
        result = prime * result + ((empleadosEJB == null) ? 0 : empleadosEJB.hashCode());
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
        PrestamoController other = (PrestamoController) obj;
        if (cuenta == null) {
            if (other.cuenta != null) {
                return false;
            }
        } else if (!cuenta.equals(other.cuenta)) {
            return false;
        }
        if (prestamo == null) {
            if (other.prestamo != null) {
                return false;
            }
        } else if (!prestamo.equals(other.prestamo)) {
            return false;
        }
        if (prestamos == null) {
            if (other.prestamos != null) {
                return false;
            }
        } else if (!prestamos.equals(other.prestamos)) {
            return false;
        }
        if (cuentas == null) {
            if (other.cuentas != null) {
                return false;
            }
        } else if (!cuentas.equals(other.cuentas)) {
            return false;
        }
        if (empleado == null) {
            if (other.empleado != null) {
                return false;
            }
        } else if (!empleado.equals(other.empleado)) {
            return false;
        }
        if (empleados == null) {
            if (other.empleados != null) {
                return false;
            }
        } else if (!empleados.equals(other.empleados)) {
            return false;
        }
        if (cliente == null) {
            if (other.cliente != null) {
                return false;
            }
        } else if (!cliente.equals(other.cliente)) {
            return false;
        }
        if (prestamosEJB == null) {
            if (other.prestamosEJB != null) {
                return false;
            }
        } else if (!prestamosEJB.equals(other.prestamosEJB)) {
            return false;
        }
        if (cuentasEJB == null) {
            if (other.cuentasEJB != null) {
                return false;
            }
        } else if (!cuentasEJB.equals(other.cuentasEJB)) {
            return false;
        }
        if (empleadosEJB == null) {
            if (other.empleadosEJB != null) {
                return false;
            }
        } else if (!empleadosEJB.equals(other.empleadosEJB)) {
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

    public void crearPrestamo() {

        cuenta = cuentasEJB.find(cuenta.getIdcuenta());
        int monto = prestamo.getMontoPrestamo().compareTo(BigDecimal.ZERO);
        int interes = prestamo.getTasaInteres().compareTo(BigDecimal.ZERO);

        if (monto < 0 || monto == 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "El monto del préstamo no puede ser negativo", "El monto del préstamo no puede ser negativo"));
        } else if (interes < 0 || interes == 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "La tasa de interes no puede ser negativa", "La tasa de interes no puede ser negativa"));
        } else if (prestamo.getPlazoMeses() == 0 || prestamo.getPlazoMeses() < 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "El plazo de meses no puede ser negativo o igual a 0",
                    "El plazo de meses no puede ser negativo o igual a 0"));
        } else {
            try {
                
                eligeEmpleadoAleatorio();
                
                prestamo.setEmpleado(empleado);
                System.out.println("sdsaksdkfask");
                
                prestamo.setCuenta(cuenta);
                prestamo.setEstado(0);
                prestamo.setFechaInicio(new Date());
                System.out.println(prestamo.getEmpleado().getIdempleado() + "----" + empleado.getUsuario().getIdusuario());
                
                

                prestamosEJB.create(prestamo);
                /*cuenta.setSaldo(cuenta.getSaldo().add(prestamo.getMontoPrestamo()));
                cuentasEJB.edit(cuenta);
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "El préstamo se ha creado correctamente",
                                "El préstamo se ha creado correctamente"));
                prestamos = prestamosEJB.prestamosPorCuenta(cuentas);*/
                //System.out.println(empleado.getIdempleado() + "----" + empleado.getUsuario().getIdusuario());
                
            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al crear el préstaamo",
                                "Error al crear el préstamao"));
            }
        }
    }

    public void pagarPrestamo(Prestamos prestamo) {
        int monto = prestamo.getMontoPrestamo().compareTo(prestamo.getCuenta().getSaldo());
        if (monto > 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "El monto del préstamo no puede ser mayor al saldo de la cuenta. Saldo de la cuenta: "
                    + prestamo.getCuenta().getSaldo() + " Monto del prestamo: " + prestamo.getMontoPrestamo(),
                    "El monto del préstamo no puede ser mayor al saldo de la cuenta. Saldo de la cuenta: "
                    + prestamo.getCuenta().getSaldo() + " Monto del prestamo: " + prestamo.getMontoPrestamo()));
        } else {
            try {
                BigDecimal saldo = prestamo.getCuenta().getSaldo().subtract(prestamo.getMontoPrestamo());
                prestamo.getCuenta().setSaldo(saldo);
                cuentasEJB.edit(prestamo.getCuenta());

                prestamo.setEstado(1);
                prestamosEJB.edit(prestamo);
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "El préstamo se ha pagado correctamente",
                                "El préstamo se ha pagado correctamente"));
            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al pagar el prestamo",
                                "Error al pagar el prestamo"));
            }
        }
    }

    private void eligeEmpleadoAleatorio() {
        int aleatorio = (int) (Math.random() * empleados.size());
        empleado = empleados.get(aleatorio);
    }

}
