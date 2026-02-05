package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class TC24_DownloadInvoiceAfterPurchaseTest extends BaseTest {

    @Test
    public void downloadInvoiceAfterPurchase() {

        Assert.assertTrue(homePage.isHomePageVisible());

        homePage.openProductsPage();

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addFirstProductToCart();
        productsPage.goToCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.proceedToCheckout();

        cartPage.clickRegisterLogin();

        SignupLoginPage signupLoginPage = new SignupLoginPage(driver);
        signupLoginPage.signup("TestUser", "test" + System.currentTimeMillis() + "@mail.com");

        AccountInformationPage accountInfo = new AccountInformationPage(driver);
        accountInfo.fillAccountInformation();

        AccountCreatedPage accountCreatedPage = new AccountCreatedPage(driver);
        accountCreatedPage.clickContinue();

        homePage.openCartPage();
        cartPage.proceedToCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.enterComment("Test order");
        checkoutPage.placeOrder();

        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.fillPaymentDetails("Test User", "1234123412341234", "123", "12", "2030");
        paymentPage.clickPayButton();

        Assert.assertTrue(paymentPage.isOrderPlacedVisible());

        paymentPage.downloadInvoice();
        Assert.assertTrue(paymentPage.isInvoiceDownloaded());

        paymentPage.clickContinueAfterOrder();

        homePage.deleteAccount();
    }
}
