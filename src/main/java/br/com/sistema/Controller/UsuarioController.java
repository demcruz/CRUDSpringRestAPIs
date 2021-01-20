package br.com.sistema.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sistema.Entity.Usuario;
import br.com.sistema.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping
	public Usuario create ( @RequestBody Usuario usuario) {		
		 
		 return usuarioService.create(usuario);
	}
	
	@GetMapping
	public Page<Usuario> findAll(Pageable pageable){
		Page<Usuario> page =usuarioService.findAll(pageable);
				
				return page;
	}
	
	@GetMapping(path="{/id}")
	public Optional<Usuario> findbyId(Long id) {
		return usuarioService.findById(id);
	}
	
	
	@PutMapping("{/id}")
	public ResponseEntity<Usuario> update(@RequestBody Usuario usuario, @PathVariable("id") Long id) {
		Usuario usuarUpdate = usuarioService.update(usuario, id);
		return new ResponseEntity<Usuario>(usuarUpdate, HttpStatus.OK);
	}
	
	
	
	@DeleteMapping(path = "{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		usuarioService.delete(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

}
