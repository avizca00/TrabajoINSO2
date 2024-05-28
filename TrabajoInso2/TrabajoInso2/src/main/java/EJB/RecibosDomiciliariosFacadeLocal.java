/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import java.util.List;
import javax.ejb.Local;
import modelo.Cuentas;
import modelo.RecibosDomiciliarios;

/**
 *
 * @author aiviz
 */
@Local
public interface RecibosDomiciliariosFacadeLocal {

    void create(RecibosDomiciliarios recibosDomiciliarios);

    void edit(RecibosDomiciliarios recibosDomiciliarios);

    void remove(RecibosDomiciliarios recibosDomiciliarios);

    RecibosDomiciliarios find(Object id);

    List<RecibosDomiciliarios> findAll();

    List<RecibosDomiciliarios> findRange(int[] range);

    int count();

    public List<RecibosDomiciliarios> recibosPorCuenta(List<Cuentas> cuentas);
    
}
