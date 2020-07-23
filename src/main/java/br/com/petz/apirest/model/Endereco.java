package br.com.petz.apirest.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class Endereco extends EntidadeAbstrata {
	private static final long serialVersionUID = 5681344695368061135L;
	@Getter
	@Setter
	private String logradouro;
	@Getter
	@Setter
	private Integer numero;
	@Getter
	@Setter
	private String cidade;
	@Getter
	@Setter
	private String estado;
	@Getter
	@Setter
	private String cep;
}
