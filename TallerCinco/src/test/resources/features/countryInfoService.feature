Feature: servicio soap country info

  Scenario Outline: Busqueda de codigo ISO pais
    Given el usuario quiere buscar el pais "<pais>"
    When hace la peticion de buscar pais por nombre
    Then deberia obtener un codigo de respuesta 200
    Then  deberia observar el codigo ISO del pais "<codigo>"
    Examples:
      | pais     |  codigo  |
      | Colombia |  CO      |
      | Brazil   |  BR      |


    @casoTelefono
  Scenario Outline: Busqueda de codigo de telefono pais pais
    Given el usuario quiere buscar el pais "<pais>" con "<codigo>"
    When hace la peticion de buscar codigo de pais
    Then deberia obtener un codigo de respuesta 200
    Then  deberia observar el codigo de telefono del pais "<telefono>"
    Examples:
      | pais     | codigo | telefono |
      | Colombia | CO     | 57       |
      | Brazil   | BR     | 55       |