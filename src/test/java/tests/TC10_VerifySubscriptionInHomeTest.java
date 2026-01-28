package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC10_VerifySubscriptionInHomeTest extends BaseTest {

    @Test
    public void verifySubscriptionHome() {

        ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");

        homePage.subscribe("test@test.com");

        Assert.assertTrue(homePage.isSubscriptionSuccessVisible());
    }
}
