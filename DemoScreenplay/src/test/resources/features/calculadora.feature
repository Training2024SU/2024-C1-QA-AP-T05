Feature:  pruebas de calculadora
  yo como usuario de un servicio soap
  quiero utilizar los servicios de suma y resta
  para poder sifrutar los servicios

  @suma
  Scenario: pruebas de suma
    Given que el es usuario quiere sumar 20 con el numero 15
    When hace la peticion de suma
    Then deberia obtener el resultado de 35


  @resta
  Scenario: prueba de resta
    Given que el usuario quiere restar 30 con el numero 20
    When hace la peticion de resta
    Then deberia obtener el resultado de resta 10