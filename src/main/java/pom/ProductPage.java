package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public List<ProductCard> productCards() {
        ArrayList<ProductCard> productCards = new ArrayList<>();
        findElements(By.cssSelector("[data-test='inventory-item']")).forEach(webElement -> {
            productCards.add(new ProductCard(driver, webElement));
        });
        return productCards;
    }

    public WebElement cart() {
        return findElement(By.cssSelector("[data-test='shopping-cart-link']"));
    }

    public WebElement cartBadge() {
        return findElement(By.cssSelector("[data-test='shopping-cart-badge']"));
    }

    public WebElement filterDropdown() {
        return findElement(By.cssSelector("[data-test='active-option']"));
    }

    public WebElement az() {
        return findElement(By.cssSelector("[data-test='product-sort-container'] [value='az']"));
    }

    public WebElement za() {
        return findElement(By.cssSelector("[data-test='product-sort-container'] [value='za']"));
    }

    public WebElement loHi() {
        return findElement(By.cssSelector("[data-test='product-sort-container'] [value='lohi']"));
    }

    public WebElement hiLo() {
        return findElement(By.cssSelector("[data-test='product-sort-container'] [value='hilo']"));
    }
}
