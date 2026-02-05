package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC26_VerifyScrollUpWithoutArrowTest extends BaseTest {

    @Test
    public void verifyScrollUpWithoutArrow() {

        homePage.scrollToBottom();

        homePage.scrollToTop();

        Assert.assertTrue(homePage.isTopTextVisible());
    }
}
