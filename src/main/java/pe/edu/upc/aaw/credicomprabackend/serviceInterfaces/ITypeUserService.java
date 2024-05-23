package pe.edu.upc.aaw.credicomprabackend.serviceInterfaces;

import pe.edu.upc.aaw.credicomprabackend.entities.TypeUser;

import java.util.List;

public interface ITypeUserService  {

    public void insert(TypeUser typeUser);
    public List<TypeUser>list();
    public void delete(Long idTypeUser);
    public TypeUser listId(Long idTypeUser);
}
