import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pom.LoginPage;
import pom.ProductCard;
import pom.ProductPage;

import java.util.List;

public class NavigationTest  extends BaseTest {

    @Test(description = "Scenario 2", groups = "Smoke")
    public void sortProducts(){
        // Login
        ProductPage productPage = new LoginPage(driver).successfulLogin(users.getFirst(), password);
        SoftAssert softAssert = new SoftAssert();

        // Apply filter
        productPage.filterDropdown().click();
        productPage.hiLo().click();

        // Get products
        List<ProductCard> productCards = productPage.productCards();

        // Verify order
        List<Double> productPricesInOrder = productCards.stream()
                .map(card -> Double.parseDouble(card.price().getText().substring(1)))
                .toList();

        for (int i = 0; i < productPricesInOrder.size()-1; i++) {
            softAssert.assertTrue(productPricesInOrder.get(i)>=productPricesInOrder.get(i+1));
        }

        // Logout
        productPage.navigationMenu.menuButton().click();
        productPage.navigationMenu.logout().click();
        LoginPage loginPage = new LoginPage(driver);
        softAssert.assertTrue(loginPage.username().isDisplayed());
        softAssert.assertTrue(loginPage.password().isDisplayed());
        softAssert.assertTrue(loginPage.loginButton().isDisplayed());

        softAssert.assertAll();
    }
}
