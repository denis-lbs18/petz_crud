package br.com.petz.petz_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.petz.petz_crud.model.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {
}
