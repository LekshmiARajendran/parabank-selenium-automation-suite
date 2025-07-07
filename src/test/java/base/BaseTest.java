package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver; // ✅ Use protected so subclasses can access

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver(); // or your browser of choice
        driver.manage().window().maximize();
        driver.get("https://parabank.parasoft.com/parabank/index.htm"); // ✅ Your app URL
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // ✅ ADD THIS METHOD:
    public WebDriver getDriver() {
        return driver;
    }
}
