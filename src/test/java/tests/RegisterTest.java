package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegisterPage;

import java.util.UUID;

public class RegisterTest extends BaseTest {

    @Test
    public void testUserRegistration() {
        // Step 1: Go to registration page
        driver.get("https://parabank.parasoft.com/parabank/register.htm");

        // Step 2: Enter details
        RegisterPage registerPage = new RegisterPage(driver);
        String uniqueUsername = "user" + UUID.randomUUID().toString().substring(0, 6); // ensures uniqueness

        registerPage.enterRegistrationDetails(
                "Test",
                "User",
                "123 Main St",
                "Berlin",
                "BE",
                "12345",
                "1234567890",
                "123-45-6789",
                uniqueUsername,
                "password123"
        );

        // Step 3: Submit
        registerPage.clickRegisterButton();

        // Step 4: Assert
        String successMsg = registerPage.getSuccessMessage();
        Assert.assertTrue(successMsg.contains("Welcome"), "Registration may have failed!");
        System.out.println("✅ Registration successful for: " + uniqueUsername);
    }
}
