package com.agromanage.agromanagebackend.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Lavoura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String tipo;

    private Double area;

    private LocalDate dataPlantio;

    private LocalDate previsaoColheita;

    private String status;

    @OneToMany(mappedBy = "lavoura", cascade = CascadeType.ALL)
    private List<Funcionario> funcionarios;

    @OneToMany(mappedBy = "lavoura", cascade = CascadeType.ALL)
    private List<Financa> financas;
}
