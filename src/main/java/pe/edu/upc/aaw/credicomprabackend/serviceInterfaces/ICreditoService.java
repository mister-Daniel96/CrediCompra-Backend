package pe.edu.upc.aaw.credicomprabackend.serviceInterfaces;

import org.springframework.web.bind.annotation.PathVariable;
import pe.edu.upc.aaw.credicomprabackend.dtos.CreditoDTO;
import pe.edu.upc.aaw.credicomprabackend.entities.Credito;

import java.util.List;

public interface ICreditoService {
    public Credito insert(Credito credito);
    public void delete(Long idCredito);
    public List<Credito> list();
    public Credito listarId(Long idCredito);
}
