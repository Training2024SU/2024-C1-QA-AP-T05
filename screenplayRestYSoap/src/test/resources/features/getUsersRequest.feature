Feature: prueba del servicio GET
  yo como usuario de la pagina https://reqres.in/
  quiero probar un servicio de tipo get
  para obtener todos los usuarios

  @getUsers
  Scenario: Solicitud usuarios
    Given que el usuario se encuentra en la pagina de "https://reqres.in/"
    When manda una peticion de tipo get al recurso "api/users?page=2"
    Then deberia observar un codigo de respuesta 200
    And deberia obtener una lista de usuarios