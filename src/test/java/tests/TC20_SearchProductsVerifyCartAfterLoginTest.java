package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class TC20_SearchProductsVerifyCartAfterLoginTest extends BaseTest {

    @Test
    public void searchProductsAndVerifyCartAfterLogin() {

        homePage.openProductsPage();

        ProductsPage productsPage = new ProductsPage(driver);

        productsPage.searchProduct("Blue Top");
        Assert.assertTrue(productsPage.isSearchedProductsVisible());

        productsPage.addFirstProductToCart();
        productsPage.goToCart();

        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.isCartVisible());

        homePage.openSignupLoginPage();

        SignupLoginPage loginPage = new SignupLoginPage(driver);
        loginPage.login("test@mail.com", "123456");

        homePage.openCartPage();

        Assert.assertTrue(cartPage.isCartVisible());
    }
}
