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
import modelo.Transferencias;

/**
 *
 * @author aiviz
 */
@Stateless
public class TransferenciasFacade extends AbstractFacade<Transferencias> implements TransferenciasFacadeLocal {

    @PersistenceContext(unitName = "BancoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TransferenciasFacade() {
        super(Transferencias.class);
    }

    @Override
    public List<Transferencias> transferenciasPorCuenta(List<Cuentas> cuentas) {
        String jpql = "SELECT t FROM Transferencias t WHERE t.cuentaPagador IN :cuentas OR t.cuentaBeneficiario IN :cuentas";
        return em.createQuery(jpql, Transferencias.class)
                .setParameter("cuentas", cuentas)
                .getResultList();
    }
    
}
