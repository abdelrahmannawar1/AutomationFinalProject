package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC07_VerifyTestCasesPageTest extends BaseTest {

    @Test
    public void verifyTestCasesPage() {

        homePage.clickTestCases();

        Assert.assertTrue(
                driver.getCurrentUrl().contains("test_cases"),
                "User is not navigated to Test Cases page"
        );

    }
}
