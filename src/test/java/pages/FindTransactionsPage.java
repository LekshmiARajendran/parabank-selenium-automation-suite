package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FindTransactionsPage {

    private WebDriver driver;

    private By accountIdInput = By.id("accountId");
    private By findTransactionsBtn = By.xpath("//input[@value='Find Transactions']");
    private By transactionTable = By.id("transactionTable");

    public FindTransactionsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterAccountId(String accountId) {
        driver.findElement(accountIdInput).clear();
        driver.findElement(accountIdInput).sendKeys(accountId);
    }

    public void clickFindTransactions() {
        driver.findElement(findTransactionsBtn).click();
    }

    public boolean isTransactionTableVisible() {
        return driver.findElements(transactionTable).size() > 0;
    }
}
