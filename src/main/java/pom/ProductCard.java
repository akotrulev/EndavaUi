package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductCard extends BasePage {
    private WebElement parent;

    public ProductCard(WebDriver driver, WebElement parent) {
        super(driver);
        this.parent = parent;
    }

    private String toLocatorFormat(String name) {
        return name.replace(" ", "-").toLowerCase();
    }


    public WebElement name() {
        return findElement(By.cssSelector("[data-test='inventory-item-name']"), parent);
    }

    public WebElement description() {
        return findElement(By.cssSelector("[data-test='inventory-item-desc']"), parent);
    }

    public WebElement price() {
        return findElement(By.cssSelector("[data-test='inventory-item-price']"), parent);
    }

    public WebElement addToCart() {
        return findElement(By.cssSelector(String.format("[data-test='add-to-cart-%s']", toLocatorFormat(name().getText()))));
    }

    public WebElement removeButton() {
        return findElement(By.cssSelector(String.format("[data-test='remove-%s']", toLocatorFormat(name().getText()))));
    }
}
