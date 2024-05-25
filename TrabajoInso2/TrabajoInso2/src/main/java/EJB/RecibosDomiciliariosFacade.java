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
import modelo.RecibosDomiciliarios;

/**
 *
 * @author aiviz
 */
@Stateless
public class RecibosDomiciliariosFacade extends AbstractFacade<RecibosDomiciliarios> implements RecibosDomiciliariosFacadeLocal {

    @PersistenceContext(unitName = "BancoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RecibosDomiciliariosFacade() {
        super(RecibosDomiciliarios.class);
    }

    @Override
    public List<RecibosDomiciliarios> recibosPorCuenta(List<Cuentas> cuentas) {
        String jpql = "SELECT r FROM RecibosDomiciliarios r WHERE r.cuenta IN :cuentas";
        return em.createQuery(jpql, RecibosDomiciliarios.class)
                .setParameter("cuentas", cuentas)
                .getResultList();
    }
    
}
