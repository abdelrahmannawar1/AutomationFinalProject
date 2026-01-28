package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;

public class TC11_VerifySubscriptionInCartTest extends BaseTest {

    @Test
    public void verifySubscriptionCart() {

        driver.findElement(org.openqa.selenium.By.xpath("//a[contains(text(),'Cart')]")).click();

        ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");

        CartPage cartPage = new CartPage(driver);
        homePage.subscribe("test@test.com");

        Assert.assertTrue(homePage.isSubscriptionSuccessVisible());
    }
}
