package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UpdateContactInfoPage {

    private WebDriver driver;

    private By updateContactLink = By.linkText("Update Contact Info");

    private By firstNameField = By.id("customer.firstName");
    private By lastNameField = By.id("customer.lastName");
    private By addressField = By.id("customer.address.street");
    private By cityField = By.id("customer.address.city");
    private By stateField = By.id("customer.address.state");
    private By zipCodeField = By.id("customer.address.zipCode");
    private By phoneNumberField = By.id("customer.phoneNumber");

    private By updateProfileButton = By.cssSelector("input[value='Update Profile']");
    private By updateConfirmation = By.xpath("//h1[contains(text(), 'Profile Updated')]");

    public UpdateContactInfoPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToUpdateContactPage() {
        driver.findElement(updateContactLink).click();
    }

    public void updateContactInfo(String firstName, String lastName, String address,
                                  String city, String state, String zipCode, String phoneNumber) {
        driver.findElement(firstNameField).clear();
        driver.findElement(firstNameField).sendKeys(firstName);

        driver.findElement(lastNameField).clear();
        driver.findElement(lastNameField).sendKeys(lastName);

        driver.findElement(addressField).clear();
        driver.findElement(addressField).sendKeys(address);

        driver.findElement(cityField).clear();
        driver.findElement(cityField).sendKeys(city);

        driver.findElement(stateField).clear();
        driver.findElement(stateField).sendKeys(state);

        driver.findElement(zipCodeField).clear();
        driver.findElement(zipCodeField).sendKeys(zipCode);

        driver.findElement(phoneNumberField).clear();
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }

    public void submitUpdate() {
        driver.findElement(updateProfileButton).click();
    }

    public boolean isUpdateSuccessful() {
        return driver.findElements(updateConfirmation).size() > 0;
    }
}
