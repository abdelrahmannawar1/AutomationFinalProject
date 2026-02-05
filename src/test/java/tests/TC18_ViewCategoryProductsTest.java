package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC18_ViewCategoryProductsTest extends BaseTest {

    @Test
    public void viewCategoryProducts() {

        // Open Women → Dress
        homePage.openWomenDressCategory();


        Assert.assertTrue(driver.getCurrentUrl().contains("category"));

        // Open Men → Tshirts
        homePage.openMenTshirtCategory();

        Assert.assertTrue(driver.getCurrentUrl().contains("category"));
    }
}
