@AS @Digital
Feature: Digital (Movilidad)


  @Publicidad
  Scenario Outline: AUT-4:CP02 - Carga de Contenido publicitarios Articulo
    Given El usuario esta en el articulo "<urlarticulo>"
    And  La aplicacion carga por completo
    Then Aparece el elemento publicitario INTEXT con tamaño 1:1
    And  Aparece el elemento publicitario MLDB1
    And  Aparece el elemento publicitario MPU1 con su tamaño correspondiente
    And  Aparece el elemento publicitario MPU2 con su tamaño correspondiente
    And  Aparece el elemento publicitario MPU3 con su tamaño correspondiente
    And  Aparece el elemento publicitario BTN con su tamaño correspondiente

    Examples:
      | urlarticulo                                                       |
      | https://argentina.as.com/futbol/la-argentina-de-messi-se-rompe-n/ |