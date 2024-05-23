package pe.edu.upc.aaw.credicomprabackend.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aaw.credicomprabackend.dtos.UsuarioDTO;
import pe.edu.upc.aaw.credicomprabackend.entities.TypeUser;
import pe.edu.upc.aaw.credicomprabackend.entities.Usuario;
import pe.edu.upc.aaw.credicomprabackend.serviceInterfaces.ITypeUserService;
import pe.edu.upc.aaw.credicomprabackend.serviceInterfaces.IUsuarioService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private IUsuarioService dS;

    //ESTO ES PARA GENERAR ROLEA AUTOMATICOS
    @Autowired
    private ITypeUserService tS;

    @PostMapping
    public void registrar(@RequestBody UsuarioDTO dto) {
        ModelMapper m = new ModelMapper();
        Usuario d = m.map(dto, Usuario.class);
        dS.insert(d);
    }
    //ES PARA EL REGISTRAR SIN AUTENTICACION EN EL FRONT
    @PostMapping("/registerUser")
    public void registrarNuevo(@RequestBody UsuarioDTO dto) {
       /* ModelMapper m = new ModelMapper();
        Usuario d = m.map(dto, Usuario.class);
        dS.insert(d);
        TypeUser rol=new TypeUser();
        rol.setTypeTypeUser("user");
        rol.setUser(d);
        tS.insert(rol);*/

        ModelMapper m = new ModelMapper();
        Usuario usuario = m.map(dto, Usuario.class);

        // Insertar el usuario en la base de datos
        dS.insert(usuario);

        // Recargar el usuario desde la base de datos para obtener una instancia gestionada
        List<Usuario> usuarioGestionado = dS.findUsuarioByNameUsuario(usuario.getNameUsuario());

        // Crear y persistir el TypeUser asociado al usuario gestionado
        TypeUser rol = new TypeUser();
        rol.setTypeTypeUser("user");
        rol.setUser(usuarioGestionado.get(0));
        tS.insert(rol);
    }
    @GetMapping
    //@PreAuthorize("hasAuthority('user') or hasAuthority('admin')")
    public List<UsuarioDTO> listar() {
        return dS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, UsuarioDTO.class);
        }).collect(Collectors.toList());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        dS.delete(id);
        return ResponseEntity.ok("Usuario eliminado correctamente");
    }
    @GetMapping("/{id}")
    public UsuarioDTO listarId(@PathVariable("id") Long id) {
        ModelMapper m = new ModelMapper();
        UsuarioDTO d = m.map(dS.listid(id), UsuarioDTO.class);
        return d;
    }
    @PutMapping
    public ResponseEntity<String>modificar(@RequestBody UsuarioDTO dto)
    {
        Optional<Usuario> usuarioExistente = Optional.ofNullable(dS.listid(dto.getIdUsuario()));

        if(usuarioExistente.isPresent())
        {
            ModelMapper m =  new ModelMapper();
            m.map(dto,usuarioExistente.get());
            dS.insert(usuarioExistente.get());

            return ResponseEntity.ok("Usuario modificado correctamente");
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/usuariosroluser")
   // @PreAuthorize("hasAuthority('admin')")
    public List<UsuarioDTO> UsuariosRolUser(){
        List<String[]> lista = dS.UsersRolUser();
        List<UsuarioDTO> listaDTO = new ArrayList<>();
        for(String[] data:lista){
            UsuarioDTO dto = new UsuarioDTO();
            dto.setIdUsuario(Long.parseLong(data[0]));
            dto.setEmailUsuario(data[1]);
            dto.setEnabledUsuario(Boolean.parseBoolean(data[2]));
            dto.setNameUsuario(data[3]);
            dto.setPasswordUsuario(data[4]);
            listaDTO.add(dto);
        }
        return listaDTO;
    }
    @GetMapping("/usuariosroladmin")
    public List<UsuarioDTO> UsuariosRolAdmin(){
        List<String[]> lista = dS.UsersRolAdmin();
        List<UsuarioDTO> listaDTO = new ArrayList<>();
        for(String[] data:lista){
            UsuarioDTO dto = new UsuarioDTO();
            dto.setIdUsuario(Long.parseLong(data[0]));
            dto.setEmailUsuario(data[1]);
            dto.setEnabledUsuario(Boolean.parseBoolean(data[2]));
            dto.setNameUsuario(data[3]);
            dto.setPasswordUsuario(data[4]);
            listaDTO.add(dto);
        }
        return listaDTO;
    }
    /*
    @GetMapping("/cantusuarios")
   // @PreAuthorize("hasAuthority('admin')")
    public List<CantUserDTO> CantidadUsuarios(){
        List<String[]> lista = dS.CantUsers();
        List<CantUserDTO> listaDTO = new ArrayList<>();
        for(String[] data:lista){
            CantUserDTO dto = new CantUserDTO();
            dto.setCant(Long.parseLong(data[0]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }

    @GetMapping("/cantclientesactivos")
    // @PreAuthorize("hasAuthority('admin')")
    public List<CantidadDeClientesActivosDTO> CantidadDeClientesActivos(){
        List<String[]> lista = dS.CantidadDeClientesActivos();
        List<CantidadDeClientesActivosDTO> listaDTO = new ArrayList<>();
        for(String[] data:lista){
            CantidadDeClientesActivosDTO dto = new CantidadDeClientesActivosDTO();
            dto.setCantidad_usuarios_activos(Long.parseLong(data[0]));
            dto.setCantidad_usuarios_inactivos(Long.parseLong(data[1]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }
*/
}
