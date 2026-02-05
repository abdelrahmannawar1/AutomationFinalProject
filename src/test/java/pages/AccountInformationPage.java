package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountInformationPage {

    WebDriver driver;
    WebDriverWait wait;

    By password = By.id("password");
    By firstName = By.id("first_name");
    By lastName = By.id("last_name");
    By address = By.id("address1");
    By country = By.id("country");
    By state = By.id("state");
    By city = By.id("city");
    By zipcode = By.id("zipcode");
    By mobileNumber = By.id("mobile_number");
    By createAccountBtn = By.xpath("//button[@data-qa='create-account']");

    public AccountInformationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void fillAccountInformation() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(password))
                .sendKeys("123456");

        driver.findElement(firstName).sendKeys("Test");
        driver.findElement(lastName).sendKeys("User");
        driver.findElement(address).sendKeys("Cairo");
        driver.findElement(state).sendKeys("Cairo");
        driver.findElement(city).sendKeys("Cairo");
        driver.findElement(zipcode).sendKeys("12345");
        driver.findElement(mobileNumber).sendKeys("01000000000");
    }

    public void clickCreateAccount() {
        wait.until(ExpectedConditions.elementToBeClickable(createAccountBtn))
                .click();
    }
}
