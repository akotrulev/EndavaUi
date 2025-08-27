package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavigationMenu extends BasePage {
    public NavigationMenu(WebDriver driver) {
        super(driver);
    }

    public WebElement menuButton() {
        return findElement(By.id("react-burger-menu-btn"));
    }

    public WebElement inventory() {
        return findElement(By.cssSelector("[data-test='inventory-sidebar-link']"));
    }

    public WebElement about() {
        return findElement(By.cssSelector("[data-test='about-sidebar-link']"));
    }

    public WebElement logout() {
        return findElement(By.cssSelector("[data-test='logout-sidebar-link']"));
    }

    public WebElement reset() {
        return findElement(By.cssSelector("[data-test='reset-sidebar-link']"));
    }

    public WebElement closeButton() {
        return findElement(By.id("react-burger-cross-btn"));
    }

    public WebElement error() {
        return findElement(By.cssSelector("[data-test='error']"));
    }
}
