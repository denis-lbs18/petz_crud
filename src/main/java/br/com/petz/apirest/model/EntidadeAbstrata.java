package br.com.petz.apirest.model;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@EqualsAndHashCode
public abstract class EntidadeAbstrata implements Serializable {
	private static final long serialVersionUID = 1L;
	@Getter
	@Setter
	private Long id;

	public boolean canEqual(Object obj) {
		return obj instanceof EntidadeAbstrata;
	}
}
