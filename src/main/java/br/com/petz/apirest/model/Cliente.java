package br.com.petz.apirest.model;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class Cliente extends EntidadeAbstrata {
	private static final long serialVersionUID = 9193246946039134665L;

	@Getter
	@Setter
	private String nome;
	@Getter
	@Setter
	private Integer idade;
	@Getter
	@Setter
	private Genero genero;
	@Getter
	@Setter
	private String document;
	@Getter
	@Setter
	private List<Endereco> endereco;
}
