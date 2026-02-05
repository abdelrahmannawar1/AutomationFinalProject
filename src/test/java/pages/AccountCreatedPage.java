package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

public class AccountCreatedPage {

    WebDriver driver;
    WebDriverWait wait;

    private By accountCreatedText = By.xpath("//h2[@data-qa='account-created']");
    private By continueBtn = By.xpath("//a[@data-qa='continue-button']");

    public AccountCreatedPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public boolean isAccountCreatedVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountCreatedText));
        return driver.findElement(accountCreatedText).isDisplayed();
    }

    public void clickContinue() {

        WebElement element = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//a[@data-qa='continue-button']")
                )
        );

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", element);
    }

}
