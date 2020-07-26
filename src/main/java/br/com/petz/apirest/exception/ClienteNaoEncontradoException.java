package br.com.petz.apirest.exception;

public class ClienteNaoEncontradoException extends RuntimeException {
	private static final long serialVersionUID = -7213902406445617190L;
	private static final String MESSAGE = "Cliente de id %d não encontrado.";

	public ClienteNaoEncontradoException(Long id) {
		super(String.format(MESSAGE, id));
	}
}
