/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import java.util.List;
import javax.ejb.Local;
import modelo.Sucursales;

/**
 *
 * @author aiviz
 */
@Local
public interface SucursalesFacadeLocal {

    void create(Sucursales sucursales);

    void edit(Sucursales sucursales);

    void remove(Sucursales sucursales);

    Sucursales find(Object id);

    List<Sucursales> findAll();

    List<Sucursales> findRange(int[] range);

    int count();

    public boolean existeSucursalConNombre(String nombre);

    public boolean existeSucursalConDireccion(String ubicacion);

    public boolean existeSucursalConTelefono(String telefono);

    public boolean existeSucursalConCorreo(String correoElectronico);
    
}
