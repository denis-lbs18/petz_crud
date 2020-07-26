package br.com.petz.apirest;

import java.util.stream.LongStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.petz.apirest.model.Cliente;
import br.com.petz.apirest.repository.ClienteRepository;
import br.com.petz.apirest.util.GeradorDeDados;

@SpringBootApplication
public class ApirestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApirestApplication.class, args);
	}

	@Bean
	CommandLineRunner init(ClienteRepository clienteRepository) {
		return args -> {
			clienteRepository.deleteAll();
			LongStream.range(1, 4).mapToObj(i -> {
				Cliente c = new Cliente();
				c.setNome("Cliente " + i);
				c.setEmail("cliente" + i + "@email.com");
				c.setGenero(GeradorDeDados.geraGenero());
				c.adicionaEndereco(GeradorDeDados.geraEndereco());
				c.setIdade(GeradorDeDados.geraIntegerAleatorio(18, 75));
				c.setCpf(GeradorDeDados.geraCPF());
				return c;
			}).map(v -> clienteRepository.save(v)).forEach(System.out::println);
		};
	}
}
