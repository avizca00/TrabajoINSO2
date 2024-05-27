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
import modelo.NotificacionesRecibos;
import modelo.RecibosDomiciliarios;

/**
 *
 * @author aiviz
 */
@Stateless
public class NotificacionesRecibosFacade extends AbstractFacade<NotificacionesRecibos> implements NotificacionesRecibosFacadeLocal {

    @PersistenceContext(unitName = "BancoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NotificacionesRecibosFacade() {
        super(NotificacionesRecibos.class);
    }

    @Override
    public List<NotificacionesRecibos> notificacionesPorRecibo(RecibosDomiciliarios recibo) {
        String jpql = "SELECT t FROM NotificacionesRecibos t WHERE t.reciboDomiciliario = :recibo";
        return em.createQuery(jpql, NotificacionesRecibos.class).setParameter("recibo", recibo)
                .getResultList();
    }

}
