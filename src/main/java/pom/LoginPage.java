package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.SystemPropertyUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void goToPage() {
        navigateToUrl(SystemPropertyUtil.getBaseUiUrl());
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

    public List<String> defaultUsers() {
        WebElement element = findElement(By.cssSelector("[data-test='login-credentials']"));
        List<String> users = new ArrayList<>(Arrays.asList(element.getText().split("\n")));
        users.removeFirst(); // remove first element
        return users;
    }

    public String defaultPassword() {
        return new ArrayList<>(
                Arrays.asList(
                        findElement(By.cssSelector("[data-test='login-password']")).getText().split("\n")
                )
        ).getLast();
    }

    public ProductPage successfulLogin(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToPage();
        loginPage.username().sendKeys(username);
        loginPage.password().sendKeys(password);
        loginPage.loginButton().click();

        return new ProductPage(driver);
    }
}
