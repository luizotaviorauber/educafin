package br.com.fiap.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_cursos")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Curso {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "CURSOS_SEQ"
    )
    @SequenceGenerator(
            name = "CURSOS_SEQ",
            sequenceName = "CURSOS_SEQ",
            allocationSize = 1
    )
    private Long id;

    private String nome;
    private String descricao;
}