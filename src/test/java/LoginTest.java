import org.testng.Assert;
import org.testng.annotations.Test;
import pom.LoginPage;
import pom.ProductPage;

public class LoginTest extends BaseTest {

    @Test
    public void successfulLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToPage();
        loginPage.username().sendKeys(users.getFirst());
        loginPage.password().sendKeys(password);
        loginPage.loginButton().click();

        ProductPage productPage = new ProductPage(driver);
        Assert.assertTrue(productPage.cart().isDisplayed(), "Cart button not visible after login attempt.");
    }
}
