EducaFin – Testes de API com BDD (Karate)

Este projeto realiza testes automatizados de comportamento (**Behavior Driven Development – BDD**) na **API EducaFin**, uma plataforma de educação financeira voltada para comunidades e microempreendedores.

Os testes foram desenvolvidos utilizando o **framework Karate** integrado ao **JUnit5**, validando o comportamento das rotas REST da aplicação.

---

Objetivo

Garantir que as rotas de **usuários** e **metas financeiras** da API EducaFin funcionem corretamente e atendam aos requisitos de negócio, validando cenários de sucesso, erro e integração entre entidades.

---

Tecnologias Utilizadas

- **Java 21**
- **Maven 3.9+**
- **Karate 1.4.0**
- **JUnit 5**
- **Spring Boot 3.2.5**
- **Oracle Database (FIAP)**
- **Docker e Docker Compose**
- **IntelliJ IDEA 2024.2.4**

---

Estrutura do Projeto
educafin/
├── src/
│ ├── main/
│ │ ├── java/br/com/fiap/
│ │ │ ├── controller/
│ │ │ ├── dto/
│ │ │ ├── model/
│ │ │ ├── repository/
│ │ │ ├── service/
│ │ │ └── EducaFinApiApplication.java
│ │ └── resources/
│ └── test/
│ ├── java/br/com/fiap/EducaFinRunnerTest.java
│ └── resources/features/educafin.feature
│
├── Dockerfile
├── docker-compose.yml
├── pom.xml
└── README.md
---

 Como Executar os Testes

1. Pré-requisitos

Certifique-se de ter instalado:

- [Java JDK 21+](https://www.oracle.com/java/technologies/downloads/)
- [Maven](https://maven.apache.org/download.cgi)
- [Docker Desktop](https://www.docker.com/)
- [IntelliJ IDEA](https://www.jetbrains.com/idea/)

2. Rodar a API EducaFin

docker-compose up -d

A aplicação subirá em:

http://localhost:8080

3. Executar os Testes Karate

Execute no IntelliJ IDEA (botão de Run) ou via terminal:

mvn test

Estrutura de Testes (BDD)

Os cenários estão descritos em formato Gherkin dentro do arquivo:

src/test/resources/features/educafin.feature

Exemplos:

Cadastro de usuário

Scenario: Cadastro de um novo usuário com dados válidos
  Given path 'usuarios'
  And request
    """
    { "nome": "Luiz Otávio Rauber", "email": "luiz.automated@test.com", "senha": "SenhaForte123" }
    """
  When method post
  Then status 201
  And match response.nome == 'Luiz Otávio Rauber'

Usuário duplicado

Scenario: Falha ao cadastrar usuário com e-mail já existente
  Given path 'usuarios'
  And request
    """
    { "nome": "Outro Nome", "email": "duplicado@test.com", "senha": "abcdef" }
    """
  When method post
  Then status 409

Evidências

Os relatórios são gerados automaticamente pelo Karate após a execução dos testes:

target/karate-reports/karate-summary.html

O relatório mostra:

Total de features e cenários

Passes / Fails

Tempo de execução

Links para relatórios detalhados (Timeline, Tags, etc.)


Luiz Otávio Rauber – RM557845
Matheus de Jesus – RM555632
Gustavo Defavari – RM554984 
Henry Vega Martins - RM558057 

Análise e Desenvolvimento de Sistemas – FIAP


