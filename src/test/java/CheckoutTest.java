import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pom.CartPage;
import pom.LoginPage;
import pom.ProductCard;
import pom.ProductPage;
import pom.checkout.CheckoutInformationPage;
import pom.checkout.CheckoutOverviewPage;
import pom.checkout.CompleteOrderPage;

import java.util.ArrayList;
import java.util.List;

public class CheckoutTest extends BaseTest {

    @Test(testName = "Scenario 1", groups = "regression")
    public void validCheckoutFlow() {
        // Login
        ProductPage productPage = new LoginPage(driver).successfulLogin(users.getFirst(), password);
        List<ProductCard> productCards= productPage.productCards();
        List<ProductCard> selectedItems= new ArrayList<>();
        SoftAssert softAssert = new SoftAssert();

        // Add first item
        productCards.getFirst().addToCart().click();
        softAssert.assertEquals(productPage.navigationMenu.cartBadge().getText(), "1", "First item not added");
        softAssert.assertTrue(productCards.getFirst().removeButton().isDisplayed());
        selectedItems.addLast(productCards.getFirst());

        // Add last item
        productCards.getLast().addToCart().click();
        softAssert.assertTrue(productCards.getLast().removeButton().isDisplayed());
        softAssert.assertEquals(productPage.navigationMenu.cartBadge().getText(), "2", "Last item not added");
        selectedItems.addLast(productCards.getLast());

        // Remove first item
        productCards.getFirst().removeButton().click();
        softAssert.assertEquals(productPage.navigationMenu.cartBadge().getText(), "1");
        softAssert.assertTrue(productCards.getFirst().addToCart().isDisplayed());
        selectedItems.remove(productCards.getFirst());

        // Add second to last item
        productCards.get(productCards.size()-2).addToCart().click();
        softAssert.assertEquals(productPage.navigationMenu.cartBadge().getText(), "2");
        selectedItems.addLast(productCards.get(productCards.size()-2));

        // Extract names for all selected products
        List<String> selectedProductNames = selectedItems.stream()
                .map(card -> card.name().getText())
                .toList();

        // Go to cart
        productPage.navigationMenu.cart().click();

        // Extract names for all products in cart
        CartPage cartPage = new CartPage(driver);
        List<String> productInCartNames = cartPage.productCards().stream()
                .map(card -> card.name().getText())
                .toList();

        // Assert they are the same
        for (String item : selectedProductNames) {
            softAssert.assertTrue(
                    productInCartNames.contains(item),
                    "Cart does not contain expected item with name: " + item
            );
        }

        cartPage.checkout().click();

        CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage(driver);
        checkoutInformationPage.firstName().sendKeys("Aleksandar");
        checkoutInformationPage.lastName().sendKeys("Kotrulev");
        checkoutInformationPage.zipCode().sendKeys("4000");
        checkoutInformationPage.continueButton().click();

        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);

        // Extract names for all products in overview
        List<String> productInOverviewNames = checkoutOverviewPage.productCards().stream()
                .map(card -> card.name().getText())
                .toList();

        // Assert they are the same
        for (String item : selectedProductNames) {
            softAssert.assertTrue(
                    productInOverviewNames.contains(item),
                    "Overview does not contain expected item with name: " + item
            );
        }

        // Verify checkout page
        checkoutOverviewPage.finish().click();
        CompleteOrderPage completeOrderPage = new CompleteOrderPage(driver);
        softAssert.assertTrue(completeOrderPage.successIcon().isDisplayed());
        softAssert.assertEquals(completeOrderPage.title().getText(), "Checkout: Complete!");
        softAssert.assertEquals(completeOrderPage.completeHeader().getText(), "Thank you for your order!");
        softAssert.assertEquals(completeOrderPage.completeText().getText(), "Your order has been dispatched, and will arrive just as fast as the pony can get there!");
        softAssert.assertTrue(completeOrderPage.backToProducts().isDisplayed());

        // Verify cart is empty
        softAssert.assertEquals(completeOrderPage.navigationMenu.cart().getText(), "");

        completeOrderPage.navigationMenu.menuButton().click();
        completeOrderPage.navigationMenu.logout().click();
        LoginPage loginPage = new LoginPage(driver);
        softAssert.assertTrue(loginPage.username().isDisplayed());
        softAssert.assertTrue(loginPage.password().isDisplayed());
        softAssert.assertTrue(loginPage.loginButton().isDisplayed());
        softAssert.assertAll();
    }
}
