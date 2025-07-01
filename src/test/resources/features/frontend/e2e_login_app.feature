#language: es
Característica: Login de la aplicación.
  Yo como analista de QA
  Quiero autenticarme en el sitio web Siigo Nube
  Para validarlos como prueba técnica

  @E2E @Frontend @LogIn @Login_Ruta_Exitosa
  Escenario: Autenticación Exitosa
    Dado que El_Tester ingresa a la página inicial de Siigo Nube
    Y El realiza la autenticación con credenciales "retoautomationsiigo@yopmail.com" , "T4b4ck0ff1c3P455w0rd658*"
    Entonces El puede visualizar la pantalla "Inicio"


  @E2E @Frontend @LogIn @Login_Ruta_Negativa
  Escenario: Autenticación Fallida
    Dado que El_Tester ingresa a la página inicial de Siigo Nube
    Y El realiza la autenticación con credenciales "retoFail@yopmail.com" , "*"
    Entonces El puede visualizar la respuesta de autenticación "Usuario o contraseña inválidos"
