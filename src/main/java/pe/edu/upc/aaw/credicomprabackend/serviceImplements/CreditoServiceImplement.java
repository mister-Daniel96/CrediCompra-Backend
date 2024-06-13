package pe.edu.upc.aaw.credicomprabackend.serviceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aaw.credicomprabackend.entities.Credito;
import pe.edu.upc.aaw.credicomprabackend.repositories.ICreditoRepository;
import pe.edu.upc.aaw.credicomprabackend.serviceInterfaces.ICreditoService;

import java.util.List;

@Service
public class CreditoServiceImplement implements ICreditoService {
    @Autowired
    private ICreditoRepository cR;
    @Override
    public Credito insert(Credito credito) {
        return cR.save(credito);
    }

    @Override
    public void delete(Long idCredito) {
        cR.deleteById(idCredito);
    }

    @Override
    public List<Credito> list() {
        return cR.findAll();
    }

    @Override
    public Credito listarId(Long idCredito) {
        return cR.findById(idCredito).orElse(new Credito());
    }
}
