package pe.edu.upc.aaw.credicomprabackend.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aaw.credicomprabackend.dtos.PagoDTO;
import pe.edu.upc.aaw.credicomprabackend.entities.Pago;
import pe.edu.upc.aaw.credicomprabackend.serviceInterfaces.IPagoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pago")
public class PagoController {
    @Autowired
    private IPagoService iP;

    @PostMapping
    public void crear(@RequestBody PagoDTO pago) {
        ModelMapper m = new ModelMapper();
        Pago p = m.map(pago, Pago.class);
        iP.insert(p);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        iP.delete(id);
    }

    @GetMapping
    public List<PagoDTO> lista() {
        return iP.list().stream().map(x -> {
                    ModelMapper m = new ModelMapper();
                    return m.map(x, PagoDTO.class);
                }).collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public PagoDTO modificar(@PathVariable Long id) {
        ModelMapper m=new ModelMapper();
        PagoDTO p=m.map(iP.listarId(id),PagoDTO.class);
        return p;
    }
}
