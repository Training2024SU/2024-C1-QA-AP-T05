Feature: Servicio Place holder

  @RutaFeliz
  Scenario Outline: Solicitud de comments
    Given el usuario tiene acceso al servicio de place holder
    When envia una peticion de tipo get al recurso "<recurso>"
    Then deberia obtener un codigo de respuesta 200
    And deberia observar que todos los objetos tienen id
    Examples:
      | recurso         |
      | posts/1/comments|
      #| users/1/posts   |

  @RutaFeliz2
  Scenario Outline: Post a publication
    Given el usuario tiene acceso al servicio de place holder
    When envia una peticion de tipo post al recurso con la siguiente informacion <title> y con body <body>
    Then deberia obtener un codigo de respuesta 201
    And should see the posts with an id generated and the same data
    Examples:
      | title             | body                    |
      | "este es el titulo" | "este es el cuerpo" |



