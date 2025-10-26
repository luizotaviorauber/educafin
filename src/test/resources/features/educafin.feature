Feature: Gestão de usuários e metas financeiras no EducaFin
Como plataforma EducaFin
Eu quero garantir que as rotas de usuário e metas funcionem corretamente
Para assegurar que o comportamento atenda os requisitos de negócio

  Background:
    * url 'http://localhost:8080'

  Scenario: Cadastro de um novo usuário com dados válidos
    Given path 'usuarios'
    And request
      """
      {
        "nome": "Luiz Otávio Rauber",
        "email": "luiz.automated@test.com",
        "senha": "SenhaForte123"
      }
      """
    When method post
    Then status 200
    And match response.id != null
    And match response.nome == "Luiz Otávio Rauber"
    And match response.email == "luiz.automated@test.com"
    # Extra: o backend devolve também senha e dataNascimento
    And match response contains { senha: "#string" }

  Scenario: Cadastrar dois usuários com o mesmo e-mail
    # 1º cadastro
    Given path 'usuarios'
    And request
      """
      {
        "nome": "Usuário Original",
        "email": "duplicado@test.com",
        "senha": "123456"
      }
      """
    When method post
    Then status 200
    And match response.id != null
    And def primeiroId = response.id

    # 2º cadastro com MESMO e-mail
    Given path 'usuarios'
    And request
      """
      {
        "nome": "Outro Nome",
        "email": "duplicado@test.com",
        "senha": "abcdef"
      }
      """
    When method post
    Then status 200
    And match response.id != null
    And def segundoId = response.id

    # validando que hoje o sistema NÃO bloqueia duplicidade de e-mail
    And match primeiroId != segundoId

  Scenario: Criar meta financeira para um usuário existente (BUG conhecido)
    # cria usuário e guarda o id
    Given path 'usuarios'
    And request
      """
      {
        "nome": "Usuario Meta",
        "email": "usuario.meta@test.com",
        "senha": "abc123"
      }
      """
    When method post
    Then status 200
    And def usuarioId = response.id

    # tenta criar meta para esse usuário
    Given path 'metas'
    And request
      """
      {
        "usuarioId": "#(usuarioId)",
        "titulo": "Guardar para emergência",
        "valorObjetivo": 1500.00,
        "dataLimite": "2025-12-31"
      }
      """
    When method post
    Then status 201
    And match response.usuarioId == usuarioId
    And match response.titulo == "Guardar para emergência"
    And match response.valorObjetivo == 1500.00
    And match response.status == "EM_ANDAMENTO"
