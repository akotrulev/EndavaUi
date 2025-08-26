package utility;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class DriverManager {
    protected static BrowserTypeEnumDriverManager browserType;
    protected WebDriver driver;

    public DriverManager() {
        SystemPropertyUtil.loadAllPropsFromFiles();
        browserType = BrowserTypeEnumDriverManager.valueOf(SystemPropertyUtil.getBrowserType());
        driver = browserType.getRemoteWebDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void quitDriver() {
        driver.close();
        driver.quit();
    }
}
