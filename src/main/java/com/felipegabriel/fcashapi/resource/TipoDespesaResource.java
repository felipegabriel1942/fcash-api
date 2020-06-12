package com.felipegabriel.fcashapi.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.felipegabriel.fcashapi.model.TipoDespesa;
import com.felipegabriel.fcashapi.service.TipoDespesaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("tipo-despesa")
@RequiredArgsConstructor
public class TipoDespesaResource {
	
	private final TipoDespesaService service;
	
	@PostMapping
	public ResponseEntity<TipoDespesa> salvarTipoDespesa(@RequestBody TipoDespesa tipoTipoDespesa) {
		try {
			return ResponseEntity.ok(service.salvarTipoDespesa(tipoTipoDespesa));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro ao salvar o tipo de despesa.");
		}
		
	}
	
	@DeleteMapping("{pktipoTipoDespesa}")
	public ResponseEntity<Void> deletarTipoDespesa(@PathVariable Integer pkTipoDespesa) {
		try {
			service.deletarTipoDespesa(service.buscarTipoDespesaPorId(pkTipoDespesa));
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro ao excluír o tipo de despesa.");
		}
	}
	
	@GetMapping("{pktipoTipoDespesa}")
	public ResponseEntity<TipoDespesa> buscarTipoDespesaPorId(@PathVariable Integer pkTipoDespesa) {
		try {
			return ResponseEntity.ok(service.buscarTipoDespesaPorId(pkTipoDespesa));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro ao buscar o tipo de despesa.");
		}
	}
	
	@PutMapping
	public TipoDespesa atualizarTipoDespesa(@RequestBody TipoDespesa tipoTipoDespesa) {
		try {
			return service.atualizarTipoDespesa(tipoTipoDespesa);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro ao atualizar o tipo de despesa.");
		}
	}
	
	@GetMapping
	public ResponseEntity<List<TipoDespesa>> buscarTipoDespesas() {
		try {
			return ResponseEntity.ok(service.buscarTipoDespesas());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro ao buscar tipos de despesa.");
		}
	}
	
}
