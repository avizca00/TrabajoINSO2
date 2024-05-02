/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.NotificacionesRecibos;

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
    
}
