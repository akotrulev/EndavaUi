package pom.checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.BasePage;
import pom.NavigationMenu;

public class CheckoutInformationPage extends BasePage {
    public NavigationMenu navigationMenu;

    public CheckoutInformationPage(WebDriver driver) {
        super(driver);
        navigationMenu = new NavigationMenu(driver);
    }

    public WebElement firstName() {
        return findElement(By.cssSelector("[data-test='firstName']"));
    }

    public WebElement lastName() {
        return findElement(By.cssSelector("[data-test='lastName']"));
    }

    public WebElement zipCode() {
        return findElement(By.cssSelector("[data-test='postalCode']"));
    }

    public WebElement cancel() {
        return findElement(By.cssSelector("[data-test='cancel']"));
    }

    public WebElement continueButton() {
        return findElement(By.cssSelector("[data-test='continue']"));
    }
}
