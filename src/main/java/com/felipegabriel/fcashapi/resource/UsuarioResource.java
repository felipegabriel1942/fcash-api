package com.felipegabriel.fcashapi.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.felipegabriel.fcashapi.model.Usuario;
import com.felipegabriel.fcashapi.service.UsuarioService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("usuario")
@RequiredArgsConstructor
public class UsuarioResource {
	
	private final UsuarioService service;
	
	@PostMapping
	public ResponseEntity<Usuario> salvarUsuario(@RequestBody Usuario usuario) {
		try {
			return ResponseEntity.ok(service.salvarUsuario(usuario));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro ao salvar a usuário.");
		}
	}
	
	@GetMapping()
	public ResponseEntity<Usuario> buscarUsuarioPorId(@RequestParam("email") String email) {
		try {
			return ResponseEntity.ok(service.buscarUsuarioPorEmail(email));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro ao buscar a usuário.");
		}
	}
	
	@PutMapping
	public Usuario atualizarUsuario(@RequestBody Usuario usuario) {
		try {
			return service.atualizarUsuario(usuario);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro ao atualizar a usuário.");
		}
	}	
}
