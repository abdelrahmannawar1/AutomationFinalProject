package tests;

import base.BaseTest;
import org.testng.annotations.Test;

public class TC01_RegisterUserTest extends BaseTest {

    @Test
    public void registerUser() {
        homePage.clickSignupLogin();
    }
}
