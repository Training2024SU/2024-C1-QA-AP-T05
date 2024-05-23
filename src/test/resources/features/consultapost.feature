Feature: Servicio de Consulta de Posts
  Yo como usuario
  Quiero consultar información sobre posts
  Para ver detalles de los posts

  @Posts
  Scenario Outline: Obtener un post por ID
    Given que el servicio de consulta de posts está operativo
    When el usuario envía una solicitud para obtener el post con ID "<postId>"
    Then debería obtener el título del post como "<title>"

    Examples:
      | postId | title                                                                      |
      | 1      | sunt aut facere repellat provident occaecati excepturi optio reprehenderit |
      | 2      | qui est esse                                                               |
      | 3      | ea molestias quasi exercitationem repellat qui ipsa sit aut                |
      | 4      | eum et est occaecati                                                       |
