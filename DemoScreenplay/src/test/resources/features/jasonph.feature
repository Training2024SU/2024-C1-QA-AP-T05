Feature: Manejo de métodos REST
  Como usuario de la página web jsonplaceholder
  quiero crear, actualizar y eliminar información
  para aprender a consumir servicios REST

  @RutaRest
    @Ruta1
  Scenario Outline: crear un nuevo usuario
    Given el usuario está creando un nuevo usuario con el servicio de jsonplaceholder
    When ingresa la información para un nuevo usuario "<nombre>" "<nombreUsuario>" "<correo>"
    Then debería ver que obtiene el código de estado 201
    And debería ver que el id es igual a 11
    Examples:
      | nombre    | nombreUsuario | correo          |
      | Jorge     | josroga       | jorge@mail.com  |
      | Francisco | pacho         | apacho@mail.com |
      | Johan     | rolos         | johan@mail.com  |


  @RutaRest
  @Ruta2
  Scenario: Eliminar una actividad
    Given el usuario esta eliminando una actividad
    When envia una solicitud DELETE al recurso con id de usuario 2
    Then deberia obtener el código de estado 200


