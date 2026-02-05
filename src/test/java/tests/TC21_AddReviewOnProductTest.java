package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductsPage;

public class TC21_AddReviewOnProductTest extends BaseTest {

    @Test
    public void addReviewOnProduct() {

        homePage.openProductsPage();

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.openFirstProduct();

        productsPage.addReview("TestUser", "test@mail.com", "Very good product");

        Assert.assertTrue(productsPage.isReviewSuccessVisible());
    }
}
