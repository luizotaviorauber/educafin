package br.com.fiap.controller;

import br.com.fiap.dto.MetaDTO;
import br.com.fiap.service.MetaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/metas")
public class MetaController {

    private final MetaService service;

    public MetaController(MetaService service) {
        this.service = service;
    }

    @GetMapping
    public List<MetaDTO> listar() {
        return service.findAll();
    }

    @PostMapping
    public MetaDTO cadastrar(@RequestBody MetaDTO dto) {
        return service.save(dto);
    }
}