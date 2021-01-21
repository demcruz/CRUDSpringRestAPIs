package br.com.sistema.exceptions;


public class UsuarioException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1181967467952749516L;

	public UsuarioException(Long id) {
		super("Não foi possivel encontrar o usuario");
	}

}
