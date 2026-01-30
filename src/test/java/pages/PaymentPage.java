package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PaymentPage {

    WebDriver driver;
    WebDriverWait wait;

    By nameOnCard = By.name("name_on_card");
    By cardNumber = By.name("card_number");
    By cvc = By.name("cvc");
    By expiryMonth = By.name("expiry_month");
    By expiryYear = By.name("expiry_year");
    By payBtn = By.id("submit");
    By orderPlacedMsg = By.xpath("//b[contains(text(),'Order Placed!')]");

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterPaymentDetails() {
        driver.findElement(nameOnCard).sendKeys("Test User");
        driver.findElement(cardNumber).sendKeys("4111111111111111");
        driver.findElement(cvc).sendKeys("123");
        driver.findElement(expiryMonth).sendKeys("12");
        driver.findElement(expiryYear).sendKeys("2027");
    }

    public void confirmOrder() {
        driver.findElement(payBtn).click();
    }

    public boolean isOrderPlacedVisible() {
        return driver.findElement(orderPlacedMsg).isDisplayed();
    }
}
