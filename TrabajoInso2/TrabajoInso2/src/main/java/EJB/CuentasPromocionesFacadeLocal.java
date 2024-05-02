/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import java.util.List;
import javax.ejb.Local;
import modelo.CuentasPromociones;

/**
 *
 * @author aiviz
 */
@Local
public interface CuentasPromocionesFacadeLocal {

    void create(CuentasPromociones cuentasPromociones);

    void edit(CuentasPromociones cuentasPromociones);

    void remove(CuentasPromociones cuentasPromociones);

    CuentasPromociones find(Object id);

    List<CuentasPromociones> findAll();

    List<CuentasPromociones> findRange(int[] range);

    int count();
    
}
