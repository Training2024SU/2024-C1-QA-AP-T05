Feature:  pruebas de servicio soap
  yo como usuario del sistema
  quiero probar un servicio de tipo soap
  para obtener informacion de paises

  @codigoiso
  Scenario: prueba nombre pais segun codigo iso
    Given que el es usuario quiere ingresar el codigo "FR"
    When hace la peticion de tipo soap
    Then deberia obtener un statuscode 200