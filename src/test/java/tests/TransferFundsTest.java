package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.TransferFundsPage;

public class TransferFundsTest extends BaseTest {

    @Test
    public void testTransferFunds() {
        // Step 1: Login to the application
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("john");  // Replace with valid username
        loginPage.enterPassword("demo");  // Replace with valid password
        loginPage.clickLoginButton();

        // Step 2: Go to the Transfer Funds page
        driver.get("https://parabank.parasoft.com/parabank/transfer.htm");

        // Step 3: Initialize the TransferFundsPage
        TransferFundsPage transferPage = new TransferFundsPage(driver);

        // Step 4: Fill in the transfer form
        transferPage.enterAmount("100");                  // Enter amount to transfer
        transferPage.selectFromAccountByIndex(0);         // Select first available "From" account
        transferPage.selectToAccountByIndex(1);           // Select second available "To" account

        // Step 5: Click on Transfer
        transferPage.clickTransferButton();

        // Step 6: Assert confirmation message is displayed
        boolean isDisplayed = transferPage.isTransferCompleteMessageDisplayed();
        Assert.assertTrue(isDisplayed, "Transfer complete message should be displayed");

        System.out.println("Transfer was successful.");
    }
}
