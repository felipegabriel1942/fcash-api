package com.felipegabriel.fcashapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.felipegabriel.fcashapi.model.TipoReceita;

@Repository
public interface TipoReceitaRepository extends JpaRepository<TipoReceita, Integer>{

}
