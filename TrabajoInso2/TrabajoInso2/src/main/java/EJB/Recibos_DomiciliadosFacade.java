/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Recibos_Domiciliados;

/**
 *
 * @author aiviz
 */
@Stateless
public class Recibos_DomiciliadosFacade extends AbstractFacade<Recibos_Domiciliados> implements Recibos_DomiciliadosFacadeLocal {

    @PersistenceContext(unitName = "BancoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Recibos_DomiciliadosFacade() {
        super(Recibos_Domiciliados.class);
    }
    
}
