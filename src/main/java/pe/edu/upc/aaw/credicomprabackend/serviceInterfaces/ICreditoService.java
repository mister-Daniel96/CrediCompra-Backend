package pe.edu.upc.aaw.credicomprabackend.serviceInterfaces;

import pe.edu.upc.aaw.credicomprabackend.entities.Credito;

import java.util.List;

public interface ICreditoService {
    public void insert(Credito credito);
    public void delete(Long idCredito);
    public List<Credito> list();
    public Credito listarId(Long idCredito);
}
