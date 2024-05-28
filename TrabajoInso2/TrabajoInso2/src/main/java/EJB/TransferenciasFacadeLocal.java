/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import java.util.List;
import javax.ejb.Local;
import modelo.Cuentas;
import modelo.Transferencias;

/**
 *
 * @author aiviz
 */
@Local
public interface TransferenciasFacadeLocal {

    void create(Transferencias transferencias);

    void edit(Transferencias transferencias);

    void remove(Transferencias transferencias);

    Transferencias find(Object id);

    List<Transferencias> findAll();

    List<Transferencias> findRange(int[] range);

    int count();

    public List<Transferencias> transferenciasPorCuenta(List<Cuentas> cuentas);
    
}
