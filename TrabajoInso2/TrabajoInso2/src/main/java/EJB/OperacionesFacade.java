/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Cuentas;
import modelo.Operaciones;

/**
 *
 * @author aiviz
 */
@Stateless
public class OperacionesFacade extends AbstractFacade<Operaciones> implements OperacionesFacadeLocal {

    @PersistenceContext(unitName = "BancoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OperacionesFacade() {
        super(Operaciones.class);
    }

    @Override
    public List<Operaciones> operacionesPorCuenta(List<Cuentas> cuentas) {
        String jpql = "SELECT p FROM Operaciones p WHERE p.cuenta IN :cuentas";
        return em.createQuery(jpql, Operaciones.class)
                .setParameter("cuentas", cuentas)
                .getResultList();
    }
    
}
