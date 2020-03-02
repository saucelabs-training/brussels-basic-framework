package test.java.com.saucelabs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
    }

    void click(By locator) {
        while (true) {
            try {
                driver.findElement(locator).click();
                return;
            } catch (NoSuchElementException e) {
                waitForElement(locator);
            }
        }
    }

    void sendKeys(By locator, String text) {
        while (true) {
            try {
                driver.findElement(locator).sendKeys(text);
                return;
            } catch (NoSuchElementException e) {
                waitForElement(locator);
            }
        }
    }

    boolean exists(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    private void waitForElement(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
