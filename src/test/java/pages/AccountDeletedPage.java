package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountDeletedPage {

    WebDriver driver;
    WebDriverWait wait;

    By accountDeletedText = By.xpath("//h2[@data-qa='account-deleted']");
    By continueBtn = By.xpath("//a[@data-qa='continue-button']");

    public AccountDeletedPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isAccountDeletedVisible() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(accountDeletedText)
        ).isDisplayed();
    }

    public void clickContinue() {
        wait.until(
                ExpectedConditions.elementToBeClickable(continueBtn)
        ).click();
    }
}
