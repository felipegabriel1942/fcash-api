package com.felipegabriel.fcashapi.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.felipegabriel.fcashapi.model.Receita;
import com.felipegabriel.fcashapi.repository.ReceitaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ReceitaService {
	
private ReceitaRepository repository;
	
	public Receita salvarReceita(Receita receita) {
		return repository.save(receita);
	}
	
	public void deletarReceita(Receita receita) {
		if(receita == null || receita.getPkReceita() == null) {
			throw new IllegalArgumentException("Receita não existe no banco de dados.");
		}
		this.repository.delete(receita);
	}
	
	public Receita buscarReceitaPorId(Integer pkReceita) {
		return this.repository.findById(pkReceita).orElse(null);
	}
	
	public Receita atualizarReceita(Receita receita) {
		if(receita == null || receita.getPkReceita() == null) {
			throw new IllegalArgumentException("Receita não existe no banco de dados.");
		}
		return repository.save(receita);
	}
	
	public List<Receita> buscarReceitas(Integer pagina, Integer tamanho) {
		return repository.findAll(PageRequest.of(pagina, tamanho)).getContent();
	}
}
