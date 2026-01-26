package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.JsonDataReader;

public class TC02_LoginWithValidCredentialsTest extends BaseTest {

    @Test

    public void loginWithValidCredentials() {

        JsonDataReader.loadJsonFile("testdata/users.json");

        String email = JsonDataReader.getData("loginUser", "email");
        String password = JsonDataReader.getData("loginUser", "password");

        HomePage homePage = new HomePage(driver);
        homePage.clickSignupLogin();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(email, password);

        Assert.assertTrue(homePage.isLogoutVisible());
    }

}
