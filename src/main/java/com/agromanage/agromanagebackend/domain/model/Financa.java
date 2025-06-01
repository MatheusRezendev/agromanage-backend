package com.agromanage.agromanagebackend.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Financa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;

    private String descricao;

    private String categoria;

    private Double valor;

    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "lavoura_id")
    private Lavoura lavoura;
}
