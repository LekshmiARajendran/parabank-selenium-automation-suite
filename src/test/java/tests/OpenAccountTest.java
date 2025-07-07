package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.AccountsOverviewPage;
import pages.LoginPage;
import pages.OpenAccountPage;
import utils.TestDataStore;

public class OpenAccountTest extends BaseTest {

    @Test
    public void testOpenNewAccount() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("john", "demo");

        driver.get("https://parabank.parasoft.com/parabank/openaccount.htm");

        OpenAccountPage openAccountPage = new OpenAccountPage(driver);
        openAccountPage.selectAccountType("SAVINGS");
        openAccountPage.selectFromAccountByIndex(0);
        openAccountPage.clickOpenNewAccount();

        Thread.sleep(2000); // wait for account ID to load

        String newAccountId = openAccountPage.getNewAccountId();
        TestDataStore.lastCreatedAccountId = newAccountId; // save for other tests
        System.out.println("✅ New Account Opened: " + newAccountId);

        openAccountPage.clickOnNewAccountId();

        AccountsOverviewPage overviewPage = new AccountsOverviewPage(driver);
        assert overviewPage.isAccountOverviewDisplayed() : "Account Overview Page is not displayed";
        System.out.println("Accounts Overview Page is displayed successfully.");
    }
}
