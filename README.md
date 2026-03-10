# API de Cadastro de Filmes

Uma API RESTful desenvolvida em Java com Spring Boot para o gerenciamento de um catálogo de filmes. Este projeto foi construído focando em boas práticas de mercado, arquitetura em camadas e regras de negócio robustas.

## Tecnologias Utilizadas

* **Java** (Linguagem principal)
* **Spring Boot** (Framework para o backend)
* **Spring Data JPA / Hibernate** (Persistência de dados)
* **MySQL** (Banco de dados relacional)
* **Docker & Docker Compose** (Conteinerização da infraestrutura)
* **Lombok** (Redução de boilerplate)

## Arquitetura e Padrões

O projeto foi estruturado seguindo o padrão de **Arquitetura em Camadas**, garantindo a separação de responsabilidades:
* `Controller`: Gerencia as requisições HTTP e o roteamento REST.
* `Service`: Centraliza as regras de negócio e validações da aplicação.
* `Repository`: Interface de comunicação direta com o banco de dados.
* `Entity`: Mapeamento objeto-relacional (ORM) das tabelas do banco.

### Validações Implementadas
A camada de Serviço conta com validações estritas para garantir a integridade dos dados:
- Bloqueio de campos obrigatórios vazios ou nulos (Nome, Diretor, etc).
- Validação de intervalo histórico (Ano de lançamento deve ser entre 1888 e 2030).
- Tratamento de exceções para buscas ou atualizações de IDs inexistentes.

## Como Executar o Projeto

Pré-requisitos: Ter o **Java/JDK**, **Maven** e **Docker** instalados na sua máquina.

1. Clone este repositório:
   ```bash
   git clone https://github.com/pedropaes2506/CadastroDeFilmes

2. Suba o banco de dados MySQL via Docker:
   ```bash
   docker-compose up -d
   
3. Execute a aplicação na sua IDE favorita ou via linha de comando. A API estará disponível em: http://localhost:8080
   
