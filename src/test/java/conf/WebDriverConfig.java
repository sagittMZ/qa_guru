package conf;

import org.aeonbits.owner.Config;

import java.net.URL;

@Config.Sources({
        "system.properties", //high priority
        "classpath:default.properties"
})
public interface WebDriverConfig extends Config {

    @DefaultValue("false")
    @Key("webdriver.remote")
    boolean remote();

    @DefaultValue("https://localhost:4444/wd/hub")
    @Key("webdriver.remote.url")
    URL remoteURL();

    @DefaultValue("CHROME")
    @Key("webdriver.browser.name")
    BrowserName browserName();

}
