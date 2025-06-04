package com.agromanage.agromanagebackend.domain.service;

import com.agromanage.agromanagebackend.domain.dto.LavouraDto;
import com.agromanage.agromanagebackend.domain.model.Lavoura;
import com.agromanage.agromanagebackend.domain.repository.LavouraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LavouraService {

    @Autowired
    private LavouraRepository lavouraRepository;

    public List<LavouraDto> listar() {
        return lavouraRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public LavouraDto buscarPorId(Long id) {
        return lavouraRepository.findById(id).map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("Lavoura não encontrada"));
    }

    public LavouraDto criar(LavouraDto dto) {
        Lavoura lavoura = toEntity(dto);
        return toDTO(lavouraRepository.save(lavoura));
    }

    public LavouraDto atualizar(Long id, LavouraDto dto) {
        Lavoura lavoura = lavouraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lavoura não encontrada"));

        lavoura.setNome(dto.getNome());
        lavoura.setTipo(dto.getTipo());
        lavoura.setArea(dto.getArea());
        lavoura.setDataPlantio(dto.getDataPlantio());
        lavoura.setPrevisaoColheita(dto.getPrevisaoColheita());
        lavoura.setStatus(dto.getStatus());

        return toDTO(lavouraRepository.save(lavoura));
    }

    public void deletar(Long id) {
        lavouraRepository.deleteById(id);
    }

    private LavouraDto toDTO(Lavoura l) {
        LavouraDto dto = new LavouraDto();
        dto.setId(l.getId());
        dto.setNome(l.getNome());
        dto.setTipo(l.getTipo());
        dto.setArea(l.getArea());
        dto.setDataPlantio(l.getDataPlantio());
        dto.setPrevisaoColheita(l.getPrevisaoColheita());
        dto.setStatus(l.getStatus());
        return dto;
    }

    private Lavoura toEntity(LavouraDto dto) {
        Lavoura l = new Lavoura();
        l.setId(dto.getId());
        l.setNome(dto.getNome());
        l.setTipo(dto.getTipo());
        l.setArea(dto.getArea());
        l.setDataPlantio(dto.getDataPlantio());
        l.setPrevisaoColheita(dto.getPrevisaoColheita());
        l.setStatus(dto.getStatus());
        return l;
    }
}
