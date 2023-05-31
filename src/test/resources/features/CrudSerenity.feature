Feature: Llamar las peticiones get,post,put y delete
  Yo como usuario quiere saber si las peticiones devuelven el estado correcto

  @peticionGet @peticionesAll
  Scenario: Petición GET
    Given que como "usuario" realizo una solicitud GET
    Then valido el status code 200
    And valido el contenidos

  @SimplePost
  Scenario: Generar simple post
    Given que realizo una solicitud POST
    Then valido el status code 201

  @CreacionUsuario @peticionesAll
  Scenario: Creacion usuario POST
    Given creo un usuario con nombre "hervin" y trabajo "QA Automation"
    Then valido el status code 201
    And valido el codigo generado

  @peticionPut @peticionesAll
  Scenario: Petición PUT
    Given que realizo una solicitud PUT
    Then valido el status code 200

  @peticionDelete @peticionesAll
  Scenario: Petición Delete
    Given que realizo una solicitud Delete
    Then valido el status code 204 del delete

