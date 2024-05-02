/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Clientes_Has_Cuentas;

/**
 *
 * @author aiviz
 */
@Stateless
public class Clientes_Has_CuentasFacade extends AbstractFacade<Clientes_Has_Cuentas> implements Clientes_Has_CuentasFacadeLocal {

    @PersistenceContext(unitName = "BancoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Clientes_Has_CuentasFacade() {
        super(Clientes_Has_Cuentas.class);
    }
    
}
