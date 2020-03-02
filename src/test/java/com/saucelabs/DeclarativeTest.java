package test.java.com.saucelabs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import test.java.com.saucelabs.base.TestBase;
import test.java.com.saucelabs.data.User;
import test.java.com.saucelabs.pages.HomePage;
import test.java.com.saucelabs.pages.InventoryPage;

class DeclarativeTest extends TestBase {
    @Test
    @DisplayName("Declarative Test")
    void declarative() {
        User user = User.valid();
        HomePage homePage = HomePage.visit(driver);
        homePage.signIn(user);

        InventoryPage inventoryPage = new InventoryPage(driver);
        Assertions.assertTrue(inventoryPage.isOnPage());
    }
}
