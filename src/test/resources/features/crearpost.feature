Feature: Servicio de Creación de Posts
  Yo como usuario
  Quiero poder crear nuevas publicaciones
  Para compartir contenido con otros usuarios

  @crearPost
  Scenario: Crear una nueva publicación
    Given que el servicio de creación de posts está operativo
    When el usuario envía una solicitud para crear una nueva publicación con título "<title>" y cuerpo "<body>"
    Then la publicación debería ser creada exitosamente
