package utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.VoidDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.function.Consumer;
import java.util.function.Supplier;

public enum BrowserTypeEnumDriverManager {
    CHROME(Browser.CHROME.browserName(), ChromeDriver::new, (WebDriverManager) -> io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup()),
    FIREFOX(Browser.FIREFOX.browserName(), FirefoxDriver::new, (WebDriverManager) -> io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver().setup()),
    EDGE(Browser.EDGE.browserName(), EdgeDriver::new, (WebDriverManager) -> io.github.bonigarcia.wdm.WebDriverManager.edgedriver().setup()),
    SAFARI(Browser.SAFARI.browserName(), SafariDriver::new, (WebDriverManager) -> io.github.bonigarcia.wdm.WebDriverManager.chromiumdriver().setup());

    BrowserTypeEnumDriverManager(String browserType, Supplier<RemoteWebDriver> remoteWebDriver, Consumer<WebDriverManager> webDriverManagerConsumer) {
        this.browserType = browserType;
        this.remoteWebDriver = remoteWebDriver;
        this.webDriverManagerConsumer = webDriverManagerConsumer;
    }

    private String browserType;
    private Supplier<RemoteWebDriver> remoteWebDriver;
    private Consumer<WebDriverManager> webDriverManagerConsumer;
    private RemoteWebDriver webDriver;

    public String getBrowserType() {
        return browserType;
    }

    public Consumer<WebDriverManager> getWebDriverManagerConsumer() {
        return webDriverManagerConsumer;
    }

    public RemoteWebDriver getRemoteWebDriver() {
        this.webDriverManagerConsumer.accept(new VoidDriverManager());
        if(webDriver == null) {
            webDriver = this.remoteWebDriver.get();
            webDriver.manage().window().maximize();
        }

        return webDriver;
    }
}
