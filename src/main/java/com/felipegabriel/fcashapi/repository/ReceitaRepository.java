package com.felipegabriel.fcashapi.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.felipegabriel.fcashapi.model.Receita;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Integer>{
	
	@Query("SELECT r FROM Receita r WHERE r.fkUsuario.pkUsuario = ?1")
	public List<Receita> findByFkUsuario(Integer fkUsuario, Pageable page);
}
