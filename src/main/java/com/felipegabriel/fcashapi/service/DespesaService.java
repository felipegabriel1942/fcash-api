package com.felipegabriel.fcashapi.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.felipegabriel.fcashapi.model.Despesa;
import com.felipegabriel.fcashapi.repository.DespesaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DespesaService {
	
	private DespesaRepository repository;
	
	public Despesa salvarDespesa(Despesa despesa) {
		return repository.save(despesa);
	}
	
	public void deletarDespesa(Despesa despesa) {
		if(despesa == null || despesa.getPkDespesa() == null) {
			throw new IllegalArgumentException("Despesa não existe no banco de dados.");
		}
		this.repository.delete(despesa);
	}
	
	public Despesa buscarDespesaPorId(Integer pkDespesa) {
		return this.repository.findById(pkDespesa).orElse(null);
	}
	
	public Despesa atualizarDespesa(Despesa despesa) {
		if(despesa == null || despesa.getPkDespesa() == null) {
			throw new IllegalArgumentException("Despesa não existe no banco de dados.");
		}
		return repository.save(despesa);
	}
	
	public List<Despesa> buscarDespesas(Integer pagina, Integer tamanho) {
		return repository.findAll(PageRequest.of(pagina, tamanho)).getContent();
	}
}
