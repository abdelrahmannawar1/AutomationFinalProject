package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupLoginPage {

    WebDriver driver;

    By nameField = By.name("name");
    By emailField = By.xpath("//input[@data-qa='signup-email']");
    By signupBtn = By.xpath("//button[@data-qa='signup-button']");

    public SignupLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void signup(String name, String email) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(signupBtn).click();
    }
}
