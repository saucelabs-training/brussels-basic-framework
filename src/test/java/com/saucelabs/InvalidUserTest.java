package test.java.com.saucelabs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import test.java.com.saucelabs.base.TestEager;
import test.java.com.saucelabs.data.User;
import test.java.com.saucelabs.pages.HomePage;
import test.java.com.saucelabs.pages.InventoryPage;

class InvalidUserTest extends TestEager {
    @Test
    @DisplayName("Expecting Success From Invalid User")
    void opinionated() {
        User user = User.invalid();
        HomePage homePage = HomePage.visit(driver);
        homePage.signInSuccessfully(user);

        InventoryPage inventoryPage = new InventoryPage(driver);
        Assertions.assertTrue(inventoryPage.isOnPage());
    }
}
