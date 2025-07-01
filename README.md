# Automatizacion co.com.siigo2025
- Proyecto con base en patron Page-Object y adaptable para Screenplay.
- El proyecto utiliza Java 8 , Serenity BDD, Cucumber 4
- Los test están escritos en formato BDD Gherkin, el cual se representa como una documentación viva en el reporte de pruebas

## La estructura de directorio del proyecto
```Gherkin
src
  main
    java
      co.com.<nombreProyecto>
        definitions                            //Contiene la definición de los pasos gherkin contenidos en el escenario de prueba (Capa de Negocio: donde se enuncia el "QUÉ" se requiere)
        exceptions                             //Contiene el manejo y/o personalización de las posibles excepciones que surjan en tiempo de ejecución. 
        models                                 //Contiene los objetos abstraídos del mundo real (Negocio) que contienen los atributos requeridos para contener los datos de prueba.
        pages                                  //Contiene el manejo de los objetos de la AOP (Aplicación Objeto de Prueba) (Capa de Interacción: donde se definen objetos y acciones para lograr el "CÓMO").
          interacciones                        //Contiene únicamente la interacción con los objetos de la AOP (Hace parte de la Capa de Interacción). Debe existir una carpeta por aplicación cuando no son comunes.
          mapeos                               //Contiene únicamente la definición / mapeo de los objetos de la AOP (Hace parte de la Capa de Interacción). Debe existir una carpeta por aplicación cuando no son comunes.
        services                               //Contiene los consumos de servicios web para construir pruebas de integración o pasos que agilicen un escenario E2E.
          api.<nombreAPI>                      //Por orden, Se crea una carpeta por cada cliente.
            impl                               //Contiene la implementación(Adaptadores) de la interfaz(Puerto) creada para la construcción del request u objetos necesarios en un consumo de servicio.
          generics                             //Contiene el cliente generico y el manejo de la respuesta de un consumo de servicio REST o SOAP.
        steps                                  //Contiene la definición del paso a paso para lograr el objetivo enunciado en el gherkin del escenario (Capa de Testing: donde se enuncia el "CÓMO" logra el objetivo).
        utils                                  //Contiene las funcionalidades transversales a cualquier escenario de prueba.
          enums                                //Contiene el listado de valores constantes que pueden ser agrupados por un tema o clasificación determinada.
  test
    java
      config.<nombreProyecto>.runners.<lineaProyecto>
        <aplicativo o frente de trabajo>
          <tipoPrueba>                         //Contiene las clases que permiten inicializar las pruebas ya sean 'pruebasintegracion' o 'pruebasaceptacion'
    resource
      data                                     //Contiene los archivos de datos de prueba.
      features                                 //Directorio para almacenar los archivos .feature
      files                                    //Contiene los archivos que son usados como insumo para la ejecución de las pruebas (ejemplo: jsons para Karate api).
          serenity.conf                        //Archivo de configuración de Serenity y variables por ambientes.                             Archivo de configuración de Serenity
pom.xml
```

# PRUEBA TÉCNICA PARA QA ENGINEER
```
2. Automatización FrontEnd:  E2E Crear clientes (tercero).

Teniendo en cuenta la funcionalidad de clientes (Terceros) del punto 1, crear una automatización de
FrontEnd

• Login de la aplicación
• Creación de un cliente. (tercero)

*Muestreo ruta features,runners y relacionados dentro del package frontend
-main
   -java.config
      -frontend.pom_pattern
       -pages
       -steps
       -utils
       README pom_pattern
   src
    -java.config
        -frontend.pom_pattern
           -definitions
           -runners
    -Resources
       -features
          -frontend
```
```
3. Automatización Backend: Verificación de Endpoints en ReqRes

Descripción:
Utilizaremos la página https://reqres.in para realizar pruebas y asegurarnos de que los EndPoints  
funcionen correctamente.

Pasos a seguir:
• Diseñe mínimo un escenario E2E o cuatro escenarios puntuales para diferentes servicios
• Utilice una herramienta para enviar solicitudes POST, GET, PUT y DELETE
• Verifique que los EndPoints responden correctamente y valide las respuestas.
    
    *Muestreo ruta features,runners y relacionados dentro del package backend
    
    src
    -java.config
       -backend
         -runners
    -Resources
       -features
          -backend
       -files.jsons.posts   

``` 

