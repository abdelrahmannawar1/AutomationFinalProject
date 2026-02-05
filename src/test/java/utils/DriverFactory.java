package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    public static WebDriver initDriver() {

        ChromeOptions options = new ChromeOptions();

        // يقفل الإشعارات
        options.addArguments("--disable-notifications");

        // يقفل البوب أب
        options.addArguments("--disable-popup-blocking");

        // يمنع تحميل الصور (يساعد يقلل الإعلانات)
        options.addArguments("--blink-settings=imagesEnabled=false");

        // يقلل الإعلانات
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-gpu");

        // ده مهم جداً
        options.addArguments("--disable-features=IsolateOrigins,site-per-process");
        options.addArguments("--host-resolver-rules=MAP googleads.g.doubleclick.net 127.0.0.1");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();

        return driver;
    }
}
