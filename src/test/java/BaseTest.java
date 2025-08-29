
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pom.LoginPage;
import utility.DriverFactory;

import java.util.List;


public class BaseTest {
    protected WebDriver driver;

    protected static List<String> users;
    protected static String password;

    @BeforeSuite(alwaysRun = true)
    public void getCredentials() {
        DriverFactory.setDriver();

        WebDriver localDriver =  DriverFactory.getDriver();
        LoginPage loginPage = new LoginPage(localDriver);
        loginPage.goToPage();
        users = loginPage.defaultUsers();
        password = loginPage.defaultPassword();
        DriverFactory.quitDriver();
    }

    @BeforeMethod(alwaysRun = true)
    public void startDriver() {
        DriverFactory.setDriver();
        driver = DriverFactory.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void quitDriver() {
        DriverFactory.quitDriver();
    }
}
