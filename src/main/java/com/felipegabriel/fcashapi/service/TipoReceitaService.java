package com.felipegabriel.fcashapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.felipegabriel.fcashapi.model.TipoReceita;
import com.felipegabriel.fcashapi.repository.TipoReceitaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TipoReceitaService {
	
private TipoReceitaRepository repository;
	
	public TipoReceita salvarTipoReceita(TipoReceita tipoReceita) {
		return repository.save(tipoReceita);
	}
	
	public void deletarTipoReceita(TipoReceita tipoReceita) {
		if(tipoReceita == null || tipoReceita.getPkTipoReceita() == null) {
			throw new IllegalArgumentException("Tipo de receita não existe no banco de dados.");
		}
		this.repository.delete(tipoReceita);
	}
	
	public TipoReceita buscarTipoReceitaPorId(Integer pkTipoReceita) {
		return this.repository.findById(pkTipoReceita).orElse(null);
	}
	
	public TipoReceita atualizarTipoReceita(TipoReceita tipoReceita) {
		if(tipoReceita == null || tipoReceita.getPkTipoReceita() == null) {
			throw new IllegalArgumentException("Tipo de receita não existe no banco de dados.");
		}
		return repository.save(tipoReceita);
	}
	
	public List<TipoReceita> buscarTipoReceitas() {
		return repository.findAll();
	}
}
