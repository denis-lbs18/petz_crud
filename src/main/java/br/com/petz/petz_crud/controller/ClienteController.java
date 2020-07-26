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

import br.com.petz.petz_crud.exception.ClienteNaoEncontradoException;
import br.com.petz.petz_crud.exception.EnderecoNaoEncontradoException;
import br.com.petz.petz_crud.model.Cliente;
import br.com.petz.petz_crud.model.Endereco;
import br.com.petz.petz_crud.repository.ClienteRepository;
import br.com.petz.petz_crud.repository.EnderecoRepository;

@RestController
@RequestMapping(path = "/clientes")
public class ClienteController {
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;

	@GetMapping(value = "/listarTodos")
	public @ResponseBody Iterable<Cliente> listarTodosOsClientes() {
		return clienteRepository.findAll();

	}

	@GetMapping(path = { "/{id}" })
	public ResponseEntity<Cliente> encontraPorID(@PathVariable long id) {
		return clienteRepository.findById(id).map(cliente -> ResponseEntity.ok().body(cliente))
				.orElseThrow(() -> new ClienteNaoEncontradoException(id));
	}

	@PostMapping(path = "/adicionar")
	public @ResponseBody String adicionaNovoCliente(@RequestBody Cliente cliente) {
		clienteRepository.save(cliente);
		return "Cliente adicionado";
	}

	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> delete(@PathVariable long id) {
		return clienteRepository.findById(id).map(cliente -> {
			clienteRepository.delete(cliente);
			return ResponseEntity.status(HttpStatus.OK).build();
		}).orElseThrow(() -> new ClienteNaoEncontradoException(id));
	}

	@PutMapping("/atualizar/{id}")
	public Cliente atualizaCliente(@RequestBody Cliente clienteAtualizado, @PathVariable Long id) {
		clienteAtualizado.setId(id);
		return clienteRepository.findById(id).map(cliente -> {
			cliente.atualiza(clienteAtualizado);
			return clienteRepository.save(cliente);
		}).orElseGet(() -> {
			return clienteRepository.save(clienteAtualizado);
		});
	}

	@PostMapping(path = "/{id}/adicionarEndereco")
	public @ResponseBody String adicionaEndereco(@PathVariable long id, @RequestBody Endereco endereco) {
		clienteRepository.findById(id).map(cliente -> {
			enderecoRepository.save(endereco);
			cliente.adicionaEndereco(endereco);
			clienteRepository.save(cliente);
			return ResponseEntity.ok().body(cliente);
		}).orElseThrow(() -> new ClienteNaoEncontradoException(id));
		return "Endereço adicionado";
	}

	@PutMapping("/{id}/atualizarEndereco/{idEndereco}")
	public @ResponseBody String atualizarEndereco(@PathVariable Long id, @RequestBody Endereco enderecoAtualizado,
			@PathVariable Long idEndereco) {
		enderecoAtualizado.setId(idEndereco);
		enderecoRepository.findById(idEndereco).map(endereco -> {
			if (clienteRepository.existsById(id)) {
				Cliente cliente = clienteRepository.findById(id).get();
				cliente.atualizaEndereco(enderecoAtualizado);
				enderecoRepository.save(enderecoAtualizado);
				clienteRepository.save(cliente);
				return ResponseEntity.ok().body(cliente);
			} else {
				return new ClienteNaoEncontradoException(id);
			}
		}).orElseThrow(() -> new EnderecoNaoEncontradoException(idEndereco));
		return "Endereço atualizado";
	}

	@DeleteMapping(path = "/{id}/removerEndereco/{idEndereco}")
	public @ResponseBody String removerEndereco(@PathVariable long id, @PathVariable long idEndereco) {
		enderecoRepository.findById(idEndereco).map(endereco -> {
			if (clienteRepository.existsById(id)) {
				Cliente cliente = clienteRepository.findById(id).get();
				cliente.getListaEnderecos().remove(endereco);
				enderecoRepository.delete(endereco);
				clienteRepository.save(cliente);
				return ResponseEntity.ok().body(cliente);
			} else {
				return new ClienteNaoEncontradoException(id);
			}
		}).orElseThrow(() -> new EnderecoNaoEncontradoException(idEndereco));
		return "Endereço removido";
	}
}