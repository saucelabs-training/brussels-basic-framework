package test.java.com.saucelabs.pages;

import org.openqa.selenium.*;
import test.java.com.saucelabs.data.User;

public class HomePage extends BasePage {

    private By username = By.id("user-name");
    private By password = By.id("password");
    private By submit = By.className("btn_action");
    private By error = By.cssSelector("[data-test=error]");
    static private String url = "https://www.saucedemo.com/";

    public static HomePage visit(WebDriver driver) {
        driver.get(url);
        return new HomePage(driver);
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void signInSuccessfully(User user) throws Exception {
        signIn(user);
        try {
            wait.until(x -> !isOnPage());
        } catch (TimeoutException e) {
            String errorMessage = driver.findElement(error).getText();
            throw new Exception("Expected Form to be submitted, but it was not; found error: \"" + errorMessage + "\"");
        }
    }

    public void signIn(User user) {
        sendKeys(this.username, user.getUsername());
        sendKeys(this.password, user.getPassword());
        click(this.submit);
    }

    public boolean isOnPage() {
        return driver.getCurrentUrl().equals(url);
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
