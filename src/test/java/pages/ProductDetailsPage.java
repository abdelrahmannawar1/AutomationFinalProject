package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductDetailsPage {

    WebDriver driver;
    WebDriverWait wait;

    By quantityInput = By.id("quantity");
    By addToCartBtn = By.xpath("//button[contains(@class,'cart')]");
    By viewCartBtn = By.xpath("//u[text()='View Cart']");

    By productName =
            By.xpath("//div[@class='product-information']//h2");

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /* ---------- Actions ---------- */

    public void setQuantity(int quantity) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(quantityInput))
                .clear();
        driver.findElement(quantityInput)
                .sendKeys(String.valueOf(quantity));
    }

    public void addToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn))
                .click();
    }

    public void openCart() {
        wait.until(ExpectedConditions.elementToBeClickable(viewCartBtn))
                .click();
    }

    /* ---------- Validation ---------- */

    public boolean isProductDetailsVisible() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(productName)
        ).isDisplayed();
    }
}
