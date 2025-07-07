package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    // Constructor to receive WebDriver
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Logout button locator
    By logoutLink = By.linkText("Log Out");

    // Method to click logout
    public void clickLogout() {
        driver.findElement(logoutLink).click();
    }

    // Optional: verify logout by checking the login page appeared again
    public boolean isAtLoginPage() {
        return driver.getTitle().contains("ParaBank");
    }
}
