package test.java.com.saucelabs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends BasePage {
    private By inventoryContainer = By.id("inventory_container");


    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public Boolean isOnPage() {
        return exists(this.inventoryContainer);
    }
}
