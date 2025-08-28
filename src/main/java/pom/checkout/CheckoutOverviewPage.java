package pom.checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.BasePage;
import pom.NavigationMenu;
import pom.ProductCard;

import java.util.ArrayList;
import java.util.List;

public class CheckoutOverviewPage extends BasePage {
    public NavigationMenu navigationMenu;

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
        navigationMenu = new NavigationMenu(driver);
    }

    public List<ProductCard> productCards() {
        ArrayList<ProductCard> productCards = new ArrayList<>();
        findElements(By.cssSelector("[data-test='inventory-item']")).forEach(webElement -> {
            productCards.add(new ProductCard(driver, webElement));
        });
        return productCards;
    }

    public WebElement payment() {
        return findElement(By.cssSelector("[data-test='payment-info-value']"));
    }

    public WebElement shipping() {
        return findElement(By.cssSelector("[data-test='shipping-info-value']"));
    }

    public WebElement subtotal() {
        return findElement(By.cssSelector("[data-test='subtotal-label']"));
    }

    public WebElement tax() {
        return findElement(By.cssSelector("[data-test='tax-label']"));
    }

    public WebElement total() {
        return findElement(By.cssSelector("[data-test='total-label']"));
    }

    public WebElement cancel() {
        return findElement(By.cssSelector("[data-test='cancel']"));
    }

    public WebElement finish() {
        return findElement(By.cssSelector("[data-test='finish']"));
    }
}
