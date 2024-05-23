Feature: Servicio de Conversión de Temperaturas
  yo como usuario
  quiero convertir temperaturas entre Celsius y Fahrenheit
  para comprender la temperatura en diferentes unidades


  @RutaFeliz
  Scenario Outline: Convertir grados Celsius a Fahrenheit
    Given que el servicio de conversión de temperaturas está operativo
    When el usuario envía una solicitud para convertir la temperatura de Celsius a Fahrenheit con un valor de "<celsius>"
    Then debería obtener la temperatura en Fahrenheit como "<fahrenheit>"

    Examples:
      | celsius | fahrenheit |
      | -10     | 14         |
      | 20      | 68         |
      | 30      | 86         |
      | 50      | 122        |