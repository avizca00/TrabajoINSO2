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
import modelo.Empleados;

/**
 *
 * @author aiviz
 */
@Stateless
public class EmpleadosFacade extends AbstractFacade<Empleados> implements EmpleadosFacadeLocal {

    @PersistenceContext(unitName = "BancoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmpleadosFacade() {
        super(Empleados.class);
    }

    @Override
    public Empleados encuentraPorIDUsuario(int idusuario) {
        Query query = em.createQuery("SELECT e FROM Empleados e WHERE e.usuario.idusuario = :idUsuario");
        query.setParameter("idUsuario", idusuario);
        try {
            return (Empleados) query.getSingleResult();
        } catch (NoResultException e) {
            return null; // Cliente no encontrado
        }
    }
    
}
