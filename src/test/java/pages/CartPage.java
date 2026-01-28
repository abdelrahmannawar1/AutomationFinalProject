package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    WebDriver driver;

    By cartInfoTable = By.id("cart_info_table");
    By quantityText = By.className("cart_quantity");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isCartVisible() {
        return driver.findElement(cartInfoTable).isDisplayed();
    }

    public String getProductQuantity() {
        return driver.findElement(quantityText).getText();
    }
}
