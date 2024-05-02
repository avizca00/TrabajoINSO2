/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import java.util.List;
import javax.ejb.Local;
import modelo.Notificaciones_de_Recibos;

/**
 *
 * @author aiviz
 */
@Local
public interface Notificaciones_de_RecibosFacadeLocal {

    void create(Notificaciones_de_Recibos notificaciones_de_Recibos);

    void edit(Notificaciones_de_Recibos notificaciones_de_Recibos);

    void remove(Notificaciones_de_Recibos notificaciones_de_Recibos);

    Notificaciones_de_Recibos find(Object id);

    List<Notificaciones_de_Recibos> findAll();

    List<Notificaciones_de_Recibos> findRange(int[] range);

    int count();
    
}
