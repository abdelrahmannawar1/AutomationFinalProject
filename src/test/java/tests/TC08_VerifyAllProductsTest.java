package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductsPage;
import pages.ProductDetailsPage;

public class TC08_VerifyAllProductsTest extends BaseTest {

    @Test
    public void verifyAllProductsAndDetails() {

        driver.findElement(org.openqa.selenium.By.xpath("//a[contains(text(),'Products')]")).click();

        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.isAllProductsVisible());

        productsPage.openFirstProduct();

        ProductDetailsPage detailsPage = new ProductDetailsPage(driver);
        Assert.assertTrue(detailsPage.isProductDetailsVisible());
    }
}
