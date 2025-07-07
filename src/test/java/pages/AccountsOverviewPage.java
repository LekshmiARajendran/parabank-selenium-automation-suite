package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountsOverviewPage {

    private WebDriver driver;

    private By accountsTable = By.id("accountTable"); // adjust this if needed

    public AccountsOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isAccountOverviewDisplayed() {
        return driver.findElement(By.id("accountTable")).isDisplayed();
    }
}
