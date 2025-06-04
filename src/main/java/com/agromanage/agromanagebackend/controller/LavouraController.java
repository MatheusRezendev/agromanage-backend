package com.agromanage.agromanagebackend.controller;

import com.agromanage.agromanagebackend.domain.dto.LavouraDto;
import com.agromanage.agromanagebackend.domain.service.LavouraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lavouras")
public class LavouraController {

    @Autowired
    private LavouraService lavouraService;

    @GetMapping
    public ResponseEntity<List<LavouraDto>> listar() {
        return ResponseEntity.ok(lavouraService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LavouraDto> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(lavouraService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<LavouraDto> criar(@RequestBody LavouraDto dto) {
        return ResponseEntity.ok(lavouraService.criar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LavouraDto> atualizar(@PathVariable Long id, @RequestBody LavouraDto dto) {
        return ResponseEntity.ok(lavouraService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        lavouraService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
