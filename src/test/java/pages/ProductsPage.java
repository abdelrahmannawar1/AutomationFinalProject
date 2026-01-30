package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;

public class ProductsPage {

    WebDriver driver;
    WebDriverWait wait;

    // ---------- Locators ----------
    By allProductsTitle =
            By.xpath("//h2[contains(text(),'All Products')]");

    By firstViewProduct =
            By.xpath("(//a[contains(text(),'View Product')])[1]");
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


    public void goToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(viewCartBtn)).click();
    }

    // ---------- Constructor ----------
    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ---------- TC08 ----------
    public boolean isAllProductsVisible() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(allProductsTitle)
        ).isDisplayed();
    }

    public void openFirstProduct() {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // scroll للعنصر
        js.executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                wait.until(ExpectedConditions.visibilityOfElementLocated(firstViewProductBtn))
        );

        // JS click لتجاوز الإعلانات
        js.executeScript(
                "arguments[0].click();",
                driver.findElement(firstViewProductBtn)
        );
    }


    public boolean isProductDetailsVisible() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(productDetailsTitle)
        ).isDisplayed();
    }

    // ---------- TC09 ----------
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

    // ---------- TC12 ----------
    public void addFirstProductToCart() {
        wait.until(
                ExpectedConditions.elementToBeClickable(firstAddToCartBtn)
        ).click();
    }

    public void addSecondProductToCart() {
        wait.until(
                ExpectedConditions.elementToBeClickable(secondAddToCartBtn)
        ).click();
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
