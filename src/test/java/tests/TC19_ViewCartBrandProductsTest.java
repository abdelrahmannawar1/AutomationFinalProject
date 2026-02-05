package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductsPage;

public class TC19_ViewCartBrandProductsTest extends BaseTest {

    @Test
    public void viewAndCartBrandProducts() {

        homePage.openProductsPage();

        ProductsPage productsPage = new ProductsPage(driver);

        // Open first brand
        productsPage.openFirstBrand();
        Assert.assertTrue(driver.getCurrentUrl().contains("brand"));

        // Open second brand
        productsPage.openSecondBrand();
        Assert.assertTrue(driver.getCurrentUrl().contains("brand"));
    }
}
