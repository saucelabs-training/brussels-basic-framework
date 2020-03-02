package test.java.com.saucelabs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.java.com.saucelabs.data.User;

public class HomePage extends BasePage {

    private By username = By.id("user-name");
    private By password = By.id("password");
    private By submit = By.className("btn_action");

    public static HomePage visit(WebDriver driver) {
        driver.get("https://www.saucedemo.com/");
        return new HomePage(driver);
    }

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void signIn(User user) {
        sendKeys(this.username, user.getUsername());
        sendKeys(this.password, user.getPassword());
        click(this.submit);
    }

    public WebElement getUsername() {
        return driver.findElement(this.username);
    }

    public WebElement getPassword() {
        return driver.findElement(this.password);
    }

    public WebElement getSubmit() {
        return driver.findElement(this.submit);
    }
}
