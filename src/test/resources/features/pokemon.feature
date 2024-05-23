Feature: Servicio de consulta de Pokémon
  Como usuario
  Quiero consultar información sobre un Pokémon
  Para conocer sus características


  @pokemon
  Scenario Outline: Consultar información de un Pokémon por nombre
    Given que el servicio de consulta de Pokémon está operativo
    When el usuario envía una solicitud para obtener información del Pokémon con nombre "<pokemon>"
    Then debería obtener el nombre del Pokémon como "<expectedName>"

    Examples:
      | pokemon   | expectedName |
      | pikachu   | Pikachu      |
      | bulbasaur | Bulbasaur    |
      | charmander| Charmander   |
