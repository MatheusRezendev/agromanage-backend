package com.agromanage.agromanagebackend.domain.dto;

import lombok.Data;

@Data
public class FuncionarioDto {
    private Long id;
    private String nome;
    private String atividade;
    private String tipoPagamento;
    private Double valorPorUnidade;
    private Integer quantidade;
    private Long lavouraId;
}
