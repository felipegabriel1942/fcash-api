package com.felipegabriel.fcashapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.felipegabriel.fcashapi.model.TipoDespesa;

@Repository
public interface TipoDespesaRepository extends JpaRepository<TipoDespesa, Integer>{

}
