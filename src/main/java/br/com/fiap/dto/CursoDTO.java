package br.com.fiap.dto;

import br.com.fiap.model.Curso;

public record CursoDTO(
        Long id,
        String nome,
        String descricao
) {
    public CursoDTO(Curso curso) {
        this(curso.getId(), curso.getNome(), curso.getDescricao());
    }
}