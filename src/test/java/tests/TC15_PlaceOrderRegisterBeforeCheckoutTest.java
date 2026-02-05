package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class TC15_PlaceOrderRegisterBeforeCheckoutTest extends BaseTest {

    @Test
    public void placeOrderRegisterBeforeCheckout() {

        // Register first
        homePage.clickSignupLogin();
        SignupLoginPage signupLoginPage = new SignupLoginPage(driver);
        signupLoginPage.signup("User",
                "test" + System.currentTimeMillis() + "@mail.com");

        AccountInformationPage accountInfo = new AccountInformationPage(driver);
        accountInfo.fillAccountInformation();

        AccountCreatedPage accountCreatedPage =
                new AccountCreatedPage(driver);
        accountCreatedPage.clickContinue();

        // Add product
        homePage.openProductsPage();
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addFirstProductToCart();
        productsPage.goToCart();

        // Checkout
        CartPage cartPage = new CartPage(driver);
        cartPage.proceedToCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.enterComment("Test order");
        checkoutPage.placeOrder();

        // Payment
        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.fillPaymentDetails(
                "Test User",
                "1234123412341234",
                "123",
                "12",
                "2030"
        );
        paymentPage.clickPayButton();

        Assert.assertTrue(paymentPage.isOrderPlacedVisible());
    }
}
