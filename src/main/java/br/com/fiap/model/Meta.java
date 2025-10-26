package br.com.fiap.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tbl_metas")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Meta {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "METAS_SEQ")
    @SequenceGenerator(name = "METAS_SEQ", sequenceName = "METAS_SEQ", allocationSize = 1)
    private Long id;

    private String titulo;
    private String descricao;
    private BigDecimal valor;

    @Column(name = "data_limite")
    private LocalDate dataLimite;
}