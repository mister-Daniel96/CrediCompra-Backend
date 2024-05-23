package pe.edu.upc.aaw.credicomprabackend.serviceImplements;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.edu.upc.aaw.credicomprabackend.entities.Usuario;
import pe.edu.upc.aaw.credicomprabackend.repositories.IUsuarioRepository;


import java.util.ArrayList;
import java.util.List;


//Clase 2
@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private IUsuarioRepository repo;

    /*@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //Aqui lógica para buscar el usuario en BD
        //Usuario defecto web:password

        if ("web".equals(username)) {
            return new User("web", "$2a$12$CTtjF8P3IJVK6pP4w9pTxuldMqQRrfrLbLLIlasdu2K6ii2vWGly2",
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("Usuario no encontrado: " + username);
        }
    }*/
    @Override
    public UserDetails loadUserByUsername(String nameUsuario) throws UsernameNotFoundException {
        Usuario user = repo.findByNameUsuario(nameUsuario);

        if(user == null) {
            throw new UsernameNotFoundException(String.format("User not exists", nameUsuario));
        }

        List<GrantedAuthority> roles = new ArrayList<>();

        user.getRoles().forEach(rol -> {
            roles.add(new SimpleGrantedAuthority(rol.getTypeTypeUser()));
        });
        //Solo si es enabled:true--> es considerado valido y nos genera el token en otro caso no
        UserDetails ud = new org.springframework.security.core.userdetails.User(user.getNameUsuario(), user.getPasswordUsuario(), user.getEnabledUsuario(), true, true, true, roles);

        return ud;
    }
}