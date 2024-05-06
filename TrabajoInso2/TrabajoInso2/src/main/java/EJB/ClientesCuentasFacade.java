/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modelo.Clientes;
import modelo.ClientesCuentas;
import modelo.Cuentas;

/**
 *
 * @author aiviz
 */
@Stateless
public class ClientesCuentasFacade extends AbstractFacade<ClientesCuentas> implements ClientesCuentasFacadeLocal {

    @PersistenceContext(unitName = "BancoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientesCuentasFacade() {
        super(ClientesCuentas.class);
    }

    @Override
    public List<Cuentas> cuentasPorCliente(Clientes cliente) {
        List<Cuentas> cuentasCliente = new ArrayList<>();
        Query query = em.createQuery(
                "SELECT cc.cuentas FROM ClientesCuentas cc WHERE cc.clientes.idcliente = :cliente");
        query.setParameter("cliente", cliente.getId());

        // Ejecutar la consulta y obtener el resultado
        query.getResultList();
        
        System.out.println(query.getResultList().size());

        return query.getResultList();
    }

}
