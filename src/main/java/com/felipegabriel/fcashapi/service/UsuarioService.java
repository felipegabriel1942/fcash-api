package com.felipegabriel.fcashapi.service;

import org.springframework.stereotype.Service;

import com.felipegabriel.fcashapi.model.Usuario;
import com.felipegabriel.fcashapi.repository.UsuarioRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsuarioService {
	
	private UsuarioRepository repository;
	
	public Usuario salvarUsuario(Usuario usuario) {
		return repository.save(usuario);
	}
	
	public Usuario buscarUsuarioPorEmail(String email) {
		return this.repository.findByEmail(email);
	}
	
	public Usuario atualizarUsuario(Usuario usuario) {
		if(usuario == null || usuario.getPkUsuario() == null) {
			throw new IllegalArgumentException("Usuário não existe no banco de dados.");
		}
		return repository.save(usuario);
	}
}
