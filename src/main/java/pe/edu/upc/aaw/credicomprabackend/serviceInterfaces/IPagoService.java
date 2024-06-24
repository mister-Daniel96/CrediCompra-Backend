package pe.edu.upc.aaw.credicomprabackend.serviceInterfaces;

import pe.edu.upc.aaw.credicomprabackend.entities.Pago;

import java.util.List;

public interface IPagoService {

    public void insert(Pago pago);
    public void delete(Long idPago);
    public List<Pago> list();
    public Pago listarId(Long idPago);

}
