package config.frontend.pom_pattern.definitions;

import config.frontend.pom_pattern.steps.CustomersSteps;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.pages.PageObject;

import java.awt.*;

public class CustomersDefinitions extends PageObject {
    @Steps
    CustomersSteps customersSteps;

    @Dado("que El_Tester ingresa a la página inicial de Siigo Nube")
    public void goToHomePageLogin() {
        customersSteps.OpenHomePageLogin();
    }


    @Y("El realiza la autenticación con credenciales {string} , {string}")
    public void doLogin(String user, String pass) {
        customersSteps.doLogIn(user, pass);
    }

    @Cuando("El se direccione en pantalla de {string}")
    public void goToCreateCustomerPage(String expectedTitle) {
        customersSteps.goToCreateCustomerPage(expectedTitle);
    }

    @Y("El diligencie la información básica obligatoria {string}, {string}, {string}, {string}")
    public void doCreateCustomer(String id, String names, String surnames, String city) throws AWTException {
        customersSteps.doCreateCustomer(id,names,surnames,city);
    }

    @Entonces("El puede visualizar la pantalla {string}")
    public void el_puede_visualizar_la_pantalla(String expectedTitle) {
        customersSteps.shouldSeeDashboardPage(expectedTitle);
    }

    @Entonces("El puede visualizar en pantalla el mensaje {string}")
    public void shouldSeeCreateCustomerMsg(String expectedMsg) {
        customersSteps.shouldSeeCreateCustomerMsg(expectedMsg);
    }

    @Y("El puede visualizar el estado {string} del tercero")
    public void shouldSeeCreateCustomerState(String expectedStatus) {
        customersSteps.shouldSeeCreateCustomerStatus(expectedStatus);
    }

    @Entonces("El puede visualizar la respuesta de autenticación {string}")
    public void el_puede_visualizar_la_respuesta_de_autenticación(String expectedMsg) {
        customersSteps.shouldSeeLogInError(expectedMsg);
    }

}
