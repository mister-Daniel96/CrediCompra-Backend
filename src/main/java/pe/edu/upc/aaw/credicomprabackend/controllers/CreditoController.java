package pe.edu.upc.aaw.credicomprabackend.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aaw.credicomprabackend.dtos.CreditoDTO;
import pe.edu.upc.aaw.credicomprabackend.entities.Credito;
import pe.edu.upc.aaw.credicomprabackend.serviceInterfaces.ICreditoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/credito")
public class CreditoController {
    @Autowired
    private ICreditoService cS;

    @PostMapping
    public void crear(@RequestBody CreditoDTO credito) {
        ModelMapper m = new ModelMapper();
        Credito p = m.map(credito, Credito.class);
        cS.insert(p);
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

    @PutMapping("/{id}")
    public CreditoDTO modificar(@PathVariable Long id) {
        ModelMapper m=new ModelMapper();
        CreditoDTO p=m.map(cS.listarId(id),CreditoDTO.class);
        return p;
    }
}
