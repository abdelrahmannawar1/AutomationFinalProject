package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductsPage;

public class TC09_SearchProductTest extends BaseTest {

    @Test
    public void searchProduct() {

        driver.findElement(org.openqa.selenium.By.xpath("//a[contains(text(),'Products')]")).click();

        ProductsPage productsPage = new ProductsPage(driver);

        homePage.openProductsPage();
        productsPage.searchProduct("dress");


        Assert.assertTrue(productsPage.isSearchedProductsVisible());
    }
}
