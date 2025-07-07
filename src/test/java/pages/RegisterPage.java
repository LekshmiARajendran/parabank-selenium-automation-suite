package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {

    private WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By firstNameInput = By.id("customer.firstName");
    private By lastNameInput = By.id("customer.lastName");
    private By addressInput = By.id("customer.address.street");
    private By cityInput = By.id("customer.address.city");
    private By stateInput = By.id("customer.address.state");
    private By zipCodeInput = By.id("customer.address.zipCode");
    private By phoneNumberInput = By.id("customer.phoneNumber");
    private By ssnInput = By.id("customer.ssn");
    private By usernameInput = By.id("customer.username");
    private By passwordInput = By.id("customer.password");
    private By confirmPasswordInput = By.id("repeatedPassword");
    private By registerButton = By.cssSelector("input[value='Register']");
    private By successMessage = By.cssSelector(".title");

    // Actions
    public void enterRegistrationDetails(String firstName, String lastName, String address, String city,
                                         String state, String zipCode, String phoneNumber, String ssn,
                                         String username, String password) {
        driver.findElement(firstNameInput).sendKeys(firstName);
        driver.findElement(lastNameInput).sendKeys(lastName);
        driver.findElement(addressInput).sendKeys(address);
        driver.findElement(cityInput).sendKeys(city);
        driver.findElement(stateInput).sendKeys(state);
        driver.findElement(zipCodeInput).sendKeys(zipCode);
        driver.findElement(phoneNumberInput).sendKeys(phoneNumber);
        driver.findElement(ssnInput).sendKeys(ssn);
        driver.findElement(usernameInput).sendKeys(username);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(confirmPasswordInput).sendKeys(password);
    }

    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    public String getSuccessMessage() {
        WebElement message = driver.findElement(successMessage);
        return message.getText();
    }
}
