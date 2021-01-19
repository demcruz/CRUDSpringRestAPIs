package br.com.sistema.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.sistema.Entity.Usuario;
import br.com.sistema.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private  UsuarioRepository usuarioRepository;
	
	
	
	public Usuario create(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	public Page<Usuario> findAll(Pageable pageable) {
		Page<Usuario> page = usuarioRepository.findAll(pageable);
		return page;
	}
	
	
	
	
	

}
