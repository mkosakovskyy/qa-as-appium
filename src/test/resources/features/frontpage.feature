@frontpage-feature
Feature: Front page scenarios

  Scenario: Carga de Contenido publicitarios Portada
    When El usuario accede a la portada de la aplicacion
    Then Aparece el elemento publicitario INTER con tamaño 1:1
    When El usuario cierra el elemento publicitario INTER
    Then La portada carga por completo
    And Aparece el elemento publicitario MLDB1
    And Aparece el elemento publicitario MPU1 con su tamaño correspondiente
