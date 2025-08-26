
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utility.DriverManager;


public class BaseTest {
    protected DriverManager driverManager;
    protected WebDriver webDriver;

    @BeforeMethod
    public void startDriver() {
       driverManager = new DriverManager();
       webDriver = driverManager.getDriver();
    }

    @AfterMethod
    public void quitDriver() {
        driverManager.quitDriver();
    }
}
