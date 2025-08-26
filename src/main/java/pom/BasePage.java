package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BasePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isElementVisible(By locator) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public void click(By locator) {
        findElement(locator).click();
    }

    public void typeText(By locator, String text) {
        findElement(locator).sendKeys(text);
    }

    public String getText(By locator) {
        return findElement(locator).getText();
    }
}
