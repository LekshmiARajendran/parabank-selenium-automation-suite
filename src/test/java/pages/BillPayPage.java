package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BillPayPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public BillPayPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void clickBillPayLink() {
        WebElement billPayLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Bill Pay")));
        billPayLink.click();
    }

    public void enterPayeeDetails(String name, String address, String city, String state, String zipCode,
                                  String phone, String account, String amount, String fromAccountId) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("payee.name"))).sendKeys(name);
        driver.findElement(By.name("payee.address.street")).sendKeys(address);
        driver.findElement(By.name("payee.address.city")).sendKeys(city);
        driver.findElement(By.name("payee.address.state")).sendKeys(state);
        driver.findElement(By.name("payee.address.zipCode")).sendKeys(zipCode);
        driver.findElement(By.name("payee.phoneNumber")).sendKeys(phone);
        driver.findElement(By.name("payee.accountNumber")).sendKeys(account);
        driver.findElement(By.name("verifyAccount")).sendKeys(account);
        driver.findElement(By.name("amount")).sendKeys(amount);
        new org.openqa.selenium.support.ui.Select(driver.findElement(By.name("fromAccountId"))).selectByVisibleText(fromAccountId);
    }

    public void submitBillPayment() {
        driver.findElement(By.cssSelector("input.button")).click();
    }

    public boolean isPaymentSuccessful() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Bill Payment Complete']")));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}
