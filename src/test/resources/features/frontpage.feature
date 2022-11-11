@AS @Digital
Feature: Digital (Movilidad)


  @Publicidad
  Scenario: AUT-3:CP01 - Carga de Contenido publicitarios Portada
    Given El usuario esta en la portada de la aplicacion
    Then Aparece el elemento publicitario INTER con tamaño 1:1
    When El usuario cierra el elemento publicitario INTER
    Then La portada carga por completo
    And  Aparece el elemento publicitario MLDB1 (Portada)
    And  Aparece el elemento publicitario MPU1 con su tamaño correspondiente (Portada)
