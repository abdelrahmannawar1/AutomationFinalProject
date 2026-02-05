package tests;


import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.JsonDataReader;

public class TC02_LoginWithValidCredentialsTest extends BaseTest {

    @Test
    public void loginWithValidCredentials() {

        String email = JsonDataReader.getData("validUser", "email");
        String password = JsonDataReader.getData("validUser", "password");

        homePage.clickSignupLogin();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(email, password);

        Assert.assertTrue(
                homePage.isLoggedInTextVisible(),
                "User is not logged in"
        );
    }
}
