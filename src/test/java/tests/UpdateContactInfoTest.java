package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.UpdateContactInfoPage;

public class UpdateContactInfoTest extends BaseTest {

    @Test
    public void testUpdateContactInformation() {
        // ✅ Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("john", "demo");

        // ✅ Go to update contact info
        UpdateContactInfoPage updatePage = new UpdateContactInfoPage(driver);
        updatePage.goToUpdateContactPage();

        // ✅ Update fields
        updatePage.updateContactInfo(
                "John", "Doe", "123 Main St",
                "CityVille", "StateBurg", "12345", "9876543210"
        );

        // ✅ Submit and assert
        updatePage.submitUpdate();
        Assert.assertTrue(updatePage.isUpdateSuccessful(), "Profile update failed!");
    }
}
