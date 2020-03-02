package test.java.com.saucelabs;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import test.java.com.saucelabs.data.User;

class AbstractDataTest {
    protected WebDriver driver;

    @BeforeEach
    public void setup() {
        System.setProperty("wdm.targetPath", "lib/drivers/auto/");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterEach
    public void teardown() {
        driver.quit();
    }

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
