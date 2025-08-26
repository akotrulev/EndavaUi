package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public WebElement itemCard() {
        return findElement(By.cssSelector("[data-test='inventory-item']"));
    }

    public WebElement cart() {
        return findElement(By.cssSelector("[data-test='shopping-cart-link']"));
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

    public WebElement menuButton() {
        return findElement(By.id("react-burger-menu-btn"));
    }
}
