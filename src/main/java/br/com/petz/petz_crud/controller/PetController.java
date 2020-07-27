package br.com.petz.petz_crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.petz.petz_crud.exception.PetNaoEncontradoException;
import br.com.petz.petz_crud.model.Pet;
import br.com.petz.petz_crud.repository.PetRepository;

@RestController
@RequestMapping(path = "/pets")
public class PetController {
	@Autowired
	private PetRepository petRepository;

	@GetMapping(value = "/listarTodos")
	public @ResponseBody Iterable<Pet> listarTodosOsClientes() {
		return petRepository.findAll();

	}

	@GetMapping(path = { "/{id}" })
	public ResponseEntity<Pet> encontraPorID(@PathVariable long id) {
		return petRepository.findById(id).map(pet -> ResponseEntity.ok().body(pet))
				.orElseThrow(() -> new PetNaoEncontradoException(id));
	}

	@PostMapping(path = "/adicionar")
	public @ResponseBody String adicionaNovoPet(@RequestBody Pet pet) {
		petRepository.save(pet);
		return "Pet adicionado";
	}

	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> deletaPetPorId(@PathVariable long id) {
		return petRepository.findById(id).map(cliente -> {
			petRepository.delete(cliente);
			return ResponseEntity.status(HttpStatus.OK).build();
		}).orElseThrow(() -> new PetNaoEncontradoException(id));
	}

	@PutMapping("/atualizar/{id}")
	public Pet atualizaPet(@RequestBody Pet petAtualizado, @PathVariable Long id) {
		petAtualizado.setId(id);
		return petRepository.findById(id).map(pet -> {
			pet.atualiza(petAtualizado);
			return petRepository.save(pet);
		}).orElseGet(() -> {
			return petRepository.save(petAtualizado);
		});
	}

}