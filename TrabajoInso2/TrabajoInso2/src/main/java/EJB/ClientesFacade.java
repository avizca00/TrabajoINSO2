/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modelo.Clientes;

/**
 *
 * @author aiviz
 */
@Stateless
public class ClientesFacade extends AbstractFacade<Clientes> implements ClientesFacadeLocal {

    @PersistenceContext(unitName = "BancoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientesFacade() {
        super(Clientes.class);
    }

    @Override
    public Clientes encuentraPorIDUsuario(int id) {
        Query query = em.createQuery("SELECT c FROM Clientes c WHERE c.usuario.idusuario = :idUsuario");
        query.setParameter("idUsuario", id);
        try {
            return (Clientes) query.getSingleResult();
        } catch (NoResultException e) {
            return null; // Cliente no encontrado
        }
    }

}
