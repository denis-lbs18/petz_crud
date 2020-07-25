package br.com.petz.apirest.model;

import javax.persistence.Entity;

import org.apache.commons.lang3.builder.EqualsBuilder;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
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

	@Override
	public boolean canEqual(Object obj) {
		return obj instanceof Endereco;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Endereco) {
			Endereco other = (Endereco) obj;
			return other.canEqual(this) && new EqualsBuilder().appendSuper(super.equals(other))
					.append(this.getLogradouro(), other.getLogradouro()).append(this.getNumero(), other.getNumero())
					.append(this.getCidade(), other.getCidade()).append(this.getEstado(), other.getEstado())
					.append(this.getCep(), other.getCep()).isEquals();
		}
		return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((logradouro == null) ? 0 : logradouro.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		return result;
	}
}
