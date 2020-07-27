package br.com.petz.petz_crud.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.apache.commons.lang3.builder.EqualsBuilder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Pet extends EntidadeAbstrata {
	private static final long serialVersionUID = -6158820286574813166L;
	@Getter
	@Setter
	private String nome;
	@Getter
	@Setter
	private Integer idade;
	@Getter
	@Setter
	@Enumerated(EnumType.STRING)
	private Especie especie;
	@Getter
	@Setter
	private String raça;
	@Getter
	@Setter
	@Enumerated(EnumType.STRING)
	private Genero genero;

	@Override
	public boolean canEqual(Object obj) {
		return obj instanceof Pet;
	}

	public void atualiza(Pet petAtualizado) {
		this.setId(petAtualizado.getId());
		this.setEspecie(petAtualizado.getEspecie());
		this.setNome(petAtualizado.getNome());
		this.setIdade(petAtualizado.getIdade());
		this.setGenero(petAtualizado.getGenero());
		this.setRaça(petAtualizado.getRaça());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((especie == null) ? 0 : especie.hashCode());
		result = prime * result + ((genero == null) ? 0 : genero.hashCode());
		result = prime * result + ((idade == null) ? 0 : idade.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((raça == null) ? 0 : raça.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Pet) {
			Pet other = (Pet) obj;
			return other.canEqual(this) && new EqualsBuilder().appendSuper(super.equals(other))
					.append(other.getNome(), this.getNome()).append(other.getIdade(), this.getIdade())
					.append(other.getGenero(), this.getGenero()).append(other.getEspecie(), this.getEspecie())
					.append(this.getRaça(), other.getRaça()).isEquals();
		}
		return false;
	}

}
