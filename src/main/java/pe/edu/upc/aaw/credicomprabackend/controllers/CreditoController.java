package pe.edu.upc.aaw.credicomprabackend.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aaw.credicomprabackend.dtos.CreditoDTO;
import pe.edu.upc.aaw.credicomprabackend.dtos.PagoDTO;
import pe.edu.upc.aaw.credicomprabackend.entities.Credito;
import pe.edu.upc.aaw.credicomprabackend.entities.Pago;
import pe.edu.upc.aaw.credicomprabackend.serviceInterfaces.ICreditoService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/credito")
public class CreditoController {
    @Autowired
    private ICreditoService cS;
    @Autowired
    private PagoController PC;

    @PostMapping
    public void crear(@RequestBody CreditoDTO credito) {
        ModelMapper m = new ModelMapper();
        Credito p = m.map(credito, Credito.class);
        Credito creditoGuardado = cS.insert(p);
        if (creditoGuardado.getAnnuities()) {
            generarPagosConAnualidad(creditoGuardado);
        } else {
            generarPagoSinAnualidad(creditoGuardado);
        }
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        cS.delete(id);
    }

    @GetMapping
    public List<CreditoDTO> lista() {
        return cS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, CreditoDTO.class);
        }).collect(Collectors.toList());
    }

    @PutMapping
    public void modificar(@RequestBody CreditoDTO creditoDTO) {
        ModelMapper m = new ModelMapper();
        Credito a = m.map(creditoDTO, Credito.class);
        cS.insert(a);
    }

    void generarPagosConAnualidad(Credito credito) {

        Double Anualidad;
        Anualidad = (credito.getCurrentValue() * credito.getInterestRate()/100) / (1 - Math.pow(1 + (credito.getInterestRate()/100), -1 * credito.getDuration()));

        System.out.println(Anualidad);

        for (int i = 1; i <= credito.getDuration(); i++) {
            Pago pago = new Pago();
            pago.setAmountPago(Anualidad);
            pago.setDateRecorded(credito.getDateRecorded());
            LocalDate dateExpiration = credito.getDateRecorded().plusMonths(i);
            pago.setDateExpiration(dateExpiration);
            pago.setEnablePago(true);
            pago.setCredito(credito);

            //INSERTAMOS EN LA BD
            ModelMapper m = new ModelMapper();
            PagoDTO d = m.map(pago, PagoDTO.class);
            PC.crear(d);
        }
    }

    void generarPagoSinAnualidad(Credito credito) {
        double VF = 0;
        VF = credito.getCurrentValue() * Math.pow((1 + (credito.getInterestRate()/100)), credito.getDuration());

        Pago pago = new Pago();
        pago.setAmountPago(VF);
        pago.setDateRecorded(credito.getDateRecorded());
        LocalDate dateExpiration = credito.getDateRecorded().plusMonths(credito.getDuration());
        pago.setDateExpiration(dateExpiration);
        pago.setEnablePago(true);
        pago.setCredito(credito);

        //INSERTAMOS EN LA BD
        ModelMapper m=new ModelMapper();
        PagoDTO d=m.map(pago,PagoDTO.class);
        PC.crear(d);
    }
}