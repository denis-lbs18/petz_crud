package br.com.petz.apirest.model;

public enum Genero {
	MASCULINO("M"), FEMININO("F");

	@SuppressWarnings("unused")
	private String nome;

	Genero(String nome) {
		this.nome = nome;
	}
}
