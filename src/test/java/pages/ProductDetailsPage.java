package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage {

    WebDriver driver;

    By productInfo = By.className("product-information");
    By quantityInput = By.id("quantity");
    By addToCartBtn = By.xpath("//button[contains(text(),'Add to cart')]");

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProductDetailsVisible() {
        return driver.findElement(productInfo).isDisplayed();
    }

    public void setQuantity(int qty) {
        driver.findElement(quantityInput).clear();
        driver.findElement(quantityInput).sendKeys(String.valueOf(qty));
    }

    public void addToCart() {
        driver.findElement(addToCartBtn).click();
    }
}
