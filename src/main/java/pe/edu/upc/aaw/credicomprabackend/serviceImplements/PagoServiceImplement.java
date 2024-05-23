package pe.edu.upc.aaw.credicomprabackend.serviceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.aaw.credicomprabackend.entities.Pago;
import pe.edu.upc.aaw.credicomprabackend.repositories.IPagoRepository;
import pe.edu.upc.aaw.credicomprabackend.serviceInterfaces.IPagoService;

import java.util.List;

@Service
public class PagoServiceImplement implements IPagoService {

    @Autowired
    private IPagoRepository iR;

    @Override
    public void insert(Pago pago) {
        iR.save(pago);
    }

    @Override
    public void delete(Long idPago) {
        iR.deleteById(idPago);
    }

    @Override
    public List<Pago> list() {
        return iR.findAll();
    }

    @Override
    public Pago listarId(Long idPago) {
        return iR.findById(idPago).orElse(new Pago());
    }
}
