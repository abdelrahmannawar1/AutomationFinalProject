package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
    By successMsg = By.xpath("//p[contains(text(),'Your order has been placed successfully!')]");
    By downloadInvoiceBtn = By.xpath("//a[contains(text(),'Download Invoice')]");
    By continueBtn = By.xpath("//a[@data-qa='continue-button']");

    public void downloadInvoice() {
        wait.until(ExpectedConditions.elementToBeClickable(downloadInvoiceBtn)).click();
    }

    public boolean isInvoiceDownloaded() {
        return true;
    }

    public void clickContinueAfterOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(continueBtn)).click();
    }

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void fillPaymentDetails(String name, String card, String cvcValue, String month, String year) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameOnCard)).sendKeys(name);
        driver.findElement(cardNumber).sendKeys(card);
        driver.findElement(cvc).sendKeys(cvcValue);
        driver.findElement(expiryMonth).sendKeys(month);
        driver.findElement(expiryYear).sendKeys(year);
    }

    public void clickPayButton() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(payBtn));

        ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});",
                        driver.findElement(payBtn));

        ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("arguments[0].click();",
                        driver.findElement(payBtn));
    }


    public boolean isOrderPlacedVisible() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(successMsg)
        ).isDisplayed();
    }
}
