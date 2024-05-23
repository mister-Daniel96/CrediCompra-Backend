package pe.edu.upc.aaw.credicomprabackend.serviceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aaw.credicomprabackend.entities.TypeUser;
import pe.edu.upc.aaw.credicomprabackend.repositories.ITypeUserRepository;
import pe.edu.upc.aaw.credicomprabackend.serviceInterfaces.ITypeUserService;


import java.util.List;

@Service
public class TypeUserServiceImplement implements ITypeUserService {

    @Autowired
    private ITypeUserRepository dR;

    @Override
    public void insert(TypeUser typeUser) {
        dR.save(typeUser);
    }

    @Override
    public List<TypeUser> list() {
        return dR.findAll();
    }

    @Override
    public void delete(Long idTypeUser) {
        dR.deleteById(idTypeUser);
    }

    @Override
    public TypeUser listId(Long idTypeUser) {
        return dR.findById(idTypeUser).orElse(new TypeUser());
    }
}
