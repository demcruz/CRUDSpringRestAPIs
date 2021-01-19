package br.com.sistema.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sistema.Entity.Usuario;
import br.com.sistema.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	
	public Usuario create (Usuario ususario) {
		 Usuario user = usuarioService.create(ususario);
		 return user;
	}
	
	public Page<Usuario> findAll(Pageable pageable){
		Page<Usuario> page =usuarioService.findAll(pageable);
				
				return page;
	}
	

}
