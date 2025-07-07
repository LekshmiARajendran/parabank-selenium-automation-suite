package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {
        // Create object of LoginPage and pass the driver
        LoginPage loginPage = new LoginPage(driver);

        // Perform login using valid credentials
        loginPage.enterUsername("john");
        loginPage.enterPassword("demo");
        loginPage.clickLoginButton();

        // Get the title after login
        String actualTitle = driver.getTitle();

        // Compare the actual title with expected title
        Assert.assertEquals(actualTitle, "ParaBank | Accounts Overview", "Login should be successful");
    }
}