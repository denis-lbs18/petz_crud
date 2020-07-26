package br.com.petz.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.petz.apirest.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
