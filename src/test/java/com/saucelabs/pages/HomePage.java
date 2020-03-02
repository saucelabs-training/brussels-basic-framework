package test.java.com.saucelabs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private WebDriver driver;
    private By username = By.id("user-name");
    private By password = By.id("password");
    private By submit = By.className("btn_action");

    public HomePage(WebDriver driver) {
        this.driver = driver;
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
