package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;

public class TC06_ContactUsFormTest extends BaseTest {

    @Test
    public void contactUsForm() {

        homePage.clickContactUs();

        ContactUsPage contactUsPage = new ContactUsPage(driver);

        contactUsPage.fillContactForm(
                "Abdelrahman",
                "test@test.com",
                "Automation",
                "Hello from automation"
        );

        contactUsPage.submitForm();
        contactUsPage.acceptAlert();

        Assert.assertTrue(
                contactUsPage.isSuccessMessageVisible(),
                "Success message is not visible"
        );
    }
}
