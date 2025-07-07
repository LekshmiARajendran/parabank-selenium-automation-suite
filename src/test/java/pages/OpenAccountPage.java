package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class OpenAccountPage {

    private WebDriver driver;

    private By accountTypeDropdown = By.id("type");
    private By fromAccountDropdown = By.id("fromAccountId");
    private By openNewAccountBtn = By.cssSelector("input.button");
    private By newAccountIdLink = By.id("newAccountId");

    public OpenAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectAccountType(String type) {
        Select select = new Select(driver.findElement(accountTypeDropdown));
        select.selectByVisibleText(type);
    }

    public void selectFromAccountByIndex(int index) {
        Select select = new Select(driver.findElement(fromAccountDropdown));
        select.selectByIndex(index);
    }

    public void clickOpenNewAccount() {
        driver.findElement(openNewAccountBtn).click();
    }

    public void clickOnNewAccountId() {
        driver.findElement(newAccountIdLink).click();
    }

    public String getNewAccountId() {
        return driver.findElement(newAccountIdLink).getText();
    }
}
