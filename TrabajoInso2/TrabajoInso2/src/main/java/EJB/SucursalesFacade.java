/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Sucursales;

/**
 *
 * @author aiviz
 */
@Stateless
public class SucursalesFacade extends AbstractFacade<Sucursales> implements SucursalesFacadeLocal {

    @PersistenceContext(unitName = "BancoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SucursalesFacade() {
        super(Sucursales.class);
    }

    @Override
    public boolean existeSucursalConNombre(String nombre) {
        String jpql = "SELECT s FROM Sucursales s WHERE s.nombre = :nombre";
        return em.createQuery(jpql, Sucursales.class)
                .setParameter("nombre", nombre)
                .getResultList()
                .size() > 0;
    }

    @Override
    public boolean existeSucursalConDireccion(String ubicacion) {
        String jpql = "SELECT s FROM Sucursales s WHERE s.ubicacion = :ubicacion";
        return em.createQuery(jpql, Sucursales.class)
                .setParameter("ubicacion", ubicacion)
                .getResultList()
                .size() > 0;
    }

    @Override
    public boolean existeSucursalConTelefono(String telefono) {
        String jpql = "SELECT s FROM Sucursales s WHERE s.telefono = :telefono";
        return em.createQuery(jpql, Sucursales.class)
                .setParameter("telefono", telefono)
                .getResultList()
                .size() > 0;
    }

    @Override
    public boolean existeSucursalConCorreo(String correoElectronico) {
        String jpql = "SELECT s FROM Sucursales s WHERE s.correoElectronico = :correoElectronico";
        return em.createQuery(jpql, Sucursales.class)
                .setParameter("correoElectronico", correoElectronico)
                .getResultList()
                .size() > 0;
    }
    
}
