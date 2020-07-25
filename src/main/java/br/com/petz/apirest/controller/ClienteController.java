package br.com.petz.apirest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.petz.apirest.model.Cliente;
import br.com.petz.apirest.repository.ClienteRepository;

@RestController
@RequestMapping(path = "/clientes")
public class ClienteController {
	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping(value = "/listarTodos")
	public @ResponseBody Iterable<Cliente> listarTodosOsClientes() {
		return clienteRepository.findAll();

	}

	@GetMapping(path = { "/{id}" })
	public ResponseEntity<Cliente> encontraPorID(@PathVariable long id) {
		return clienteRepository.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping(path = "/adicionar")
	public @ResponseBody String adicionaNovoCliente(@RequestBody Cliente cliente) {
		clienteRepository.save(cliente);
		return "Saved";
	}

	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> delete(@PathVariable long id) {
		boolean existe = clienteRepository.existsById(id);

		if (!existe) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		clienteRepository.deleteById(id);
		return new ResponseEntity<>(id, HttpStatus.OK);
	}

	/*
	 * @PutMapping("atualizar/{id}") public Cliente atualizaCliente(@RequestBody
	 * Cliente clienteAtualizado, @PathVariable Long id) { return
	 * clienteRepository.findById(id).map(cliente -> {
	 * cliente.setNome(clienteAtualizado.getNome());
	 * cliente.setRole(clienteAtualizado.getRole()); return
	 * repository.save(cliente); }).orElseGet(() -> { newEmployee.setId(id); return
	 * repository.save(newEmployee); }); }
	 */

}