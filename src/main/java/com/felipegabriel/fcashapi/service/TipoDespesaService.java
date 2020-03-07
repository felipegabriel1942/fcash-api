package com.felipegabriel.fcashapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.felipegabriel.fcashapi.model.TipoDespesa;
import com.felipegabriel.fcashapi.repository.TipoDespesaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TipoDespesaService {
	
private TipoDespesaRepository repository;
	
	public TipoDespesa salvarTipoDespesa(TipoDespesa tipoDespesa) {
		return repository.save(tipoDespesa);
	}
	
	public void deletarTipoDespesa(TipoDespesa tipoDespesa) {
		if(tipoDespesa == null || tipoDespesa.getPkTipoDespesa() == null) {
			throw new IllegalArgumentException("Tipo de despesa não existe no banco de dados.");
		}
		this.repository.delete(tipoDespesa);
	}
	
	public TipoDespesa buscarTipoDespesaPorId(Integer pkTipoDespesa) {
		return this.repository.findById(pkTipoDespesa).orElse(null);
	}
	
	public TipoDespesa atualizarTipoDespesa(TipoDespesa tipoDespesa) {
		if(tipoDespesa == null || tipoDespesa.getPkTipoDespesa() == null) {
			throw new IllegalArgumentException("Tipo de despesa não existe no banco de dados.");
		}
		return repository.save(tipoDespesa);
	}
	
	public List<TipoDespesa> buscarTipoDespesas() {
		return repository.findAll();
	}
}
