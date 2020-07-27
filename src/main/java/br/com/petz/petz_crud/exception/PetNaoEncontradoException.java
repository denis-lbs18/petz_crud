package br.com.petz.petz_crud.exception;

public class PetNaoEncontradoException extends RuntimeException {
	private static final long serialVersionUID = -7213902406445617190L;
	private static final String MESSAGE = "Pet de id %d não encontrado.";

	public PetNaoEncontradoException(Long id) {
		super(String.format(MESSAGE, id));
	}
}
