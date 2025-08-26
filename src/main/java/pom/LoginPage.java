package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public WebElement username() {
        return findElement(By.id("user-name"));
    }

    public WebElement password() {
        return findElement(By.id("password"));
    }

    public WebElement errorBox() {
        return findElement(By.className("error-message-container"));
    }

    public WebElement loginButton() {
        return findElement(By.cssSelector("[data-test='login-button']"));
    }

    public WebElement defaultUsers() {
        return findElement(By.cssSelector("[data-test='login-credentials']"));
    }

    public WebElement defaultPassword() {
        return findElement(By.cssSelector("[data-test='login-password']"));
    }


}
