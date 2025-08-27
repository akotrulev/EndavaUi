package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public WebElement continueShopping() {
        return findElement(By.cssSelector("[data-test='continue-shopping']"));
    }

    public WebElement checkout() {
        return findElement(By.cssSelector("[data-test='checkout']"));
    }

    public List<ProductCard> productCards() {
        ArrayList<ProductCard> productCards = new ArrayList<>();
        findElements(By.cssSelector("[data-test='inventory-item']")).forEach(webElement -> {
            productCards.add(new ProductCard(driver, webElement));
        });
        return productCards;
    }

}
