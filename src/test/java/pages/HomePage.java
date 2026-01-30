package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;
    By signupLoginBtn = By.xpath("//a[contains(text(),'Signup / Login')]");
    By loggedInText = By.xpath("//a[contains(text(),'Logged in as')]");

    By productsBtn = By.xpath("//a[contains(text(),'Products')]");
    By cartBtn = By.xpath("//a[contains(text(),'Cart')]");
    By testCasesBtn = By.xpath("//a[contains(text(),'Test Cases')]");
    By contactUsBtn = By.xpath("//a[contains(text(),'Contact us')]");
    By logoutBtn = By.xpath("//a[contains(text(),'Logout')]");

    By subscriptionEmail = By.id("susbscribe_email");
    By subscribeBtn = By.id("subscribe");
    By subscriptionSuccessMsg =
            By.xpath("//div[@class='alert-success alert']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /* ---------------- Navigation ---------------- */

    public void clickTestCases() {
        wait.until(ExpectedConditions.elementToBeClickable(testCasesBtn)).click();
    }
    public void clickContactUs() {
        wait.until(ExpectedConditions.elementToBeClickable(contactUsBtn)).click();
    }

    public void clickLogout() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutBtn)).click();
    }

    public void openProductsPage() {
        wait.until(ExpectedConditions.elementToBeClickable(productsBtn)).click();
    }

    public void openCartPage() {
        wait.until(ExpectedConditions.elementToBeClickable(cartBtn)).click();
    }

    /* ---------------- Subscription ---------------- */

    public void subscribe(String email) {
        scrollToBottom();
        wait.until(ExpectedConditions.visibilityOfElementLocated(subscriptionEmail))
                .sendKeys(email);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",
                wait.until(ExpectedConditions.visibilityOfElementLocated(subscribeBtn)));

    }
    public void clickSignupLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(signupLoginBtn)).click();
    }

    public boolean isLoggedInTextVisible() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(loggedInText)
        ).isDisplayed();
    }

    public boolean isSubscriptionSuccessVisible() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(subscriptionSuccessMsg)
        ).isDisplayed();
    }

    /* ---------------- Scroll ---------------- */

    public void scrollToBottom() {
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
}
