import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pom.LoginPage;
import pom.ProductPage;

public class CheckoutTest extends BaseTest {

    @Test(testName = "Scenario 1", groups = "regression")
    public void validCheckoutFlow() {
        ProductPage productPage = new LoginPage(driver).successfulLogin(users.getFirst(), password);
        productPage.productCards().getFirst().addToCart().click();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(productPage.cartBadge().getText(), "1");
        productPage.productCards().getLast().addToCart().click();
        softAssert.assertEquals(productPage.cartBadge().getText(), "2");

        softAssert.assertAll();
    }
}
