package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LogoutTest extends BaseTest {

    @Test
    public void validLogoutTest() {
        // Step 1: Login to the application
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("john");
        loginPage.enterPassword("demo");
        loginPage.clickLoginButton();

        // Step 2: On home page, click logout
        HomePage homePage = new HomePage(driver);
        homePage.clickLogout();

        // Step 3: Check if user is redirected to login page
        Assert.assertTrue(homePage.isAtLoginPage(), "Logout failed or login page not displayed.");
    }
}
