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

import com.felipegabriel.fcashapi.model.TipoReceita;
import com.felipegabriel.fcashapi.service.TipoReceitaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("tipo-receita")
@RequiredArgsConstructor
public class TipoReceitaResource {
	
	private final TipoReceitaService service;
	
	@PostMapping
	public ResponseEntity<TipoReceita> salvarTipoReceita(@RequestBody TipoReceita tipoReceita) {
		try {
			return ResponseEntity.ok(service.salvarTipoReceita(tipoReceita));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro ao salvar o tipo de receita.");
		}
		
	}
	
	@DeleteMapping("{pkTipoReceita}")
	public ResponseEntity<Void> deletarTipoReceita(@PathVariable Integer pkTipoReceita) {
		try {
			service.deletarTipoReceita(service.buscarTipoReceitaPorId(pkTipoReceita));
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro ao excluír o tipo de receita.");
		}
	}
	
	@GetMapping("{pkTipoReceita}")
	public ResponseEntity<TipoReceita> buscarTipoReceitaPorId(@PathVariable Integer pkTipoReceita) {
		try {
			return ResponseEntity.ok(service.buscarTipoReceitaPorId(pkTipoReceita));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro ao buscar o tipo de receita.");
		}
	}
	
	@PutMapping
	public TipoReceita atualizarTipoReceita(@RequestBody TipoReceita tipoReceita) {
		try {
			return service.atualizarTipoReceita(tipoReceita);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro ao atualizar o tipo de receita.");
		}
	}
	
	@GetMapping("tipoReceitas")
	public ResponseEntity<List<TipoReceita>> buscarTipoReceitas() {
		try {
			return ResponseEntity.ok(service.buscarTipoReceitas());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro ao buscar tipos de receita.");
		}
	}
	
}
