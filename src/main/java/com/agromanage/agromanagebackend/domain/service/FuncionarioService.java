package com.agromanage.agromanagebackend.domain.service;

import com.agromanage.agromanagebackend.domain.dto.FuncionarioDto;
import com.agromanage.agromanagebackend.domain.model.Funcionario;
import com.agromanage.agromanagebackend.domain.model.Lavoura;
import com.agromanage.agromanagebackend.domain.repository.FuncionarioRepository;
import com.agromanage.agromanagebackend.domain.repository.LavouraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private LavouraRepository lavouraRepository;

    public List<FuncionarioDto> listarTodos() {
        return funcionarioRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public Optional<FuncionarioDto> buscarPorId(Long id) {
        return funcionarioRepository.findById(id).map(this::toDTO);
    }

    public FuncionarioDto criar(FuncionarioDto dto) {
        Funcionario funcionario = toEntity(dto);

        // Buscar a lavoura para associar
        if (dto.getLavouraId() != null) {
            Lavoura lavoura = lavouraRepository.findById(dto.getLavouraId())
                    .orElseThrow(() -> new RuntimeException("Lavoura não encontrada"));
            funcionario.setLavoura(lavoura);
        }

        Funcionario salvo = funcionarioRepository.save(funcionario);
        return toDTO(salvo);
    }

    public FuncionarioDto atualizar(Long id, FuncionarioDto dto) {
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

        funcionario.setNome(dto.getNome());
        funcionario.setAtividade(dto.getAtividade());
        funcionario.setTipoPagamento(dto.getTipoPagamento());
        funcionario.setValorPorUnidade(dto.getValorPorUnidade());
        funcionario.setQuantidade(dto.getQuantidade());

        if (dto.getLavouraId() != null) {
            Lavoura lavoura = lavouraRepository.findById(dto.getLavouraId())
                    .orElseThrow(() -> new RuntimeException("Lavoura não encontrada"));
            funcionario.setLavoura(lavoura);
        } else {
            funcionario.setLavoura(null);
        }

        Funcionario atualizado = funcionarioRepository.save(funcionario);
        return toDTO(atualizado);
    }

    public void deletar(Long id) {
        funcionarioRepository.deleteById(id);
    }

    // Conversões Entity <-> DTO
    private FuncionarioDto toDTO(Funcionario f) {
        FuncionarioDto dto = new FuncionarioDto();
        dto.setId(f.getId());
        dto.setNome(f.getNome());
        dto.setAtividade(f.getAtividade());
        dto.setTipoPagamento(f.getTipoPagamento());
        dto.setValorPorUnidade(f.getValorPorUnidade());
        dto.setQuantidade(f.getQuantidade());
        dto.setLavouraId(f.getLavoura() != null ? f.getLavoura().getId() : null);
        return dto;
    }

    private Funcionario toEntity(FuncionarioDto dto) {
        Funcionario f = new Funcionario();
        f.setId(dto.getId());
        f.setNome(dto.getNome());
        f.setAtividade(dto.getAtividade());
        f.setTipoPagamento(dto.getTipoPagamento());
        f.setValorPorUnidade(dto.getValorPorUnidade());
        f.setQuantidade(dto.getQuantidade());
        // lavoura é setada no criar/atualizar via repositório
        return f;
    }
}
