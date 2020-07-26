package br.com.petz.petz_crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.apache.commons.lang3.builder.EqualsBuilder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Endereco extends EntidadeAbstrata {
	private static final long serialVersionUID = 5681344695368061135L;
	@Getter
	@Setter
	@Column(length = 40)
	private String logradouro;
	@Getter
	@Setter
	private Integer numero;
	@Getter
	@Setter
	@Column(length = 20)
	private String complemento;
	@Getter
	@Setter
	@Column(length = 40)
	private String cidade;
	@Getter
	@Setter
	@Column(length = 2)
	private String estado;
	@Getter
	@Setter
	@Column(length = 9)
	private String cep;

	public void atualiza(Endereco enderecoAtualizado) {
		this.setCep(enderecoAtualizado.getCep());
		this.setCidade(enderecoAtualizado.getCidade());
		this.setEstado(enderecoAtualizado.getEstado());
		this.setLogradouro(enderecoAtualizado.getLogradouro());
		this.setNumero(enderecoAtualizado.getNumero());
		this.setComplemento(enderecoAtualizado.getComplemento());
	}

	@Override
	public boolean canEqual(Object obj) {
		return obj instanceof Endereco;
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
		result = prime * result + ((complemento == null) ? 0 : complemento.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Endereco) {
			Endereco other = (Endereco) obj;
			return other.canEqual(this) && new EqualsBuilder().appendSuper(super.equals(other))
					.append(this.getLogradouro(), other.getLogradouro()).append(this.getNumero(), other.getNumero())
					.append(this.getCidade(), other.getCidade()).append(this.getEstado(), other.getEstado())
					.append(this.getComplemento(), other.getComplemento()).append(this.getCep(), other.getCep())
					.isEquals();
		}
		return false;
	}
}