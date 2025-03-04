# Spring_Security_Swagger
## 🚀 Projeto de Autenticação com Spring Security
Este projeto é um exemplo de como implementar autenticação e autorização em uma aplicação Spring Boot utilizando Spring Security. Ele inclui funcionalidades de login, registro de usuários e gerenciamento de clientes, com controle de acesso baseado em roles (ADMIN e USER).

## 🛠️ Pré-requisitos
* Java 17: Certifique-se de ter o JDK 17 instalado.
* Maven: Para gerenciamento de dependências e build do projeto.

## 📋 Funcionalidades
### Autenticação e Autorização
* Login: Autenticação de usuários com geração de token JWT.
* Registro: Criação de novos usuários com senha criptografada.
* Controle de Acesso: Diferentes níveis de acesso para usuários ADMIN e USER.
### Gerenciamento de Clientes
* Listagem: Lista todos os clientes cadastrados.
* Cadastro: Adiciona um novo cliente.
* Atualização: Atualiza os dados de um cliente existente.
* Exclusão: Remove um cliente pelo ID.

## 🛠️ Tecnologias Utilizadas
| Tecnologia | Descrição |
| ------------- | ------------- |
| Spring Boot| Framework para desenvolvimento de aplicações Java|
|Spring Security| Framework para segurança em aplicações Spring|
|JWT (JSON Web Token)| Para autenticação stateless|
|H2 Database| Banco de dados em memória para desenvolvimento|
|Lombok| Para redução de boilerplate code|
|Swagger| Para documentação da API|

## 📂 Estrutura do Projeto
```
src
├── main
│   ├── java
│   │   └── com
│   │       └── crm
│   │           └── api
│   │               ├── controller
│   │               │   ├── AuthenticationController.java
│   │               │   └── ClienteController.java
│   │               ├── model
│   │               │   ├── AuthenticationDTO.java
│   │               │   ├── Cliente.java
│   │               │   ├── LoginResponseDTO.java
│   │               │   ├── RegisterDTO.java
│   │               │   ├── User.java
│   │               │   └── UserRole.java
│   │               ├── repository
│   │               │   ├── ClienteRepository.java
│   │               │   └── UserRepository.java
│   │               └── service
│   │                   └── ClienteService.java
│   └── resources
│       └── application.properties
└── test
    └── java
        └── com
            └── crm
                └── api
                    └── CrmApiApplicationTests.java
```
## 📄 Acesse a API:

* A aplicação estará rodando em http://localhost:8080.
* Utilize o Swagger para testar os endpoints: http://localhost:8080/swagger-ui.html.
