package pom.checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.BasePage;
import pom.NavigationMenu;

public class CompleteOrderPage extends BasePage {
    public NavigationMenu navigationMenu;

    public CompleteOrderPage(WebDriver driver) {
        super(driver);
        navigationMenu = new NavigationMenu(driver);
    }
    public WebElement completeHeader() {
        return findElement(By.cssSelector("[data-test='complete-header']"));
    }

    public WebElement successIcon() {
        return findElement(By.cssSelector("[data-test='pony-express']"));
    }

    public WebElement completeText() {
        return findElement(By.cssSelector("[data-test='complete-text']"));
    }

    public WebElement backToProducts() {
        return findElement(By.cssSelector("[data-test='back-to-products']"));
    }

    public WebElement title() {
        return findElement(By.cssSelector("[data-test='title']"));
    }
}
