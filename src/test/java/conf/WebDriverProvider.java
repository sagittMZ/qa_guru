package conf;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.function.Supplier;

public class WebDriverProvider  implements Supplier<WebDriver> {

    @Override
    public WebDriver get() {
        //initial
        final WebDriverConfig config = ConfigFactory.newInstance().create(WebDriverConfig.class);
        if (config.remote()) {
            return new RemoteWebDriver(config.remoteURL(), DesiredCapabilities.chrome());
        } else {
            switch (config.browserName()) {
                case CHROME:
                    WebDriverManager.chromedriver().setup();
                    return new ChromeDriver();
                case FIREFOX:
                    WebDriverManager.firefoxdriver().setup();
                    return new FirefoxDriver();
                default:
                    throw new RuntimeException("Unknown browser name: " + config.browserName());
            }
        }
    }

    private String getBrowserName(){
        return System.getProperty("browser.name","chrome");
    }
}
