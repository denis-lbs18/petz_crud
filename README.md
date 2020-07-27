# Petz Online CRUD Teste EndPoint (petz_crud)

## Sobre
Este projeto utiliza WebServices feitos em Spring-boot, criando uma API REST. 

## Especificações de sistema:

* Java 1.8
* GIT (https://git-for-windows.github.io/) 
* Eclipse 
* Maven


## Clonando projeto do git

Abra um prompt do gitbash e digite o seguinte comando:

```sh
	git clone https://github.com/denis-lbs18/petz_crud.git
```

## Configurações de execução

Crie as variáveis de ambiente necessárias para a execução do projeto, preenchendo os valores recebidos por e-mail:


```sh
	MYSQL_HOST
	MYSQL_PORT	
	MYSQL_USER
	MYSQL_PASSWORD
```

Ao iniciar a aplicação, haverá um método main na classe ApirestApplication, que preencherá alguns dados fictícios, e iniciará a aplicação.


```sh
    Run as > Java Application (Alt + Shift + X, J)
```

## Lista de todos os métodos do endpoint

### URL Base

- http://localhost:8080/petz_crud

### Cliente

- **listarTodos**: Método GET, lista todos os clientes. Localização do endpoint:

	http://localhost:8080/petz_crud/clientes/listarTodos
	
- **listar por id**: Método GET, exibe um único cliente com parâmetro ID. Localização do endpoint:

	http://localhost:8080/petz_crud/clientes/{id}

- **adicionar**: Métdodo POST Method, cadastra um cliente. Localização do endpoint: 

	http://localhost:8080/petz_crud/clientes/adicionar
	
- **remover**: Método DELETE, remove um cliente. Localização do endpoint: 

	http://localhost:8080/petz_crud/clientes/{id}
	
- **atualizar**: Método PUT, atualiza um cliente. Localização do endpoint: 

	http://localhost:8080/petz_crud/clientes/atualizar/{id}

- **adicionarEndereco**: Método POST, adiciona um endereço em um cliente. Localização do endpoint: 

	http://localhost:8080/petz_crud/clientes/{id}/adicionarEndereco
	
- **atualizarEndereco**: Método PUT, atualiza um endereço em um cliente. Localização do endpoint: 

	http://localhost:8080/petz_crud/clientes/{id}/atualizarEndereco/{idEndereco}
	
- **removerEndereco**: Método DELETE, remove um endereço em um cliente. Localização do endpoint: 

	http://localhost:8080/petz_crud/clientes/{id}/removerEndereco/{idEndereco}
	
- **adicionarPet**: Método POST, adiciona um Pet em um cliente. Localização do endpoint: 

	http://localhost:8080/petz_crud/clientes/{id}/removerEndereco/{idEndereco}
	
- **adicionarPetPorId**: Método POST, adiciona um Pet existente na base, em um cliente. Localização do endpoint: 

	http://localhost:8080/petz_crud/clientes/{id}/adicionarPetPorId/{idPet}
	
- **removerPet**: Método DELETE, remove um Pet em um cliente. Localização do endpoint:

	http://localhost:8080/petz_crud/clientes/{id}/removerPet/{idPet}
	
### Pet

- **listarTodos**: Método GET, lista todos os pets. Localização do endpoint:

	http://localhost:8080/petz_crud/pets/listarTodos
	
- **listar por id**: Método GET, exibe um único Pet com parâmetro ID. Localização do endpoint:

	http://localhost:8080/petz_crud/pets/{id}

- **adicionar**: Métdodo POST Method, cadastra um Pet. Localização do endpoint: 

	http://localhost:8080/petz_crud/pets/adicionar
	
- **remover**: Método DELETE, remove um Pet. Localização do endpoint: 

	http://localhost:8080/petz_crud/pets/{id}
	
- **atualizar**: Método PUT, atualiza um Pet. Localização do endpoint: 

	http://localhost:8080/petz_crud/pets/atualizar/{id}