package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SignupPage;

public class TC05_RegisterWithExistingEmailTest extends BaseTest {

    @Test
    public void registerWithExistingEmail() {

        homePage.clickSignupLogin();

        SignupPage signupPage = new SignupPage(driver);
        signupPage.signup("Test User", "test@test.com");

        Assert.assertTrue(
                signupPage.isEmailAlreadyExistsVisible(),
                "Email Address already exist message not visible"
        );
    }
}
