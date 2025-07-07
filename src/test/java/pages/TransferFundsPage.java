package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class TransferFundsPage {
    private WebDriver driver;

    // Constructor
    public TransferFundsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to enter the amount to transfer
    public void enterAmount(String amount) {
        // Wait briefly (or use WebDriverWait in future for better control)
        try { Thread.sleep(1000); } catch (InterruptedException e) { }

        driver.findElement(By.id("amount")).sendKeys(amount);
    }

    // Method to select From Account by index
    public void selectFromAccountByIndex(int index) {
        Select fromAccount = new Select(driver.findElement(By.id("fromAccountId")));
        fromAccount.selectByIndex(index);
    }

    // Method to select To Account by index
    public void selectToAccountByIndex(int index) {
        Select toAccount = new Select(driver.findElement(By.id("toAccountId")));
        toAccount.selectByIndex(index);
    }

    // Method to click the "Transfer" button
    public void clickTransferButton() {
        driver.findElement(By.xpath("//input[@type='submit' and @value='Transfer']")).click();
    }

    // Method to check if the transfer confirmation message is displayed
    public boolean isTransferCompleteMessageDisplayed() {
        return driver.getPageSource().contains("Transfer Complete!");
    }
}
