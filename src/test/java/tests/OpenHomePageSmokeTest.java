package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.JsonDataReader;

public class OpenHomePageSmokeTest extends BaseTest {

    @Test
    public void openHomePage() {

        JsonDataReader.loadJsonFile("testdata/users.json");

        String email = JsonDataReader.getData("loginUser", "email");

        String title = driver.getTitle();

        Assert.assertFalse(title.isEmpty());
        Assert.assertTrue(title.contains("Automation Exercise"));
    }

}