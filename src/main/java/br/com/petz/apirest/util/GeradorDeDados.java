package br.com.petz.apirest.util;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import br.com.petz.apirest.model.Endereco;
import br.com.petz.apirest.model.Genero;

public final class GeradorDeDados {
	private GeradorDeDados() {
	}

	public static Integer geraIntegerAleatorio(int minimo, int maximo) {
		return ThreadLocalRandom.current().nextInt(minimo, maximo);
	}

	private static Integer geraIntegerAleatorio(int maximo) {
		return geraIntegerAleatorio(1, maximo);
	}

	public static Genero geraGenero() {
		Integer valor = geraIntegerAleatorio(100);

		return (valor % 2 == 0) ? Genero.MASCULINO : Genero.FEMININO;
	}

	public static Endereco geraEndereco() {
		Endereco endereco1 = new Endereco("Rua São Benedito", 841, "Apto 292", "São Paulo", "SP", "04735-001");
		Endereco endereco2 = new Endereco("Alameda dos Anjos", 1000, "", "São Paulo", "SP", "01234-021");
		Endereco endereco3 = new Endereco("Rua Carlos Cardoso", 5, "Apto 20", "Rio de Janeiro", "RJ", "02157-001");
		Endereco endereco4 = new Endereco("Rua Ubatã", 461, "", "São Paulo", "SP", "04806-020");
		Endereco endereco5 = new Endereco("Avenida Paulista", 1000, "Apto 1000", "São Paulo", "SP", "01311-922");

		List<Endereco> listaEnderecos = Arrays.asList(endereco1, endereco2, endereco3, endereco4, endereco5);

		return listaEnderecos.get(geraIntegerAleatorio(listaEnderecos.size()));
	}

	public static String geraCPF() {
		List<String> listaCPFs = Arrays.asList("708.837.000-00", "552.094.890-94", "239.323.780-16", "984.631.360-87",
				"044.467.530-29");
		return listaCPFs.get(geraIntegerAleatorio(listaCPFs.size()));
	}
}
