package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignupLoginPage {

    WebDriver driver;
    WebDriverWait wait;

    By signupName = By.name("name");
    By signupEmail = By.xpath("//input[@data-qa='signup-email']");
    By signupBtn = By.xpath("//button[@data-qa='signup-button']");
    By loginEmail = By.xpath("//input[@data-qa='login-email']");
    By loginPassword = By.xpath("//input[@data-qa='login-password']");
    By loginBtn = By.xpath("//button[@data-qa='login-button']");

    public void login(String email, String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginEmail)).sendKeys(email);
        driver.findElement(loginPassword).sendKeys(password);
        driver.findElement(loginBtn).click();
    }

    public void signup(String name, String email) {
        driver.findElement(By.name("name")).sendKeys(name);
        driver.findElement(By.xpath("//input[@data-qa='signup-email']"))
                .sendKeys(email);
        driver.findElement(By.xpath("//button[@data-qa='signup-button']"))
                .click();
    }

    public SignupLoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterSignupName(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(signupName))
                .sendKeys(name);
    }

    public void enterSignupEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(signupEmail))
                .sendKeys(email);
    }

    public void clickSignup() {
        wait.until(ExpectedConditions.elementToBeClickable(signupBtn))
                .click();
    }
}
