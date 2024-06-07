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

    @PutMapping
    public void modificar(@RequestBody CreditoDTO creditoDTO) {
        ModelMapper m = new ModelMapper();
        Credito a = m.map(creditoDTO, Credito.class);
        cS.insert(a);
    }
}