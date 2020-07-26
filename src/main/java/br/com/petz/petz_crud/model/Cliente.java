package br.com.petz.petz_crud.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;

import org.apache.commons.lang3.builder.EqualsBuilder;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
public class Cliente extends EntidadeAbstrata {
	private static final long serialVersionUID = 9193246946039134665L;

	@Getter
	@Setter
	private String nome;
	@Getter
	@Setter
	private String cpf;
	@Getter
	@Setter
	private Integer idade;
	@Getter
	@Setter
	@Enumerated(EnumType.STRING)
	private Genero genero;
	@Getter
	@Setter
	private String email;
	@Getter
	@Setter
	@OneToMany(cascade = { CascadeType.ALL })
	private List<Endereco> listaEnderecos = new ArrayList<>();

	public Cliente(String nome, Integer idade, Genero genero, String email) {
		this.nome = nome;
		this.idade = idade;
		this.genero = genero;
		this.email = email;
	}

	@Override
	public boolean canEqual(Object obj) {
		return obj instanceof Cliente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((listaEnderecos == null) ? 0 : listaEnderecos.hashCode());
		result = prime * result + ((genero == null) ? 0 : genero.hashCode());
		result = prime * result + ((idade == null) ? 0 : idade.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Cliente) {
			Cliente other = (Cliente) obj;
			return other.canEqual(this)
					&& new EqualsBuilder().appendSuper(super.equals(other)).append(other.getNome(), this.getNome())
							.append(other.getIdade(), this.getIdade()).append(other.getGenero(), this.getGenero())
							.append(other.getEmail(), this.getEmail()).append(this.getCpf(), other.getCpf())
							.append(other.getListaEnderecos(), this.getListaEnderecos()).isEquals();
		}
		return false;
	}

	public void adicionaEndereco(Endereco endereco) {
		this.getListaEnderecos().add(endereco);
	}

	public void atualiza(Cliente clienteAtualizado) {
		this.setId(clienteAtualizado.getId());
		this.setCpf(clienteAtualizado.getCpf());
		this.setNome(clienteAtualizado.getNome());
		this.setIdade(clienteAtualizado.getIdade());
		this.setGenero(clienteAtualizado.getGenero());
		this.setEmail(clienteAtualizado.getEmail());
		this.setListaEnderecos(clienteAtualizado.getListaEnderecos());
	}

	public void atualizaEndereco(Endereco enderecoAtualizado) {
		for (Iterator<Endereco> iterator = listaEnderecos.iterator(); iterator.hasNext();) {
			Endereco endereco = iterator.next();
			if (endereco.getId() == enderecoAtualizado.getId()) {
				endereco.atualiza(enderecoAtualizado);
				return;
			}
		}

	}
}
