package pe.edu.upc.aaw.credicomprabackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.aaw.credicomprabackend.entities.Usuario;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

    public Usuario findByNameUsuario(String nameUsuario);

    @Query("select count(u.nameUsuario) from Usuario u where u.nameUsuario =:nameUsuario")
    public int buscarUserName(@Param("nameUsuario") String nombre);


    @Transactional
    @Modifying
    @Query(value = "insert into roles (typeTypeUser, idTypeUser) VALUES (:typeTypeUser, :idTypeUser)", nativeQuery = true)
    public void insRol(@Param("typeTypeUser") String authority, @Param("idTypeUser") Long idTypeUser);

//================================================================================
    @Query(value = "SELECT u.*\n" +
            " FROM usuario u INNER JOIN type_users t\n" +
            " ON u.id_usuario = t.id_usuario\n" +
            " WHERE t.type_type_user = 'user'", nativeQuery = true)
    public List<String[]> UsersRolUser();
    @Query(value = "SELECT u.*\n" +
            " FROM usuario u INNER JOIN type_users t\n" +
            " ON u.id_usuario = t.id_usuario\n" +
            " WHERE t.type_type_user = 'admin'", nativeQuery = true)
    public List<String[]> UsersRolAdmin();
    @Query(value = "SELECT COUNT(id_usuario) FROM usuario \n", nativeQuery = true)
    public List<String[]> CantUsers();


    //================================================================
    @Query(value = "SELECT COUNT(*) FILTER(WHERE u.enabled_usuario = true) AS cantidad_usuarios_activos,\n" +
            "COUNT(*) FILTER(WHERE u.enabled_usuario = false) AS cantidad_usuarios_inactivos\n" +
            "FROM usuario u JOIN type_users tu ON u.id_usuario = tu.id_usuario\n" +
            "WHERE tu.Type_type_user = 'user'", nativeQuery = true)
    public List<String[]> CantidadDeClientesActivos();
    //PARA EL REGISTRAR

    public List<Usuario> findUsuarioByNameUsuario(String nameUsuario);

}
