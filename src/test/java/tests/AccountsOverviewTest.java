package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountsOverviewPage;
import pages.LoginPage;

public class AccountsOverviewTest extends BaseTest {

    @Test
    public void testAccountsOverviewPage() {
        // Step 1: Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("john", "demo");

        // Step 2: Navigate to Accounts Overview and validate
        AccountsOverviewPage accountsPage = new AccountsOverviewPage(driver);
        assert accountsPage.isAccountOverviewDisplayed() : "Accounts Overview Page not visible";
        System.out.println("✅ Accounts Overview Page is displayed successfully.");
    }
}
