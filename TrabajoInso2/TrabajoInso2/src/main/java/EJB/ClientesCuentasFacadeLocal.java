/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import java.util.List;
import javax.ejb.Local;
import modelo.Clientes;
import modelo.ClientesCuentas;
import modelo.Cuentas;

/**
 *
 * @author aiviz
 */
@Local
public interface ClientesCuentasFacadeLocal {

    void create(ClientesCuentas clientesCuentas);

    void edit(ClientesCuentas clientesCuentas);

    void remove(ClientesCuentas clientesCuentas);

    ClientesCuentas find(Object id);

    List<ClientesCuentas> findAll();

    List<ClientesCuentas> findRange(int[] range);

    int count();

    public List<Cuentas> cuentasPorCliente(Clientes cliente);
    
}
