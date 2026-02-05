package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;
    By signupLoginBtn = By.xpath("//a[contains(text(),'Signup / Login')]");
    By loggedInText = By.xpath("//a[contains(text(),'Logged in as')]");
    By homeLogo = By.xpath("//img[@alt='Website for automation practice']");

    By productsBtn = By.xpath("//a[contains(text(),'Products')]");
    By cartBtn = By.xpath("//a[contains(text(),'Cart')]");
    By testCasesBtn = By.xpath("//a[contains(text(),'Test Cases')]");
    By contactUsBtn = By.xpath("//a[contains(text(),'Contact us')]");
    By logoutBtn = By.xpath("//a[contains(text(),'Logout')]");

    By subscriptionEmail = By.id("susbscribe_email");
    By subscribeBtn = By.id("subscribe");
    By subscriptionSuccessMsg =
            By.xpath("//div[@class='alert-success alert']");
    By womenCategory = By.xpath("//a[contains(text(),'Women')]");
    By dressCategory = By.xpath("//a[contains(text(),'Dress')]");
    By menCategory = By.xpath("//a[contains(text(),'Men')]");
    By tshirtCategory = By.xpath("//a[contains(text(),'Tshirts')]");
    By recommendedSection = By.xpath("//h2[contains(text(),'recommended items')]");
    By recommendedAddToCart = By.xpath("(//a[contains(text(),'Add to cart')])[last()]");
    By viewCartBtn = By.xpath("//u[contains(text(),'View Cart')]");
    By subscriptionText = By.xpath("//h2[contains(text(),'Subscription')]");
    By scrollUpArrow = By.id("scrollUp");
    By topText = By.xpath("//*[contains(text(),'Full-Fledged practice website for Automation Engineers')]");
    By deleteAccountBtn = By.xpath("//a[contains(text(),'Delete Account')]");

    public void deleteAccount() {
        driver.findElement(deleteAccountBtn).click();
    }
    public boolean isHomePageVisible() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(homeLogo)
        ).isDisplayed();
    }

    public boolean isLoggedInVisible() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(loggedInText)
        ).isDisplayed();
    }



    public void scrollToTop() {
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, 0)");
    }

    public boolean isSubscriptionVisible() {
        return driver.findElement(subscriptionText).isDisplayed();
    }

    public void clickScrollUpArrow() {
        driver.findElement(scrollUpArrow).click();
    }

    public boolean isTopTextVisible() {
        return driver.findElement(topText).isDisplayed();
    }

    public void openSignupLoginPage() {
        wait.until(
                ExpectedConditions.elementToBeClickable(signupLoginBtn)
        ).click();
    }

    public boolean isRecommendedVisible() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(recommendedSection)
        ).isDisplayed();
    }

    public void addRecommendedToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(recommendedAddToCart)).click();
    }

    public void clickViewCart() {
        wait.until(ExpectedConditions.elementToBeClickable(viewCartBtn)).click();
    }

    public void openWomenDressCategory() {

        WebElement women =
                wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//a[contains(text(),'Women')]")
                ));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", women);

        WebElement dress =
                wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//a[contains(text(),'Dress')]")
                ));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", dress);
    }


    public void openMenTshirtCategory() {
        wait.until(ExpectedConditions.elementToBeClickable(menCategory)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tshirtCategory)).click();
    }

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
