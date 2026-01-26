package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AccountInformationPage {

    WebDriver driver;

    private By titleMrRadio = By.id("id_gender1");
    private By passwordInput = By.id("password");

    private By daysSelect = By.id("days");
    private By monthsSelect = By.id("months");
    private By yearsSelect = By.id("years");

    private By firstNameInput = By.id("first_name");
    private By lastNameInput = By.id("last_name");
    private By address1Input = By.id("address1");
    private By countrySelect = By.id("country");
    private By stateInput = By.id("state");
    private By cityInput = By.id("city");
    private By zipcodeInput = By.id("zipcode");
    private By mobileNumberInput = By.id("mobile_number");

    private By createAccountBtn = By.xpath("//button[@data-qa='create-account']");

    public AccountInformationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillAccountInfoAndCreate(String password) {

        // Title
        driver.findElement(titleMrRadio).click();

        // Password
        driver.findElement(passwordInput).sendKeys(password);

        // DOB (اختيار أي قيم)
        new Select(driver.findElement(daysSelect)).selectByVisibleText("10");
        new Select(driver.findElement(monthsSelect)).selectByVisibleText("May");
        new Select(driver.findElement(yearsSelect)).selectByVisibleText("2000");

        // Address Info
        driver.findElement(firstNameInput).sendKeys("Abdelrahman");
        driver.findElement(lastNameInput).sendKeys("Nawar");
        driver.findElement(address1Input).sendKeys("Zagazig Street 10");

        new Select(driver.findElement(countrySelect)).selectByVisibleText("Canada");

        driver.findElement(stateInput).sendKeys("Zagazig");
        driver.findElement(cityInput).sendKeys("Sharqia");
        driver.findElement(zipcodeInput).sendKeys("12345");
        driver.findElement(mobileNumberInput).sendKeys("01000000000");

        // Create Account
        driver.findElement(createAccountBtn).click();
    }
}
