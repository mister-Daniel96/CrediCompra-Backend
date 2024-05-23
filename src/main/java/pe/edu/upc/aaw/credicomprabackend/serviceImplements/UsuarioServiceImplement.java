package pe.edu.upc.aaw.credicomprabackend.serviceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.edu.upc.aaw.credicomprabackend.entities.Usuario;
import pe.edu.upc.aaw.credicomprabackend.repositories.IUsuarioRepository;
import pe.edu.upc.aaw.credicomprabackend.serviceInterfaces.IUsuarioService;


import java.util.List;

@Service
public class UsuarioServiceImplement implements IUsuarioService {
    @Autowired
    private IUsuarioRepository dR;

    @Override
    public void insert(Usuario usuario) {
        dR.save(usuario);
    }

    @Override
    public List<Usuario> list() {
        return dR.findAll();
    }

    @Override
    public void delete(Long idUsuario) {
        if (dR.existsById(idUsuario)) {
            dR.deleteById(idUsuario);
        } else {
            throw new UsernameNotFoundException("User " + idUsuario + "no existe");
        }
    }

    @Override
    public Usuario listid(Long idUsuario) {
        return dR.findById(idUsuario).orElse(new Usuario());
    }

    @Override
    public List<String[]> UsersRolAdmin() {
        return dR.UsersRolAdmin();
    }

    @Override
    public List<String[]> UsersRolUser() {
        return dR.UsersRolUser();
    }

    @Override
    public List<String[]> CantUsers() {
        return dR.CantUsers();
    }

    @Override
    public List<Usuario> findUsuarioByNameUsuario(String nameUsuario) {
        return dR.findUsuarioByNameUsuario(nameUsuario);
    }

    @Override
    public List<String[]> CantidadDeClientesActivos() {
        return dR.CantidadDeClientesActivos();
    }

}
