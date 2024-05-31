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
import modelo.Tarjetas_De_Credito;

/**
 *
 * @author aiviz
 */
@Stateless
public class Tarjetas_De_CreditoFacade extends AbstractFacade<Tarjetas_De_Credito> implements Tarjetas_De_CreditoFacadeLocal {

    @PersistenceContext(unitName = "BancoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Tarjetas_De_CreditoFacade() {
        super(Tarjetas_De_Credito.class);
    }

    @Override
    public List<Tarjetas_De_Credito> encuentraTarejetaPorCuenta(List<Cuentas> cuentas) {
        String jpql = "SELECT t FROM Tarjetas_De_Credito t WHERE t.cuenta IN :cuentas";
        return em.createQuery(jpql, Tarjetas_De_Credito.class)
                .setParameter("cuentas", cuentas)
                .getResultList();
    }

}
