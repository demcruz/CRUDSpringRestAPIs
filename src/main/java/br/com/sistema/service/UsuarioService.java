package br.com.sistema.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.sistema.Entity.Usuario;
import br.com.sistema.exceptions.UsuarioException;
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
		Optional<Usuario> user =  usuarioRepository.findById(id);
		if (!user.isPresent()) {
			throw new UsuarioException(id);
		}
			return usuarioRepository.findById(id);		
	
	}
	
	
	public Usuario update(Usuario usuario, Long id) {
		Optional<Usuario> usur = usuarioRepository.findById(id);
		if(!usur.isPresent()) {
			throw new UsuarioException(id);
		}
			Usuario usuarioUpdate = usur.get();
			usuarioUpdate.setNome(usuario.getNome());
			usuarioUpdate.setEmail(usuario.getEmail());
			usuarioUpdate.setPassword(usuario.getPassword());			
			return usuarioRepository.save(usuarioUpdate);
		
	}
	
	
	
	public void delete(Long id) {
		Optional<Usuario> savedUsuario = usuarioRepository.findById(id);
		if(!savedUsuario.isPresent()) {
			throw new UsuarioException(id);
		}		
			usuarioRepository.deleteById(id);
		
	}

	
	
	

}
