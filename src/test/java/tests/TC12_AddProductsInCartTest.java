package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductsPage;
import pages.CartPage;

public class TC12_AddProductsInCartTest extends BaseTest {

    @Test
    public void addProductsInCart() {

        driver.findElement(org.openqa.selenium.By.xpath("//a[contains(text(),'Products')]")).click();

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addFirstProductToCart();
        productsPage.addSecondProductToCart();

        driver.findElement(org.openqa.selenium.By.xpath("//a[contains(text(),'Cart')]")).click();

        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.isCartVisible());
    }
}
