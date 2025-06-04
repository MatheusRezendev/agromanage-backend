package com.agromanage.agromanagebackend.domain.repository;

import com.agromanage.agromanagebackend.domain.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
