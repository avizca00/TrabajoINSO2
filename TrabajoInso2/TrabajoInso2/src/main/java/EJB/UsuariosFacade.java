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
    public Usuarios encuentraUsuarioPorUsernameAndPassword(String userName, String contrasenia) {
        Query query = em.createQuery("SELECT u FROM Usuarios u WHERE u.userName = :username AND u.contrasenia = :password");
        query.setParameter("username", userName);
        query.setParameter("password", contrasenia);
        List<Usuarios> usuarios = query.getResultList();
        try {
            return usuarios.get(0);
        } catch (Exception e) {
            return null; // Usuario no encontrado
        }
    }

    @Override
    public boolean existeUsuarioPorDNI(String dniUsuario) {
        Query q = em.createQuery("SELECT u FROM Usuarios u WHERE u.dniUsuario = :dni");
        q.setParameter("dni", dniUsuario);
        List<Usuarios> usuarios = q.getResultList();
        return !usuarios.isEmpty();
    }

    @Override
    public boolean existeUsuarioPorUsername(String userName) {
        Query q = em.createQuery("SELECT u FROM Usuarios u WHERE u.userName = :username");
        q.setParameter("username", userName);
        List<Usuarios> usuarios = q.getResultList();
        return !usuarios.isEmpty();
    }
    
}
