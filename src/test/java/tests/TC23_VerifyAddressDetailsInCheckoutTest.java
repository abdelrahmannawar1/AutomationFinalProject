package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class TC23_VerifyAddressDetailsInCheckoutTest extends BaseTest {

    @Test
    public void verifyAddressDetailsInCheckout() {

        Assert.assertTrue(homePage.isHomePageVisible());

        homePage.openSignupLoginPage();

        SignupLoginPage signupLoginPage = new SignupLoginPage(driver);
        signupLoginPage.signup("TestUser", "test" + System.currentTimeMillis() + "@mail.com");

        AccountInformationPage accountInfo = new AccountInformationPage(driver);
        accountInfo.fillAccountInformation();

        AccountCreatedPage accountCreatedPage = new AccountCreatedPage(driver);
        accountCreatedPage.clickContinue();

        Assert.assertTrue(homePage.isLoggedInVisible());

        homePage.openProductsPage();

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addFirstProductToCart();
        productsPage.goToCart();

        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.isCartVisible());

        cartPage.proceedToCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);

        Assert.assertTrue(checkoutPage.isDeliveryAddressVisible());
        Assert.assertTrue(checkoutPage.isBillingAddressVisible());

        homePage.deleteAccount();

        AccountDeletedPage accountDeletedPage = new AccountDeletedPage(driver);
        accountDeletedPage.clickContinue();
    }
}
