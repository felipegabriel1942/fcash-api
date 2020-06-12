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

import com.felipegabriel.fcashapi.model.Receita;
import com.felipegabriel.fcashapi.service.ReceitaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("receita")
@RequiredArgsConstructor
public class ReceitaResource {
	
	private final ReceitaService service;
	
	@PostMapping
	public ResponseEntity<Receita> salvarReceita(@RequestBody Receita receita) {
		try {
			return ResponseEntity.ok(service.salvarReceita(receita));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro ao salvar a receita.");
		}
		
	}
	
	@DeleteMapping("{pkreceita}")
	public ResponseEntity<Void> deletarReceita(@PathVariable Integer pkReceita) {
		try {
			service.deletarReceita(service.buscarReceitaPorId(pkReceita));
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro ao excluír receita.");
		}
	}
	
	@GetMapping("{pkreceita}")
	public ResponseEntity<Receita> buscarReceitaPorId(@PathVariable Integer pkReceita) {
		try {
			return ResponseEntity.ok(service.buscarReceitaPorId(pkReceita));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro ao buscar a receita.");
		}
	}
	
	@PutMapping
	public Receita atualizarReceita(@RequestBody Receita receita) {
		try {
			return service.atualizarReceita(receita);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro ao atualizar a receita.");
		}
	}
	
	@GetMapping("receitas")
	public ResponseEntity<List<Receita>> buscarReceitas(
			@RequestParam("pagina") Integer pagina,
			@RequestParam("tamanho") Integer tamanho,
			@RequestParam("fkUsuario") Integer fkUsuario) {
		try {
			return ResponseEntity.ok(service.buscarReceitas(pagina, tamanho, fkUsuario));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro ao buscar receitas.");
		}
	}
	
}
