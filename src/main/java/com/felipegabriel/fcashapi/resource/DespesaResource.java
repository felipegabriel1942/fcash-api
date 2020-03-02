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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.felipegabriel.fcashapi.model.Despesa;
import com.felipegabriel.fcashapi.service.DespesaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("despesa")
@RequiredArgsConstructor
public class DespesaResource {
	
	private final DespesaService service;
	
	@PostMapping
	public ResponseEntity<Despesa> salvarDespesa(@RequestBody Despesa despesa) {
		try {
			return ResponseEntity.ok(service.salvarDespesa(despesa));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro ao salvar a despesa.");
		}
		
	}
	
	@DeleteMapping("{pkdespesa}")
	public ResponseEntity<Void> deletarDespesa(@PathVariable Integer pkDespesa) {
		try {
			service.deletarDespesa(service.buscarDespesaPorId(pkDespesa));
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro ao excluír despesa.");
		}
	}
	
	@GetMapping("{pkdespesa}")
	public ResponseEntity<Despesa> buscarDespesaPorId(@PathVariable Integer pkDespesa) {
		try {
			return ResponseEntity.ok(service.buscarDespesaPorId(pkDespesa));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro ao buscar a despesa.");
		}
	}
	
	@PutMapping
	public Despesa atualizarDespesa(@RequestBody Despesa despesa) {
		try {
			return service.atualizarDespesa(despesa);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro ao atualizar a despesa.");
		}
	}
	
	@GetMapping("despesas")
	public ResponseEntity<List<Despesa>> buscarDespesas(
			@RequestParam("pagina") Integer pagina,
			@RequestParam("tamanho") Integer tamanho) {
		try {
			return ResponseEntity.ok(service.buscarDespesas(pagina, tamanho));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro ao buscar despesas.");
		}
	}
	
}
