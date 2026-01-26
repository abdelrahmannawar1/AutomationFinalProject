package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountCreatedPage;
import pages.AccountInformationPage;
import pages.HomePage;
import pages.SignupPage;
import utils.JsonDataReader;

public class TC01_RegisterUserTest extends BaseTest {


    @Test
    public void registerUser() {

        JsonDataReader.loadJsonFile("testdata/users.json");

        String name = "Test User";
        String email = "newuser_" + System.currentTimeMillis() + "@gmail.com";

        HomePage homePage = new HomePage(driver);
        homePage.clickSignupLogin();

        SignupPage signupPage = new SignupPage(driver);
        signupPage.signupNewUser(name, email);

        AccountInformationPage accountInfo =
                new AccountInformationPage(driver);
        accountInfo.fillAccountInfoAndCreate("123456");

        AccountCreatedPage accountCreated =
                new AccountCreatedPage(driver);

        Assert.assertTrue(accountCreated.isAccountCreatedVisible());
    }

}
