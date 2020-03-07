package com.felipegabriel.fcashapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.felipegabriel.fcashapi.model.Receita;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Integer>{

}
