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
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/credito")
public class CreditoController {
    @Autowired
    private ICreditoService cS;
    @Autowired
    private PagoController PC;
    @GetMapping("/{id}")
    public CreditoDTO listarId(@PathVariable("id") Long id) {
        ModelMapper m = new ModelMapper();
        CreditoDTO d = m.map(cS.listarId(id), CreditoDTO.class);
        return d;
    }
    @PostMapping
    public void crear(@RequestBody CreditoDTO credito) {
        ModelMapper m = new ModelMapper();
        credito.setDateRecorded(LocalDate.now());
        //la fecha de vencimiento si sera ingresado por front
        Credito p = m.map(credito, Credito.class);
        Credito creditoGuardado = cS.insert(p);
        if (creditoGuardado.getAnnuities()) {
            generarPagosConAnualidad(creditoGuardado);
        } else {
            generarPagoSinAnualidad(creditoGuardado);
        }
        System.out.println(p);
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

    /* (i <= periododeGracia) {
           Double pagointeres = valorInicial * (nuevoMontoParaAnualidad / 100.0);
           nuevoMontoParaAnualidad += pagointeres;
           //AHORA SE CREAN ANUALIDADES EN BASE A ESTE MONTo

           // pago.setAmountPago(pagointeres);
       } else {
           // pago.setAmountPago(Anualidad);
       }*/
    void generarPagosConAnualidad(Credito credito) {

        Double Anualidad;
        long periodoDeGracia = credito.getGracePeriod();
        Double valorInicial = credito.getCurrentValue();
        Double tasaInteres = credito.getInterestRate() / 100;

        // Calcular la anualidad basada en el monto inicial y la duración total
       /* Anualidad = (valorInicial * tasaInteres) /
                (1 - Math.pow(1 + tasaInteres, -1 * (credito.getDuration() - periodoDeGracia)));

        System.out.println(Anualidad);*/
        Double nuevoMontoParaAnualidad = valorInicial;

        // Acumular intereses durante el período de gracia
        for (int i = 1; i <= periodoDeGracia; i++) {
            Double pagointeres = nuevoMontoParaAnualidad * tasaInteres;
            nuevoMontoParaAnualidad += pagointeres;
        }

        // Calcular la nueva anualidad basada en el nuevo monto ajustado después del período de gracia
        Anualidad = (nuevoMontoParaAnualidad * tasaInteres) /
                (1 - Math.pow(1 + tasaInteres, -1 * (credito.getDuration() - periodoDeGracia)));

        for (int i = 1; i <= credito.getDuration()-credito.getGracePeriod(); i++) {
            Pago pago = new Pago();

            pago.setAmountPago(Anualidad);
            pago.setDateRecorded(credito.getDateRecorded());
            LocalDate dateExpiration = credito.getDateRecorded().plusMonths(i + periodoDeGracia);
            pago.setDateExpiration(dateExpiration);
            pago.setEnablePago(true);
            pago.setCredito(credito);

            // INSERTAMOS EN LA BD
            ModelMapper m = new ModelMapper();
            PagoDTO d = m.map(pago, PagoDTO.class);
            PC.crear(d);
        }
    }

    //ES PARA UNA FECHA CUAL SEA ES DECIR CUALQUIER DIA ES ELEGIDO COMO PAGO
    void generarPagoSinAnualidad(Credito credito) {
        double VF = 0;
        LocalDate dateExpiration = credito.getDateExpiration();
        LocalDate dateRecorded = credito.getDateRecorded();
        long dias = ChronoUnit.DAYS.between(dateRecorded, dateExpiration);
        double tasaCredito = credito.getInterestRate() / 100;


        System.out.println(dias);
        double ted = (Math.pow((1 + tasaCredito), (1.0 / 30.0)) - 1);
        System.out.println(ted);

        //VF = credito.getCurrentValue() * Math.pow((1 + (credito.getInterestRate() / 100)), credito.getDuration());
        VF = credito.getCurrentValue() * Math.pow((1 + ted), dias);
        System.out.println("diasssssssssssssssss");

        System.out.println(VF);

        Pago pago = new Pago();
        pago.setAmountPago(VF);
        pago.setDateRecorded(credito.getDateRecorded());
        //LocalDate dateExpiration = credito.getDateRecorded().plusMonths(credito.getDuration());
        pago.setDateExpiration(dateExpiration);
        pago.setEnablePago(true);
        pago.setCredito(credito);

        //INSERTAMOS EN LA BD
        ModelMapper m = new ModelMapper();
        PagoDTO d = m.map(pago, PagoDTO.class);
        PC.crear(d);
    }
}