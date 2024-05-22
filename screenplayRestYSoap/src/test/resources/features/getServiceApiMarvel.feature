Feature:  probar servicios GET de la pagina api marvel
  yo como usuario de la pagina de api marvel
  quiero probar servicios de tipo get
  para obtener verificar su correcto funcionamiento

  Background:
    Given que el usuario esta en la pagina de "https://gateway.marvel.com/"

  @getListSeries
  Scenario Outline: solicitud de series
    When envia una peticion de tipo get al recurso "<recurso>"
    Then deberia obtener un codigo de respuesta <statusCode>
    And deberia obtener una lista de los comics
    Examples:
      | recurso          | statusCode |
      | v1/public/series | 200        |

  @getListPersonajesByIdComic
  Scenario Outline: solicitud de personajes por id de comics
    When realiza una peticion de tipo get al recurso "<recurso>"
    Then deberia ver un codigo de respuesta <statusCode>
    And deberia obtener una lista de personajes
    Examples:
      | recurso                        | statusCode |
      | v1/public/comics/14/characters | 200        |