package br.com.fiap.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record MetaDTO(
        Long id,
        String titulo,
        String descricao,
        BigDecimal valor,
        LocalDate dataLimite
) {

}