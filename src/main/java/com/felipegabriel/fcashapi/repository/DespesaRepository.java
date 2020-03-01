package com.felipegabriel.fcashapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.felipegabriel.fcashapi.model.Despesa;

@Repository
public interface DespesaRepository extends JpaRepository<Despesa, Integer>{

}
