package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductDetailsPage;
import pages.ProductsPage;

public class TC13_VerifyProductQuantityInCartTest extends BaseTest {

    @Test
    public void verifyProductQuantityInCart() {

        homePage.openProductsPage();

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.openFirstProduct();


        ProductDetailsPage productDetailsPage =
                new ProductDetailsPage(driver);

        productDetailsPage.setQuantity(4);
        productDetailsPage.addToCart();
        productDetailsPage.openCart();

        CartPage cartPage = new CartPage(driver);

        Assert.assertEquals(
                cartPage.getProductQuantity(),
                4,
                "Product quantity is incorrect"
        );
    }
}
