package config.frontend.pom_pattern.steps;

import config.frontend.pom_pattern.pages.CustomersPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.PageObject;

import java.awt.*;

public class CustomersSteps extends PageObject{
    CustomersPage customersPage;

    @Step
    public void OpenHomePageLogin()  {
        customersPage.open();
    }

    public void doLogIn(String user, String pass) {
        customersPage.LogInPage(user, pass);
    }

    public void goToCreateCustomerPage(String term) {
        customersPage.ClickOnMenuCreateButton();
        customersPage.ClickOnMenuCreateCustomerLink();
        customersPage.ValidateCreateCustomerPageDisplayed(term);
    }

    public void doCreateCustomer() throws AWTException {
        //customersPage.CreateCustomer();
    }

    public void doCreateCustomer(String id, String names, String surnames, String city) throws AWTException {
        customersPage.CreateCustomer(id,names,surnames,city);
    }

    public void shouldSeeDashboardPage(String ExpectedMsg) {
        customersPage.ValidateDashboardPageDisplayed(ExpectedMsg);
    }

    public void shouldSeeCreateCustomerMsg(String ExpectedMsg) {
        customersPage.ValidateCreateCustomerMsg(ExpectedMsg);
    }

    public void shouldSeeCreateCustomerStatus(String expectedStatus) {
        customersPage.ValidateCreateCustomerStatus(expectedStatus);
    }

    public void shouldSeeLogInError(String expectedMsg) {
        customersPage.ValidateLogInPageErrorDisplayed(expectedMsg);
    }
}
