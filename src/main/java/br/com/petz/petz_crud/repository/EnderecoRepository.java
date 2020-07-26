package br.com.petz.petz_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.petz.petz_crud.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
