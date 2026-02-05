package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignupPage {

    WebDriver driver;

    private By nameField = By.xpath("//input[@data-qa='signup-name']");
    private By emailField = By.xpath("//input[@data-qa='signup-email']");
    private By signupBtn = By.xpath("//button[@data-qa='signup-button']");
    private By emailExistsMsg =
            By.xpath("//*[contains(text(),'Email Address already exist') or contains(text(),'Email Address already exists')]");

    public SignupPage(WebDriver driver) {
        this.driver = driver;
    }


    public void signup(String name, String email) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(signupBtn).click();
    }

    //  in TC05
    public boolean isEmailAlreadyExistsVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(emailExistsMsg)
        ).isDisplayed();
    }

}
