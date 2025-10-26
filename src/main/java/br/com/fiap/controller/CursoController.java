package br.com.fiap.controller;

import br.com.fiap.dto.CursoDTO;
import br.com.fiap.model.Curso;
import br.com.fiap.service.CursoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService service;

    @Operation(summary = "Cadastrar novo curso", responses = {
            @ApiResponse(responseCode = "200", description = "Curso cadastrado com sucesso")
    })
    @PostMapping
    public Curso salvar(@RequestBody Curso curso) {
        return service.salvar(curso);
    }

    @Operation(summary = "Listar todos os cursos", responses = {
            @ApiResponse(responseCode = "200", description = "Lista de cursos retornada com sucesso")
    })
    @GetMapping
    public List<CursoDTO> listar() {
        return service.listar();
    }

    @Operation(summary = "Buscar curso por ID", responses = {
            @ApiResponse(responseCode = "200", description = "Curso encontrado"),
            @ApiResponse(responseCode = "404", description = "Curso não encontrado")
    })
    @GetMapping("/{id}")
    public CursoDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @Operation(summary = "Excluir curso por ID", responses = {
            @ApiResponse(responseCode = "204", description = "Curso excluído com sucesso"),
            @ApiResponse(responseCode = "404", description = "Curso não encontrado")
    })
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}