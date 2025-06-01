package com.agromanage.agromanagebackend.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String atividade;

    private String tipoPagamento;

    private Double valorPorUnidade;

    private Integer quantidade;

    @ManyToOne
    @JoinColumn(name = "lavoura_id")
    private Lavoura lavoura;
}
