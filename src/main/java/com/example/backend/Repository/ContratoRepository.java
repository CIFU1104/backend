package com.example.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backend.Model.Contrato;

public interface ContratoRepository extends JpaRepository<Contrato, Long> {
}

