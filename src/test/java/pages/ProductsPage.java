package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ProductsPage {

    WebDriver driver;
    WebDriverWait wait;

    // ---------- Locators ----------
    By allProductsTitle =
            By.xpath("//h2[contains(text(),'All Products')]");

    By firstViewProductBtn =
            By.xpath("(//a[contains(text(),'View Product')])[1]");

    By productDetailsTitle =
            By.xpath("//h2[contains(text(),'Blue Top')]");

    By searchInput =
            By.id("search_product");

    By searchBtn =
            By.id("submit_search");

    By searchedProductsTitle =
            By.xpath("//h2[contains(text(),'Searched Products')]");

    By firstAddToCartBtn =
            By.xpath("(//a[contains(text(),'Add to cart')])[1]");

    By secondAddToCartBtn =
            By.xpath("(//a[contains(text(),'Add to cart')])[2]");

    By viewCartBtn =
            By.xpath("//u[contains(text(),'View Cart')]");

    By cartPageTitle =
            By.xpath("//li[contains(text(),'Shopping Cart')]");
    By firstBrand = By.xpath("(//div[@class='brands_products']//a)[1]");
    By secondBrand = By.xpath("(//div[@class='brands_products']//a)[2]");
    By nameReview = By.id("name");
    By emailReview = By.id("email");
    By reviewText = By.id("review");
    By submitReviewBtn = By.id("button-review");
    By reviewSuccess = By.xpath("//span[contains(text(),'Thank you for your review.')]");

    public void addReview(String name, String email, String review) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameReview)).sendKeys(name);
        driver.findElement(emailReview).sendKeys(email);
        driver.findElement(reviewText).sendKeys(review);
        driver.findElement(submitReviewBtn).click();
    }

    public boolean isReviewSuccessVisible() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(reviewSuccess)
        ).isDisplayed();
    }

    public void openFirstBrand() {
        wait.until(ExpectedConditions.elementToBeClickable(firstBrand)).click();
    }

    public void openSecondBrand() {
        wait.until(ExpectedConditions.elementToBeClickable(secondBrand)).click();
    }

    // ---------- Constructor ----------
    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ---------- Methods ----------

    public void goToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(viewCartBtn)).click();
    }

    public boolean isAllProductsVisible() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(allProductsTitle)
        ).isDisplayed();
    }

    public void openFirstProduct() {
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(firstViewProductBtn)
        );

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", element);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", element);
    }

    public boolean isProductDetailsVisible() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(productDetailsTitle)
        ).isDisplayed();
    }

    public void searchProduct(String productName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchInput))
                .sendKeys(productName);
        driver.findElement(searchBtn).click();
    }

    public boolean isSearchedProductsVisible() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(searchedProductsTitle)
        ).isDisplayed();
    }

    public void addFirstProductToCart() {
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(firstAddToCartBtn)
        );

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", element);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", element);
    }

    public void addSecondProductToCart() {

        WebElement product =
                wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("(//div[@class='product-image-wrapper'])[2]")
                ));

        Actions actions = new Actions(driver);
        actions.moveToElement(product).perform();

        WebElement addBtn =
                wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("(//a[contains(text(),'Add to cart')])[2]")
                ));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", addBtn);
    }


    public void openCart() {
        wait.until(
                ExpectedConditions.elementToBeClickable(viewCartBtn)
        ).click();
    }

    public boolean isCartVisible() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(cartPageTitle)
        ).isDisplayed();
    }
}
