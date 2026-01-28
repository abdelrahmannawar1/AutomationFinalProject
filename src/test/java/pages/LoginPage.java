package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    By email = By.xpath("//input[@data-qa='login-email']");
    By password = By.xpath("//input[@data-qa='login-password']");
    By loginBtn = By.xpath("//button[@data-qa='login-button']");
    By errorMsg = By.xpath("//*[contains(text(),'Your email or password is incorrect')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void login(String userEmail, String userPassword) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(email))
                .clear();
        driver.findElement(email).sendKeys(userEmail);

        wait.until(ExpectedConditions.visibilityOfElementLocated(password))
                .clear();
        driver.findElement(password).sendKeys(userPassword);

        WebElement loginButton =
                wait.until(ExpectedConditions.presenceOfElementLocated(loginBtn));

        ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", loginButton);
    }


    public boolean isErrorVisible() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(errorMsg)
        ).isDisplayed();
    }
}
