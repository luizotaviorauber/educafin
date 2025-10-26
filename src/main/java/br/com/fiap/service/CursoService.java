package br.com.fiap.service;

import br.com.fiap.dto.CursoDTO;
import br.com.fiap.model.Curso;
import br.com.fiap.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CursoService {

    @Autowired
    private CursoRepository repository;

    public Curso salvar(Curso curso) {
        return repository.save(curso);
    }

    public List<CursoDTO> listar() {
        return repository.findAll().stream()
                .map(CursoDTO::new)
                .collect(Collectors.toList());
    }

    public CursoDTO buscarPorId(Long id) {
        return repository.findById(id)
                .map(CursoDTO::new)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}