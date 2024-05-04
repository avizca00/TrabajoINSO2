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
import modelo.Usuarios;

/**
 *
 * @author aiviz
 */
@Stateless
public class UsuariosFacade extends AbstractFacade<Usuarios> implements UsuariosFacadeLocal {

    @PersistenceContext(unitName = "BancoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosFacade() {
        super(Usuarios.class);
    }

    @Override
    public boolean existeUsuarioPorUsername(String username) {
        Query q = em.createQuery("SELECT u FROM Usuarios u WHERE u.userName = :username");
        q.setParameter("username", username);
        List<Usuarios> usuarios = q.getResultList();
        return !usuarios.isEmpty();
    }

    @Override
    public boolean existeUsuarioPorDNI(String dni) {
        Query q = em.createQuery("SELECT u FROM Usuarios u WHERE u.dniUsuario = :dni");
        q.setParameter("dni", dni);
        List<Usuarios> usuarios = q.getResultList();
        return !usuarios.isEmpty();
    }

}
