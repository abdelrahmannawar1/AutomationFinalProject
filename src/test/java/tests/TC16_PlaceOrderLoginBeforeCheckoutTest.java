package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class TC16_PlaceOrderLoginBeforeCheckoutTest extends BaseTest {

    @Test
    public void placeOrderLoginBeforeCheckout() {

        homePage.clickSignupLogin();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("your_registered_email@mail.com", "yourPassword");

        homePage.openProductsPage();
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addFirstProductToCart();
        productsPage.goToCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.proceedToCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.enterComment("Test order");
        checkoutPage.placeOrder();

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
