package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountCreatedPage;
import pages.AccountInformationPage;
import pages.HomePage;
import pages.SignupPage;
import utils.JsonDataReader;

public class TC03_SignupNewUserTest extends BaseTest {

    @Test
    public void signupNewUser() {

   JsonDataReader.loadJsonFile("testdata/users.json");
String name = JsonDataReader.getData("validUser", "name");

        String baseEmail = JsonDataReader.getData("validUser", "email");
        String email = baseEmail.replace("@", System.currentTimeMillis() + "@");

        String password = JsonDataReader.getData("validUser", "password");

        // 2) Go to Signup/Login
        HomePage homePage = new HomePage(driver);
        homePage.clickSignupLogin();

        // 3) Signup New User
        SignupPage signupPage = new SignupPage(driver);
        signupPage.signupNewUser(name, email);

        // 4) Fill password + Create Account
        AccountInformationPage accountInfo = new AccountInformationPage(driver);
        accountInfo.fillAccountInfoAndCreate(password);


        // 5) Verify account created
        AccountCreatedPage createdPage = new AccountCreatedPage(driver);
        Assert.assertTrue(createdPage.isAccountCreatedVisible(), "ACCOUNT CREATED! not displayed");
        createdPage.clickContinue();
    }
}
