package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class TC02_NavigateToLoginPageTest extends BaseTest {

    @Test
    public void goToLoginPage() {

        HomePage homePage = new HomePage(driver);
        homePage.clickSignupLogin();

        // تأكيد بسيط إننا فعلاً رحنا صفحة اللوجين
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }
}
