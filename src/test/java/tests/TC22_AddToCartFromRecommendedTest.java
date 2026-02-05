package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;

public class TC22_AddToCartFromRecommendedTest extends BaseTest {

    @Test
    public void addToCartFromRecommended() {

        homePage.scrollToBottom();

        Assert.assertTrue(homePage.isRecommendedVisible());

        homePage.addRecommendedToCart();
        homePage.clickViewCart();

        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.isCartVisible());
    }
}
