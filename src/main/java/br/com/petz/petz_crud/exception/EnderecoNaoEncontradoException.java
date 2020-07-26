package br.com.petz.petz_crud.exception;

public class EnderecoNaoEncontradoException extends RuntimeException {
	private static final long serialVersionUID = 4649752416002434405L;
	private static final String MESSAGE = "Endereço de id %d não encontrado.";

	public EnderecoNaoEncontradoException(Long id) {
		super(String.format(MESSAGE, id));
	}
}
