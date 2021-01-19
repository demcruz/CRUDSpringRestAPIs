package br.com.sistema.service;

import java.util.Optional;

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
	
	public Usuario findById(Long id) {
		Usuario usuario = new Usuario();
		Optional<Usuario> saveUsuario = usuarioRepository.findById(id);
		if(saveUsuario.isPresent()){
			return saveUsuario.get();
		}
		return usuario;
	}
	
	
	public Usuario update(Usuario usuario, Long id) {
		Usuario update = new Usuario();
		Optional<Usuario> saveUsuario = usuarioRepository.findById(id);
		if(saveUsuario.isPresent()) {
			update = usuarioRepository.save(update);
		}
		
		
		return update;
	}
	
	
	
	public void deleteUsuario(Long id) {
		Optional<Usuario> savedUsuario = usuarioRepository.findById(id);
		if(savedUsuario.isPresent()) {
			Usuario deletedUsuario = savedUsuario.get();
			usuarioRepository.delete(deletedUsuario);
		}
	}
	
	
	
	

}
