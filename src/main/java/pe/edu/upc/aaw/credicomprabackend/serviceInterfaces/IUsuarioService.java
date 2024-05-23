package pe.edu.upc.aaw.credicomprabackend.serviceInterfaces;


import pe.edu.upc.aaw.credicomprabackend.entities.Usuario;

import java.util.List;

public interface IUsuarioService {
    public void insert(Usuario usuario);
    public List<Usuario> list();
    public void delete(Long idUsuario);
    public Usuario listid(Long idUsuario);



    public List<String[]>UsersRolUser();

    public List<String[]>CantUsers();
    public List<String[]> UsersRolAdmin();
//PARA EL REGISTRAR
    public List<Usuario> findUsuarioByNameUsuario(String nameUsuario);

    public List<String[]> CantidadDeClientesActivos();

}
