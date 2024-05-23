package pe.edu.upc.aaw.credicomprabackend.dtos;


import pe.edu.upc.aaw.credicomprabackend.entities.Usuario;

public class TypeUserDTO {

    private Long idTypeUser;
    private String typeTypeUser;

    private Usuario user;

    public Long getIdTypeUser() {
        return idTypeUser;
    }

    public void setIdTypeUser(Long idTypeUser) {
        this.idTypeUser = idTypeUser;
    }

    public String getTypeTypeUser() {
        return typeTypeUser;
    }

    public void setTypeTypeUser(String typeTypeUser) {
        this.typeTypeUser = typeTypeUser;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

}
