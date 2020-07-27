package br.com.petz.petz_crud.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import br.com.petz.petz_crud.model.Endereco;
import br.com.petz.petz_crud.model.Especie;
import br.com.petz.petz_crud.model.Genero;
import br.com.petz.petz_crud.model.Pet;

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

	public static List<Pet> geraListaPets() {
		Pet pet01 = new Pet("Pet 1", 1, Especie.CACHORRO, "Vira-lata", Genero.MASCULINO);
		Pet pet02 = new Pet("Pet 2", 2, Especie.GATO, "Vira-lata", Genero.MASCULINO);
		Pet pet03 = new Pet("Pet 3", 3, Especie.PAPAGAIO, "", Genero.MASCULINO);
		Pet pet04 = new Pet("Pet 4", 4, Especie.TARTARUGA, "Cágado", Genero.MASCULINO);
		Pet pet05 = new Pet("Pet 5", 5, Especie.CACHORRO, "Beagle", Genero.FEMININO);
		Pet pet06 = new Pet("Pet 6", 6, Especie.GATO, "Siamês", Genero.FEMININO);
		Pet pet07 = new Pet("Pet 7", 7, Especie.TARTARUGA, "Galápagos", Genero.FEMININO);
		Pet pet08 = new Pet("Pet 8", 8, Especie.PAPAGAIO, "", Genero.FEMININO);
		Pet pet09 = new Pet("Pet 9", 9, Especie.CACHORRO, "Shiba", Genero.MASCULINO);
		Pet pet10 = new Pet("Pet 10", 10, Especie.GATO, "Persa", Genero.FEMININO);

		List<Pet> listaPets = Arrays.asList(pet01, pet02, pet03, pet04, pet05, pet06, pet07, pet08, pet09, pet10);

		List<Pet> listaRetorno = new ArrayList<>();

		for (Pet pet : listaPets) {
			if (geraIntegerAleatorio(100) % 2 == 0) {
				listaRetorno.add(pet);
			}
		}
		return listaRetorno;
	}
}
