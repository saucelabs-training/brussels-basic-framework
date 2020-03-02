package test.java.com.saucelabs.base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class TestEagerSauce {
    protected WebDriver driver;

    @BeforeEach
    public void setup() throws MalformedURLException {

        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setCapability("platformName", "Windows 10");
        browserOptions.setCapability("browserVersion", "80.0");
        browserOptions.setPageLoadStrategy(PageLoadStrategy.NONE);

        URL url = new URL("https://" + getUsername() + ":" + getAccessKey() + "@ondemand.saucelabs.com/wd/hub");

        driver = new RemoteWebDriver(url, browserOptions);
    }

    private static String getUsername() {
        return System.getenv("SAUCE_USERNAME");
    }

    private static String getAccessKey() {
        return System.getenv("SAUCE_ACCESS_KEY");
    }

    @AfterEach
    public void teardown() {
        driver.quit();
    }
}
