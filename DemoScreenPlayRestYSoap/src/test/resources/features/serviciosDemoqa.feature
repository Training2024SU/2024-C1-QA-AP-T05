Feature: Pruebas al servicio gratutito de la API de Demoqa
  Yo como usuario del servicio
  quiero poder llamar los servicios que ofrece
  para poder interactuar con la informacion que contiene

  Background:
    Given que el usuario esta en la pagina de demoqa

  @rutaFeliz
  Scenario Outline: Obtener lista de libros
    When envia una peticion de tipo GET al recurso
    Then deberia obtener un codigo de estado de la respuesta 200
    And el libro con isbn <isbn> deberia tener el title <title> y el author <author>
    Examples:
      | isbn            | title                 | author                 |
      | "9781449325862" | "Git Pocket Guide"    | "Richard E. Silverman" |
      | "9781449365035" | "Speaking JavaScript" | "Axel Rauschmayer"     |

  @rutaFeliz
  Scenario: Agregar usuario
    When ingresa un username y password, enviando una peticion GET al recurso
    Then deberia obtener un codigo de estado de la respuesta 201
    Then deberia visualizar el mismo username

  @rutaFeliz
  Scenario Outline: Eliminar usuario con usuario no autorizado
    When ingresa un UserId <userId> no autorizado enviando una peticion DELETE al recurso
    Then deberia obtener un codigo de estado de la respuesta 401
    Then deberia visualizar el mensaje de usuario no autorizado
    Examples:
    |userId  |
    |"6"     |
    |"5"     |
    |"3"     |
