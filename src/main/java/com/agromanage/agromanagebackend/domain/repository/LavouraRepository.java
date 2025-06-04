package com.agromanage.agromanagebackend.domain.repository;

import com.agromanage.agromanagebackend.domain.dto.LavouraDto;
import com.agromanage.agromanagebackend.domain.model.Lavoura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LavouraRepository extends JpaRepository<Lavoura, Long> {
}
