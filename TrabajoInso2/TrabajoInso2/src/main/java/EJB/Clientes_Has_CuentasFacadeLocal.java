/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import java.util.List;
import javax.ejb.Local;
import modelo.Clientes_Has_Cuentas;

/**
 *
 * @author aiviz
 */
@Local
public interface Clientes_Has_CuentasFacadeLocal {

    void create(Clientes_Has_Cuentas clientes_Has_Cuentas);

    void edit(Clientes_Has_Cuentas clientes_Has_Cuentas);

    void remove(Clientes_Has_Cuentas clientes_Has_Cuentas);

    Clientes_Has_Cuentas find(Object id);

    List<Clientes_Has_Cuentas> findAll();

    List<Clientes_Has_Cuentas> findRange(int[] range);

    int count();
    
}
