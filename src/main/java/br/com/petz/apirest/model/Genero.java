package br.com.petz.apirest.model;

public enum Genero {
	MASCULINO('M'), FEMININO('F');

	@SuppressWarnings("unused")
	private Character genero;

	Genero(Character genero) {
		this.genero = genero;
	}
}
