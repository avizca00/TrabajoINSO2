/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import java.util.List;
import javax.ejb.Local;

import modelo.Cuentas;
import modelo.Tarjetas_De_Credito;

/**
 *
 * @author aiviz
 */
@Local
public interface Tarjetas_De_CreditoFacadeLocal {

    void create(Tarjetas_De_Credito tarjetas_De_Credito);

    void edit(Tarjetas_De_Credito tarjetas_De_Credito);

    void remove(Tarjetas_De_Credito tarjetas_De_Credito);

    Tarjetas_De_Credito find(Object id);

    List<Tarjetas_De_Credito> findAll();

    List<Tarjetas_De_Credito> findRange(int[] range);

    int count();

    List<Tarjetas_De_Credito> encuentraTarejetaPorCuenta(List<Cuentas> cuentas);
    
}
