package br.com.fiap.dto;

import java.time.LocalDate;

public record UsuarioDTO(
        Long id,
        String nome,
        String email,
        String senha, //
        LocalDate dataNascimento
) {}