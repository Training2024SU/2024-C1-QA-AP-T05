Feature:  pruebas de servicio soap
  yo como usuario del sistema
  quiero probar un servicio de tipo soap
  para realizar operaciones aritmeticas

  @soapservice
  Scenario: pruebas de suma
    Given que el es usuario quiere sumar 10 con el numero 5
    When hace la peticion de suma
    Then deberia obtener el resultado de 15