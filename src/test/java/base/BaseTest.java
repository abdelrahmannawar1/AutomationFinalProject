package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.DriverFactory;
import utils.JsonDataReader;

public class BaseTest {

    protected WebDriver driver;
    protected HomePage homePage;

    @BeforeMethod
    public void setUp() {

        JsonDataReader.loadJsonFile();   // ← ضيف السطر ده هنا

        driver = DriverFactory.initDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com");

        homePage = new HomePage(driver);

        ((JavascriptExecutor) driver).executeScript(
                "var ads = document.querySelectorAll('iframe, ins, .adsbygoogle');" +
                        "ads.forEach(el => el.remove());"
        );
    }



    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
