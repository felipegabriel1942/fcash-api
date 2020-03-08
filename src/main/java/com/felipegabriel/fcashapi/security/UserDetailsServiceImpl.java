package com.felipegabriel.fcashapi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.felipegabriel.fcashapi.model.Usuario;
import com.felipegabriel.fcashapi.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UsuarioRepository repository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario = repository.findByEmail(email);
		if(usuario == null) {
			throw new UsernameNotFoundException(email);
		}
		
		return new UserSS(usuario.getPkUsuario(), usuario.getEmail(), usuario.getSenha());
	}
}
