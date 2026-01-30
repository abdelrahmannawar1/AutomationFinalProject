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

    public void fillAccountInformation() {

        driver.findElement(By.id("password")).sendKeys("123456");

        driver.findElement(By.id("first_name")).sendKeys("Test");
        driver.findElement(By.id("last_name")).sendKeys("User");
        driver.findElement(By.id("address1")).sendKeys("Cairo");
        driver.findElement(By.id("state")).sendKeys("Cairo");
        driver.findElement(By.id("city")).sendKeys("Cairo");
        driver.findElement(By.id("zipcode")).sendKeys("12345");
        driver.findElement(By.id("mobile_number")).sendKeys("01000000000");

        driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();
    }


}
