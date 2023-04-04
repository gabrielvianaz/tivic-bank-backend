# TIVIC Bank (Back-end)

Projeto desenvolvido para um processo seletivo da [TIVIC](https://www.tivic.com.br), o qual consiste em uma API para realização de operações bancárias.

## 🚀 Tecnologias utilizadas

- Java 17
- Spring Boot 3
- Spring Security 6
- PostgreSQL

## 🔧 Instalação

Clone o repositório e execute o comando para instalar todas as dependências do projeto

```bash
mvn clean package
```

Configure as variáveis de ambiente

```bash
DB_URL
DB_USERNAME
DB_PASSWORD
JWT_SECRET
```

Para iniciar a aplicação

```bash
mvn spring-boot:run
```

## 🛠️ Endpoints

- ### POST /clientes/pf (Cadastrar Cliente Pessoa Física)

```
{
	"email": "email@email.com",
	"senha": "123456",
	"telefone": "77999999999",
	"cpf": "12345678900",
	"nome": "João da Silva",
	"dataNascimento": "01/01/1950"
}
```

- ### POST /clientes/pj (Cadastrar Cliente Pessoa Jurídica)

```
{
	"email": "email@email.com",
	"senha": "123456",
	"telefone": "77999999999",
	"cnpj": "1234567890123",
	"razaoSocial": "Empresa LTDA",
	"nomeFantasia": "Empresa",
	"dataFundacao": "01/06/2007"
}
```

- ### POST /login (Login - Retorna token JWT)

```
{
  "email": "email@email.com",
  "senha": "senha"
}
```

- ### POST /operacoes/depositar (Depositar - Autenticado com token JWT)

```
{
  "valor": 1000
}
```

- ### POST /operacoes/sacar (Sacar - Autenticado com token JWT)

```
{
  "valor": 1000
}
```

- ### POST /operacoes/transferir (Transferir - Autenticado com token JWT)

```
{
  "valor": 1000,
  "contaDestino": {
    "tipo": "PF",
    "id": 2
  }
}
```

- ### GET /conta (Dados da própria conta - Autenticado com token JWT)
- ### GET /conta/operacoes?page={page} (Operações da própria conta - Autenticado com token JWT)
- ### GET /contas/{id} (Dados de outra conta para exibir informações na operação de transferência - Autenticado com token JWT)
- ### GET /validartoken (Validar token - Autenticado com token JWT)
