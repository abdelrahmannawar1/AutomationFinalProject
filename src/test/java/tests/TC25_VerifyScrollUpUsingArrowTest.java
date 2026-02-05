package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class TC25_VerifyScrollUpUsingArrowTest extends BaseTest {

    @Test
    public void verifyScrollUpUsingArrow() {

        Assert.assertTrue(homePage.isHomePageVisible());

        homePage.scrollToBottom();

        Assert.assertTrue(homePage.isSubscriptionVisible());

        homePage.clickScrollUpArrow();

        Assert.assertTrue(homePage.isTopTextVisible());
    }
}
