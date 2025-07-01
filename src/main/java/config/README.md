### Application code

These packages generally contain application code.
If you are writing a reusable test library, you can also place reusable test components such as Page Objects or Tasks here.

# AutomatizacionPruebas patron POM
- Proyecto para la construcción de escenarios transversales automatizados.
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
      files                                    //Contiene los archivos que son usados como insumo para la ejecución de las pruebas (ejemplo: scripts).
      webdriver                                //Directorio para almacena los Webdriver por cada sistema operativo.
        linux
        windows
          chromedriver.exe                     //Binario del Webdriver para el OS específico
          serenity.conf                        //Archivo de configuración de Serenity y variables por ambientes.                             Archivo de configuración de Serenity
pom.xml
```

## Plugins Requeridos en IntelliJ:
Para el correcto uso del proyecto, se recomienda utilizar la versión de IntelliJ IDEA 2025.1.3 Community Edition en esta se debe adicionar los siguientes plugins:
* Gherkin
* Serenity and Cucumber
* Lombok
* Karate API Testing
* HOCON

> **Nota**:
>
> - Recuerde que en la herramienta de IntelliJ se puede hacer uso de la siguiente ruta para revisar los plugin instalados:
    >
    >       File >> Settings >> Plugins >> Pestaña Installed
>
> - Y para instalar un plugin requerido recuerde ir al repositorio de plugins:
    >
    >       File >> Settings >> Plugins >> Pestaña Marketplace

## Ejecutando los Test

Corra ```mvn test clean serenity:agreggate``` desde la linea de comandos

> **Nota**:
>
> - Por defecto, los test correran usando Chrome. 
> - El resultado de los test será almacenado aquí `target/site/serenity/index.html`
    >
    >  Un ejemplo completo del reporte de pruebas, luce de la siguiente forma:


## Otras configuraciones
Toda las configuraciones para la ejecución de las pruebas mencionadas a continuación se encuentran en el archivo `test/resources/serenity.conf`.

### Configuración del Webdriver
La configuración para correr las pruebas en local y otras propiedades del explorador están definidas en dicho archivo.
## WebDriver simplificado configuration and other Serenity extras
Por defecto no se requiere especificar webDriver, Serenity se encarga de autodescargarlo

El proyecto permite incluir el WebDriver que se necesita para correr las pruebas, y se encuentran en el directorio `src/test/resources/webdriver`.

Esta configuración significa que las máquinas locales y los servidores de compilación no necesitan tener instalada una versión particular de los controladores WebDriver para que las pruebas se ejecuten correctamente.
```
### Configuración específica de ambiente
Los entornos inviduales de la aplicación se configuran en dicho archivo, de modo que las pruebas se puedan ejecutar en diferentes entornos.
La ruta individual de una página también se externaliza para facilitar la gestión de la navegación directa de dicha página.

```
```
environments {
    default {
    webdriver.base.url = "https://qastaging.siigo.com/#/login"
    }
    staging {
    webdriver.base.url = "https://qastaging.siigo.com/#/login"
    }
}
```
## Librerías Utilizadas
- [Lombok](https://projectlombok.org/features/all) - Para reducir el código repetitivo en las clases DTO y aumentar la legibilidad.