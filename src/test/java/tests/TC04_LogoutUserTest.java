package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.JsonDataReader;

public class TC04_LogoutUserTest extends BaseTest {

    @Test
    public void logoutUser() {

        String email = JsonDataReader.getData("validUser", "email");
        String password = JsonDataReader.getData("validUser", "password");

        homePage.clickSignupLogin();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(email, password);

        Assert.assertTrue(
                driver.getCurrentUrl().toLowerCase().contains("login"),
                "User is not redirected to login page"
        );


        homePage.clickLogout();

        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }
}
