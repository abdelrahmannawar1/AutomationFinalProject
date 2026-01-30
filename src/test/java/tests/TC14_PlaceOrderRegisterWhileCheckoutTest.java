package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class TC14_PlaceOrderRegisterWhileCheckoutTest extends BaseTest {

    @Test
    public void placeOrderRegisterWhileCheckout() {

        // 1. Add product to cart
        homePage.openProductsPage();
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addFirstProductToCart();
        productsPage.goToCart();

        // 2. Proceed to checkout
        CartPage cartPage = new CartPage(driver);
        cartPage.proceedToCheckout();

        // 3. Click Register / Login
        cartPage.clickRegisterLogin();

        // 4. Register new user
        SignupLoginPage signupLoginPage = new SignupLoginPage(driver);
        signupLoginPage.signup("TestUser", "test" + System.currentTimeMillis() + "@mail.com");

        AccountInformationPage accountInfo = new AccountInformationPage(driver);
        accountInfo.fillAccountInformation();

        AccountCreatedPage accountCreatedPage = new AccountCreatedPage(driver);
        accountCreatedPage.clickContinue();

        // 5. Proceed again to checkout
        homePage.openCartPage();
        cartPage.proceedToCheckout();

        // 6. Place order
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.placeOrder();

        // 7. Payment
        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.enterPaymentDetails();
        paymentPage.confirmOrder();

        // 8. Assert success
        Assert.assertTrue(
                paymentPage.isOrderPlacedVisible(),
                "Order was not placed successfully"
        );
    }
}
