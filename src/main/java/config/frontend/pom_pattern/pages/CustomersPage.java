package config.frontend.pom_pattern.pages;

import config.frontend.pom_pattern.utils.Utilities;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.awt.*;

public class CustomersPage extends PageObject {
    Utilities utilities;
    private static final int DEFAULT_WAIT_TIME = 5000;
    private static final String LOG_IN_USER_TEXTBOX = "siigoSignInName";
    private static final String LOG_IN_PASSWORD_TEXTBOX = "siigoPassword";
    private static final String LOG_IN_BUTTON = "siigoNext";
    private static final String LOG_IN_ERROR = "siigoError";
    private static final String HEADER_MENU_CREATE_BUTTON = "siigo-button-atom[type='button'][class='hydrated'][data-id='header-create-button']";
    private static final String HEADER_MENU_CREATE_CUSTOMER_LINK = "a[href='javascript:;'][data-value='Clientes']";
    private static final String HEADER_MENU_SHADOW_DOM = "//siigo-header-molecule";
    private static final String PAGE_HOME_TITLE = "//div[@class='menu-tab-title-label mr-10']";
    private static final String PAGE_CREATE_CUSTOMER_TITLE = "//h2[.='Crear un tercero']";
    private static final String PAGE_CUSTOMER_TITLE = "//h2[.='Perfil del tercero']";
    private static final String PAGE_CUSTOMER_STATUS ="//span[@class='text green']";
    private static final String LOADER = "#Spinner";
    private static final String TOAST_CONTAINER = "#toast-container";
    private static final String FORM_FIELD_CUSTOMER_ID_SHADOW_DOM = "//siigo-identification-input-web";
    private static final String FORM_FIELD_CUSTOMER_NAME_SHADOW_DOM = "div:nth-child(1) > siigo-textfield-web:nth-child(1)";
    private static final String FORM_FIELD_CUSTOMER_SURNAME_SHADOW_DOM = "div:nth-child(2) > siigo-textfield-web:nth-child(1)";
    private static final String FORM_FIELD_CUSTOMER_CITY_SHADOW_DOM = "[key-id='city']";
    private static final String FORM_FIELD_CUSTOMER_ID_TEXTBOX = ".mdc-text-field__input.input-identification";
    private static final String FORM_FIELD_CUSTOMER_NAME_TEXTBOX = "input[class='mdc-text-field__input']";
    private static final String FORM_FIELD_CUSTOMER_SURNAME_TEXTBOX = "input[class='mdc-text-field__input']";
    private static final String FORM_FIELD_CUSTOMER_CITY_TEXBOX = ".autocompleteContainer";
    private static final String FORM_FIELD_CUSTOMER_CITY_AUTOCOMPLETE = "#divTDAutocompletecity1";
    private static final String FORM_PAGE_CREATE_CUSTOMER_SAVE_BUTTON = "//button[normalize-space()='Guardar']";

    @FindBy(id = LOG_IN_USER_TEXTBOX)
    WebElementFacade logInUserTextbox;

    @FindBy(id = LOG_IN_PASSWORD_TEXTBOX)
    WebElementFacade logInPasswordTextbox;

    @FindBy(id = LOG_IN_BUTTON)
    WebElementFacade logInButton;

    @FindBy(id = LOG_IN_ERROR)
    WebElementFacade logInError;

    @FindBy(css = LOADER)
    WebElementFacade loader;

    @FindBy(css = TOAST_CONTAINER)
    WebElementFacade toastContainer;

    @FindBy(xpath = HEADER_MENU_SHADOW_DOM)
    WebElementFacade headerMenuShadowDom;

    @FindBy(xpath = FORM_FIELD_CUSTOMER_ID_SHADOW_DOM)
    WebElementFacade formFieldCustomerIdShadowDom;

    @FindBy(css = FORM_FIELD_CUSTOMER_NAME_SHADOW_DOM)
    WebElementFacade formFieldCustomerNameTextboxShadowDom;

    @FindBy(css = FORM_FIELD_CUSTOMER_SURNAME_SHADOW_DOM)
    WebElementFacade formFieldCustomerSurnameTextboxShadowDom;

    @FindBy(css = FORM_FIELD_CUSTOMER_CITY_SHADOW_DOM)
    WebElementFacade formFieldCustomerCityShadowDom;

    @FindBy(xpath = FORM_PAGE_CREATE_CUSTOMER_SAVE_BUTTON)
    WebElementFacade formPageCreateCustomerSaveButton;

    @FindBy(xpath = PAGE_CREATE_CUSTOMER_TITLE)
    WebElementFacade pageCreateCustomerTitle;

    @FindBy(xpath = PAGE_CUSTOMER_TITLE)
    WebElementFacade pageCustomerTitle;

    @FindBy(xpath = PAGE_CUSTOMER_STATUS)
    WebElementFacade pageCustomerStatus;

    @FindBy(xpath = PAGE_HOME_TITLE)
    WebElementFacade pageHomeTitle;


    public void waitResultsPage(){
        waitABit(DEFAULT_WAIT_TIME);
        loader.waitUntilNotVisible();
    }

