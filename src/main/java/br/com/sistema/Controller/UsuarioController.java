package br.com.sistema.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.sistema.Entity.Usuario;
import br.com.sistema.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping(method = RequestMethod.POST)
	public Usuario create(@RequestBody Usuario usuario) {

		return usuarioService.create(usuario);
	}

	@RequestMapping(method = RequestMethod.GET)
	public Page<Usuario> findAll(Pageable pageable) {
		Page<Usuario> page = usuarioService.findAll(pageable);

		return page;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Optional<Usuario>> findbyId( @PathVariable(value = "id") Long id) {
		return ResponseEntity.ok().body(usuarioService.findById(id));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Usuario update(@RequestBody Usuario usuario, @PathVariable(value = "id") Long id) {

		return usuarioService.update(usuario, id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {		
		 usuarioService.delete(id);
				
	}

}
