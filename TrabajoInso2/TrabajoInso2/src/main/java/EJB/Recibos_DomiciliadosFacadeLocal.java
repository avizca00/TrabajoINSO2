/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import java.util.List;
import javax.ejb.Local;
import modelo.Recibos_Domiciliados;

/**
 *
 * @author aiviz
 */
@Local
public interface Recibos_DomiciliadosFacadeLocal {

    void create(Recibos_Domiciliados recibos_Domiciliados);

    void edit(Recibos_Domiciliados recibos_Domiciliados);

    void remove(Recibos_Domiciliados recibos_Domiciliados);

    Recibos_Domiciliados find(Object id);

    List<Recibos_Domiciliados> findAll();

    List<Recibos_Domiciliados> findRange(int[] range);

    int count();
    
}
