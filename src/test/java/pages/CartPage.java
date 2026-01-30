package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    WebDriver driver;
    WebDriverWait wait;

    By shoppingCartTitle =
            By.xpath("//li[contains(text(),'Shopping Cart')]");

    By quantityInput =
            By.xpath("//input[@name='quantity']");
    By productQuantity = By.xpath("//button[@class='disabled']");
    By proceedToCheckoutBtn = By.xpath("//a[contains(text(),'Proceed To Checkout')]");
    By registerLoginBtn = By.xpath("//u[contains(text(),'Register / Login')]");

    public void proceedToCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutBtn)).click();
    }

    public void clickRegisterLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(registerLoginBtn)).click();
    }

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isCartVisible() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(shoppingCartTitle)
        ).isDisplayed();
    }

    public int getProductQuantity() {
        String qty = wait
                .until(ExpectedConditions.visibilityOfElementLocated(productQuantity))
                .getText();
        return Integer.parseInt(qty);
    }



}
