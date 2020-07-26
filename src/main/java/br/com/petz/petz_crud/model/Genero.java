package br.com.petz.petz_crud.model;

public enum Genero {
	MASCULINO("M"), FEMININO("F");

	@SuppressWarnings("unused")
	private String nome;

	Genero(String nome) {
		this.nome = nome;
	}
}
