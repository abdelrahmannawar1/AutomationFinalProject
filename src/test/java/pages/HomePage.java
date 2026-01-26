package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    private By signupLoginBtn = By.xpath("//a[contains(text(),'Signup / Login')]");
    private By logoutBtn = By.xpath("//a[@href='/logout']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickSignupLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(signupLoginBtn)).click();
    }

    public boolean isLogoutVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(logoutBtn)).isDisplayed();
    }
}
