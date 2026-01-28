package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.JsonDataReader;

public class TC03_LoginWithInvalidCredentialsTest extends BaseTest {

    @Test
    public void loginWithInvalidCredentials() {

        homePage.clickSignupLogin();

        String email = JsonDataReader.getData("invalidUser", "email");
        String password = JsonDataReader.getData("invalidUser", "password");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(email, password);

        Assert.assertTrue(
                loginPage.isErrorVisible(),
                "Error message is not displayed"
        );
    }
}