    public void waitResultsPage(int time){
        waitABit(time);
        loader.waitUntilNotVisible();
    }

    public void LogInPage(String user, String password) {
        waitResultsPage(10000);
        logInUserTextbox.sendKeys(user);
        logInPasswordTextbox.sendKeys(password);
        logInButton.click();
    }

    public void ClickOnMenuCreateButton() {
        WaitDashboardPageDisplayed();
        WebElement headerMenuCreateButton = headerMenuShadowDom.getShadowRoot()
                .findElement(By.cssSelector(HEADER_MENU_CREATE_BUTTON));
        headerMenuCreateButton.click();
    }

    public void ClickOnMenuCreateCustomerLink() {
        waitResultsPage();
        WebElement headerMenuCreateCustomerLink = headerMenuShadowDom.getShadowRoot()
                .findElement(By.cssSelector(HEADER_MENU_CREATE_CUSTOMER_LINK));
        headerMenuCreateCustomerLink.click();
    }

    public void WaitDashboardPageDisplayed() {
        waitResultsPage(15000);
        headerMenuShadowDom.waitUntilVisible();
        pageHomeTitle.waitUntilVisible();
        pageHomeTitle.isDisplayed();
    }

    public void WaitCreateCustomerPageDisplayed() {
        waitResultsPage(10000);
        pageCreateCustomerTitle.waitUntilVisible();
        pageCreateCustomerTitle.isDisplayed();
    }

    public void WaitCustomerPageDisplayed() {
        waitResultsPage();
        pageCustomerTitle.waitUntilVisible();
        pageCustomerTitle.isDisplayed();
    }

    public void WaitCreateCustomerMessageDisplayed() {
        waitResultsPage(100);
        toastContainer.waitUntilVisible();
        toastContainer.isDisplayed();
    }

    public void CreateCustomer(String id, String names, String surnames, String city) throws AWTException {
        WaitCreateCustomerPageDisplayed();

        if(id.equals("random")){
            id = utilities.generarAleatoriosNumeros(10);
        }

        //Identificación - campo
        WebElement formCreateCustomerIdTextbox = formFieldCustomerIdShadowDom.getShadowRoot()
                .findElement(By.cssSelector(FORM_FIELD_CUSTOMER_ID_TEXTBOX));
        formCreateCustomerIdTextbox.sendKeys(id);
        //Nombres- campo
        WebElement formCreateCustomerNameTextbox = formFieldCustomerNameTextboxShadowDom.getShadowRoot()
                .findElement(By.cssSelector(FORM_FIELD_CUSTOMER_NAME_TEXTBOX));
        formCreateCustomerNameTextbox.sendKeys(names);
        //Apellidos - campo
        WebElement formCreateCustomerSurnameTextbox = formFieldCustomerSurnameTextboxShadowDom.getShadowRoot()
                .findElement(By.cssSelector(FORM_FIELD_CUSTOMER_SURNAME_TEXTBOX));
        formCreateCustomerSurnameTextbox.sendKeys(surnames);
        //Ciudad - campo
        Actions actions = new Actions(getDriver());
        WebElement elemento = formFieldCustomerCityShadowDom.getShadowRoot()
                .findElement(By.cssSelector(FORM_FIELD_CUSTOMER_CITY_TEXBOX));
        actions.moveToElement(elemento).click().sendKeys(city).build().perform();
        //Ciudad - Autocompletar
        formFieldCustomerCityShadowDom.getShadowRoot()
                .findElement(By.cssSelector(FORM_FIELD_CUSTOMER_CITY_AUTOCOMPLETE))
                .click();
        //Guardar - botón
        formPageCreateCustomerSaveButton.click();
    }

    public void ValidateDashboardPageDisplayed(String expectedTitle) {
        WaitDashboardPageDisplayed();
        String titlePage = String.valueOf(pageHomeTitle.getTextContent()).trim();
        Assert.assertEquals(expectedTitle, titlePage);
        Assert.assertTrue(pageHomeTitle.isDisplayed());
    }

    public void ValidateCreateCustomerPageDisplayed(String expectedTitle) {
        String titlePage = String.valueOf(pageCreateCustomerTitle.getTextContent()).trim();
        Assert.assertEquals(expectedTitle, titlePage);
        Assert.assertTrue(pageCreateCustomerTitle.isDisplayed());
    }

    public void ValidateCreateCustomerMsg(String ExpectedMsg) {
        WaitCreateCustomerMessageDisplayed();
        String result = String.valueOf(toastContainer.getTextContent()).trim();
        Assert.assertTrue(result.contains(ExpectedMsg));
    }

    public void ValidateCreateCustomerStatus(String expectedStatus) {
        WaitCustomerPageDisplayed();
        String result = String.valueOf(pageCustomerStatus.getTextContent()).trim();
        Assert.assertEquals(expectedStatus, result);
        Assert.assertTrue(pageCustomerStatus.isDisplayed());
    }

    public void ValidateLogInPageErrorDisplayed(String expectedMsg) {
        waitResultsPage();
        String result = String.valueOf(logInError.getTextContent()).trim();
        Assert.assertEquals(expectedMsg, result);
        Assert.assertTrue(logInError.isDisplayed());
    }
}
