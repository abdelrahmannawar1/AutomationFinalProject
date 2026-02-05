package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class TC17_RemoveProductsFromCartTest extends BaseTest {

    @Test
    public void removeProductsFromCart() {

        // Add product
        homePage.openProductsPage();
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addFirstProductToCart();
        productsPage.goToCart();

        // Verify cart visible
        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.isCartVisible());

        // Remove product
        cartPage.removeProduct();

        // Verify cart empty
        Assert.assertTrue(cartPage.isCartEmpty());
    }
}
