package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BillPayPage;
import pages.LoginPage;

public class BillPayTest extends BaseTest {

    @Test
    public void testBillPayFunctionality() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("john");
        loginPage.enterPassword("demo");
        loginPage.clickLoginButton();

        BillPayPage billPayPage = new BillPayPage(driver);
        billPayPage.clickBillPayLink();

        billPayPage.enterPayeeDetails(
                "John Doe", "123 Elm Street", "New York", "NY", "10001",
                "1234567890", "987654321", "500", "12345"
        );

        billPayPage.submitBillPayment();

        Assert.assertTrue(billPayPage.isPaymentSuccessful(), "Payment was not successful.");
        System.out.println("Bill Payment successful");
    }
}
