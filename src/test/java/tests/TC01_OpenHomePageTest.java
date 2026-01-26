package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.JsonDataReader;

public class TC01_OpenHomePageTest extends BaseTest {

   @Test
public void openHomePage() {

    JsonDataReader.loadJsonFile("testdata/users.json");
    String email = JsonDataReader.getData("validUser", "email");
    System.out.println("Email from JSON = " + email);

    try {
        Thread.sleep(2000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    String title = driver.getTitle();
    System.out.println("Title = " + title);

    Assert.assertFalse(title.isEmpty(), "Title is empty, page might not be loaded!");
    Assert.assertTrue(title.contains("Automation Exercise"));
}
}