/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import java.util.List;
import javax.ejb.Local;
import modelo.NotificacionesRecibos;
import modelo.RecibosDomiciliarios;

/**
 *
 * @author aiviz
 */
@Local
public interface NotificacionesRecibosFacadeLocal {

    void create(NotificacionesRecibos notificacionesRecibos);

    void edit(NotificacionesRecibos notificacionesRecibos);

    void remove(NotificacionesRecibos notificacionesRecibos);

    NotificacionesRecibos find(Object id);

    List<NotificacionesRecibos> findAll();

    List<NotificacionesRecibos> findRange(int[] range);

    int count();

    List<NotificacionesRecibos> notificacionesPorRecibo(RecibosDomiciliarios recibo);
    
}
