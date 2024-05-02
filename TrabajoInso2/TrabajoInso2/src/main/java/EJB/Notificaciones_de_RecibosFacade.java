/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Notificaciones_de_Recibos;

/**
 *
 * @author aiviz
 */
@Stateless
public class Notificaciones_de_RecibosFacade extends AbstractFacade<Notificaciones_de_Recibos> implements Notificaciones_de_RecibosFacadeLocal {

    @PersistenceContext(unitName = "BancoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Notificaciones_de_RecibosFacade() {
        super(Notificaciones_de_Recibos.class);
    }
    
}
