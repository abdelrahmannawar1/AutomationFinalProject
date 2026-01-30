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

    public void placeOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderBtn)).click();
    }

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
}

