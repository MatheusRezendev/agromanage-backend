package com.agromanage.agromanagebackend.domain.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class LavouraDto {
    private Long id;
    private String nome;
    private String tipo;
    private Double area;
    private LocalDate dataPlantio;
    private LocalDate previsaoColheita;
    private String status;
}
