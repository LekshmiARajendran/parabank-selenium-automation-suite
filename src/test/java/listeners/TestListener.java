package listeners;

import base.BaseTest; // ✅ REQUIRED
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.WebDriver;
import utils.ScreenshotUtil;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("⚠️ Test Failed: " + result.getName());

        Object testClass = result.getInstance();
        if (testClass instanceof BaseTest) {
            WebDriver driver = ((BaseTest) testClass).getDriver();

            if (driver != null) {
                String screenshotPath = ScreenshotUtil.takeScreenshot(driver, result.getName());
                System.out.println("Screenshot saved at: " + screenshotPath);
            } else {
                System.out.println("Driver was null, screenshot not taken.");
            }
        } else {
            System.out.println("Test class is not instance of BaseTest.");
        }
    }

    // You can override other methods if needed (onTestSuccess, onStart, etc.)
}
