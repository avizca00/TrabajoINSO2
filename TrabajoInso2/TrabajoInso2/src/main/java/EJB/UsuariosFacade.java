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
    public Usuarios findUsuarioByUsernameAndPassword(String username, String contrasenia) {
        Query query = em.createQuery("SELECT u FROM Usuarios u WHERE u.username = :username AND u.contrasenia = :contrasenia");
        query.setParameter("username", username);
        query.setParameter("contrasenia", contrasenia);
        List<Usuarios> result = query.getResultList();
        if (!result.isEmpty()) {
            return result.get(0); // Devuelve el primer usuario encontrado
        } else {
            return null; // No se encontró ningún usuario con esas credenciales
        }
    }
    
}
