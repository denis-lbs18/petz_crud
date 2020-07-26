package br.com.petz.petz_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.petz.petz_crud.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
