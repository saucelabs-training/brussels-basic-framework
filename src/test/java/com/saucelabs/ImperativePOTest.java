package test.java.com.saucelabs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import test.java.com.saucelabs.base.TestBase;
import test.java.com.saucelabs.data.User;
import test.java.com.saucelabs.pages.HomePage;

class ImperativePOTest extends TestBase {
    @Test
    @DisplayName("Imperative Page Object Test")
    void imperativePO() {
        driver.get("https://www.saucedemo.com/");

        User user = User.valid();
        HomePage homePage = new HomePage(driver);

        homePage.getUsername().sendKeys(user.getUsername());
        homePage.getPassword().sendKeys(user.getPassword());
        homePage.getSubmit().click();

        Assertions.assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
    }
}
