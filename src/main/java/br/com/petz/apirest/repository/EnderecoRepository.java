package br.com.petz.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.petz.apirest.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
