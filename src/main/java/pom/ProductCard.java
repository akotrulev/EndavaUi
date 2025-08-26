package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductCard extends BasePage {
    public ProductCard(WebDriver driver) {
        super(driver);
    }

    private String toLocatorFormat(String name) {
        return name.replace(" ", "-").toLowerCase();
    }


    public WebElement name() {
        return findElement(By.cssSelector("[data-test='inventory-item-name']"));
    }

    public WebElement description() {
        return findElement(By.cssSelector("[data-test='inventory-item-desc']"));
    }

    public WebElement price() {
        return findElement(By.cssSelector("[data-test='inventory-item-price']"));
    }

    public WebElement addToCart() {
        return findElement(By.cssSelector("[data-test='add-to-cart-sauce-labs-bike-light']"));
    }

    public WebElement removeButton(String itemName) {
        return findElement(By.cssSelector(String.format("[data-test='remove-%s']", toLocatorFormat(itemName))));
    }
}
