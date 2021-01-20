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
	
	public Optional<Usuario> findById(Long id) {		
		return usuarioRepository.findById(id);
	
	}
	
	
	public Usuario update(Usuario usuar, Long id) {
		Optional<Usuario> saveUsuario = usuarioRepository.findById(id);
		if(saveUsuario.isPresent()) {
			Usuario usuario = saveUsuario.get();
				usuario.setNome(usuar.getNome());
				usuario.setEmail(usuar.getEmail());
				usuario.setPassword(usuar.getPassword());
				return usuarioRepository.save(usuario);
		}
		
		return null;
		
	}
	
	
	
	public void delete(Long id) {
		Optional<Usuario> savedUsuario = usuarioRepository.findById(id);
		if(savedUsuario.isPresent()) {
			Usuario deletedUsuario = savedUsuario.get();
			usuarioRepository.delete(deletedUsuario);
		}
	}

	
	
	

}
