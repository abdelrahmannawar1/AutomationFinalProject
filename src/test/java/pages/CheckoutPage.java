package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.By;

public class CheckoutPage {

    WebDriver driver;
    WebDriverWait wait;
    By placeOrderBtn = By.xpath("//a[contains(text(),'Place Order')]");
    By commentBox = By.name("message");
    By deliveryAddress = By.id("address_delivery");
    By billingAddress = By.id("address_invoice");

    public boolean isDeliveryAddressVisible() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(deliveryAddress)
        ).isDisplayed();
    }

    public boolean isBillingAddressVisible() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(billingAddress)
        ).isDisplayed();
    }


    public void enterComment(String comment) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(commentBox))
                .sendKeys(comment);
    }
    public void clickPlaceOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderBtn))
                .click();
    }

    public void placeOrder() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(placeOrderBtn));

        ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});",
                        driver.findElement(placeOrderBtn));

        ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("arguments[0].click();",
                        driver.findElement(placeOrderBtn));
    }


    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
}

