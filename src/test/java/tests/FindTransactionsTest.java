package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.FindTransactionsPage;
import pages.LoginPage;
import utils.TestDataStore;

public class FindTransactionsTest extends BaseTest {

    @Test
    public void testFindTransactions() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("john", "demo");

        driver.get("https://parabank.parasoft.com/parabank/findtrans.htm");

        FindTransactionsPage findTransactionsPage = new FindTransactionsPage(driver);

        // Wait for the input to be ready
        Thread.sleep(1000);

        // Use the last created account ID
        String accountId = TestDataStore.lastCreatedAccountId;
        System.out.println("ℹ️ Using Account ID for search: " + accountId);

        // Fallback if no ID is available
        if (accountId == null || accountId.trim().isEmpty()) {
            accountId = "12345"; // Default fallback
            System.out.println("⚠️ No account ID found from session, using fallback: " + accountId);
        }

        findTransactionsPage.enterAccountId(accountId);
        findTransactionsPage.clickFindTransactions();

        Thread.sleep(2000); // Allow time for results to load

        assert findTransactionsPage.isTransactionTableVisible() : "Transaction table not visible!";
    }
}
