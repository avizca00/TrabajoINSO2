/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import java.util.List;
import javax.ejb.Local;
import modelo.Usuarios;

/**
 *
 * @author aiviz
 */
@Local
public interface UsuariosFacadeLocal {

    void create(Usuarios usuarios);

    void edit(Usuarios usuarios);

    void remove(Usuarios usuarios);

    Usuarios find(Object id);

    List<Usuarios> findAll();

    List<Usuarios> findRange(int[] range);

    int count();

    public Usuarios encuentraUsuarioPorUsernameAndPassword(String userName, String contrasenia);

    public boolean existeUsuarioPorDNI(String dniUsuario);

    public boolean existeUsuarioPorUsername(String userName);

    
}
