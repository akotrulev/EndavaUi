
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pom.LoginPage;
import utility.DriverManager;

import java.util.List;


public class BaseTest {
    private DriverManager driverManager;
    protected WebDriver driver;

    protected List<String> users;
    protected String password;

    @BeforeSuite
    public void getCredentials() {
        WebDriver localDriver = new DriverManager().getDriver();
        LoginPage loginPage = new LoginPage(localDriver);
        loginPage.goToPage();
        users = loginPage.defaultUsers();
        password = loginPage.defaultPassword();
        localDriver.quit();
    }

    @BeforeMethod
    public void startDriver() {
       driverManager = new DriverManager();
       driver = driverManager.getDriver();
    }

    @AfterMethod
    public void quitDriver() {
        driverManager.quitDriver();
    }
}
