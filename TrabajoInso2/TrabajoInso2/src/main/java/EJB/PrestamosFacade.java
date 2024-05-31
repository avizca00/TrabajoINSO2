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
import modelo.Prestamos;

/**
 *
 * @author aiviz
 */
@Stateless
public class PrestamosFacade extends AbstractFacade<Prestamos> implements PrestamosFacadeLocal {

    @PersistenceContext(unitName = "BancoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PrestamosFacade() {
        super(Prestamos.class);
    }

    @Override
    public List<Prestamos> prestamosPorCuenta(List<Cuentas> cuentas) {
        String jpql = "SELECT t FROM Prestamos t WHERE t.cuenta IN :cuentas";
        return em.createQuery(jpql, Prestamos.class)
                .setParameter("cuentas", cuentas)
                .getResultList();
    }

    @Override
    public List<Prestamos> findPrestamosPendientes() {
        String jpql = "SELECT t FROM Prestamos t WHERE t.estado = 0";
        return em.createQuery(jpql, Prestamos.class)
                .getResultList();
    }

}
