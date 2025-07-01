Feature: Prueba usando Karate para el envio de solicitudes POST, GET, PUT y DELETE
  Yo como analista de QA
  Quiero enviar peticiones api-rest
  Para validarlos como prueba técnica

  Background:
    * configure headers = {Token:'100001'}

  @GET @Backend @Regresion
  Scenario: Validar que el tiempo de respuesta del servicio sea menor a 2000
    Given url "https://reqres.in/api/users/9"
    And request {"name": "morpheus","job": "zion resident"}
    When method patch
    And print "el tiempo de respuesta fue: " + responseTime
    Then assert responseTime < 2000

  @POST @Backend @Regresion
  Scenario: Validar que al crear un usuario se recibe un ID
    Given url "https://reqres.in/api/users"
    And def encabezados = read('../../files/jsons/posts/reqresIn_headers.json')
    And headers encabezados
    And request {"name": "juan","job": "tester"}
    When method post
    Then match response.id == '#present'

  @POST_outline @Backend @Regresion
  Scenario Outline: Validar que al crear un usuario se recibe un ID
    Given url "https://reqres.in/api/users"
    And def encabezados = read('../../files/jsons/posts/reqresIn_headers.json')
    And headers encabezados
    And def bodyRequest = read('../../files/jsons/posts/reqresIn_create_user.json')
    And bodyRequest.name = <nombre>
    When method post
    Then match response.id == '#present'

    Examples:
      | nombre            |
      | "Felipe Farias"   |
      | "Mario Castañeda" |
      | "Señor Miyagi"    |

  @PUT @Backend @Regresion
  Scenario: Validar que al actualizar un usuario el servicio nos retorna una fecha con json parcial
    Given url "https://reqres.in/api/users/9"
    And def encabezados = read('../../files/jsons/posts/reqresIn_headers.json')
    And headers encabezados
    And request {"name": "siigO","job": "QA"}
    When method put
    Then match response contains {updatedAt: '#? _ >= "2025-06-29"'}

  @PATH @Backend @Regresion
  Scenario: Validar que al actualizar un usuario el servicio PATCH nos retorna código 200
    Given url "https://reqres.in/api/users/9"
    And def encabezados = read('../../files/jsons/posts/reqresIn_headers.json')
    And headers encabezados
    And request {"name": "siigO2025","job": "Automation"}
    When method patch
    Then status 200

  @DELETE @Backend @Regresion
  Scenario: Borrar un usuario
    Given url 'https://reqres.in/api/users/9'
    And def encabezados = read('../../files/jsons/posts/reqresIn_headers.json')
    And headers encabezados
    When method Delete
    Then status 204

