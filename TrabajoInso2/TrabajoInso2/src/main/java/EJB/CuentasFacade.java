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
import javax.persistence.Query;
import modelo.Cuentas;

/**
 *
 * @author aiviz
 */
@Stateless
public class CuentasFacade extends AbstractFacade<Cuentas> implements CuentasFacadeLocal {

    @PersistenceContext(unitName = "BancoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CuentasFacade() {
        super(Cuentas.class);
    }

    @Override
    public Cuentas encuentraCuentaPorIBAN(String iban) {
        Query query = em.createQuery("SELECT u FROM Cuentas u WHERE u.IBAN = :iban");
        query.setParameter("iban", iban);
        List<Cuentas> cuentas = query.getResultList();
        try {
            return cuentas.get(0);
        } catch (Exception e) {
            return null;
        }
    }
    
}
