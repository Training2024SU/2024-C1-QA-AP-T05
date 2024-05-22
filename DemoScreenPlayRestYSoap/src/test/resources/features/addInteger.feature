Feature: Add Integer servicios soap
  Yo como usuario de la pagina
  quiero poder realizar operaciones
  para interactuar con los servcicios


  Scenario: Prueba Add Integer
    Given que el usuario desea sumar el integer1 1 con el integer2 1
    When envia una peticion de add integer
    Then deberia obtener el total de 2
