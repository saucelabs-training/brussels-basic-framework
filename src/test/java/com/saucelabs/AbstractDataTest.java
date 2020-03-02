package test.java.com.saucelabs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import test.java.com.saucelabs.base.TestBase;
import test.java.com.saucelabs.data.User;

class AbstractDataTest extends TestBase {
    @Test
    @DisplayName("Abstract Data Test")
    void abstractData() {
        driver.get("https://www.saucedemo.com/");

        User user = User.valid();

        driver.findElement(By.id("user-name")).sendKeys(user.getUsername());
        driver.findElement(By.id("password")).sendKeys(user.getPassword());
        driver.findElement(By.className("btn_action")).click();

        Assertions.assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
    }
}
