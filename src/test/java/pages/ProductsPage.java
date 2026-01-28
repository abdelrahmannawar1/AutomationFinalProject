package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductsPage {

    WebDriver driver;
    WebDriverWait wait;

    By allProductsText = By.xpath("//h2[contains(text(),'All Products')]");
    By firstViewProduct = By.xpath("(//a[contains(text(),'View Product')])[1]");
    By searchInput = By.id("search_product");
    By searchBtn = By.id("submit_search");
    By searchedProductsText = By.xpath("//h2[contains(text(),'Searched Products')]");
    By firstAddToCart = By.xpath("(//a[contains(text(),'Add to cart')])[1]");
    By secondAddToCart = By.xpath("(//a[contains(text(),'Add to cart')])[2]");
    By continueShoppingBtn = By.xpath("//button[contains(text(),'Continue Shopping')]");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isAllProductsVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(allProductsText)).isDisplayed();
    }

    public void openFirstProduct() {
        wait.until(ExpectedConditions.elementToBeClickable(firstViewProduct)).click();
    }

    public void searchProduct(String productName) {
        driver.findElement(searchInput).sendKeys(productName);
        driver.findElement(searchBtn).click();
    }

    public boolean isSearchedProductsVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(searchedProductsText)).isDisplayed();
    }

    public void addFirstProductToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(firstAddToCart)).click();
        wait.until(ExpectedConditions.elementToBeClickable(continueShoppingBtn)).click();
    }

    public void addSecondProductToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(secondAddToCart)).click();
    }
}
