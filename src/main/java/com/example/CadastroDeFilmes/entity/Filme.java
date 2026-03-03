package com.example.CadastroDeFilmes.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "filmes_tb")
@Getter
@Setter
@NoArgsConstructor
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String diretor;

    private Integer anoLancamento;

    private String sinopse;
}
