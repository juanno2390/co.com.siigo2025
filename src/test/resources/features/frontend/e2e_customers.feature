#language: es
Característica: E2E Clientes (tercero).
  Yo como analista de QA
  Quiero crear clientes terceros
  Para validarlos como prueba técnica

  Antecedentes:
    Dado que El_Tester ingresa a la página inicial de Siigo Nube
    Y El realiza la autenticación con credenciales "retoautomationsiigo@yopmail.com" , "T4b4ck0ff1c3P455w0rd658*"

  @E2E @Frontend @Create_Customer @Create_Customer_Ruta_Exitosa
  Esquema del escenario: Creación de clientes terceros rellenando solo campos obligatorios
    Cuando El se direccione en pantalla de "Crear un tercero"
    Y El diligencie la información básica obligatoria <identificación>, <nombres>, <apellidos>, <ciudad>
    Entonces El puede visualizar en pantalla el mensaje "Tercero guardado exitosamente"
    Y El puede visualizar el estado "Activo" del tercero

    Ejemplos:
      | identificación  | nombres     | apellidos         | ciudad           |
      | "random"        | "user test" | "Automation dot"  | "Rio de Janeiro" |

  @E2E @Frontend @Create_Customer @Create_Customer_Ruta_Negativa
  Esquema del escenario: Creación de clientes terceros sin rellenar campos obligatorios
    Cuando El se direccione en pantalla de "Crear un tercero"
    Y El diligencie la información básica obligatoria <identificación>, <nombres>, <apellidos>, <ciudad>
    Entonces El puede visualizar en pantalla el mensaje <ErrorMsg>

    Ejemplos:
      | identificación  | nombres     | apellidos       | ciudad     | ErrorMsg                                                     |
      | "1017846258"    | "JUan"      | "ACevedo"       | "Medellín" | "La identificación del tercero que estas creando ya existe." |
      | "1011011126"    | "Matmud"    | ""              | "Bogotá"   | "Tienes campos obligatorios sin completar."                  |
      | "0005455"       | "Veronica"  | "Yepes Garcia"  | "Medellín" | "El campo 'Identificación' no tiene un formato correcto, solo se acepta valores numéricos y valor diferente a '0' en la primera posición." |