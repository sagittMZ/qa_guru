package tests;

import com.codeborne.selenide.Configuration;
import conf.IssueConfig;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static helpers.AttachmentsHelper.*;

public class TestBase {
    @BeforeAll
    static void setup() {
        addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
        IssueConfig config = ConfigFactory.newInstance().create(IssueConfig.class);
        String selenoidUrl = config.selenoidUrl();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);  // add ui visibility fot user during the test - running
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;
          //command to run: gradle test -Dremote.browser.url=selenoid.autotests.cloud + requared add to build.gradle in test part this:
          //test {
          //    systemProperties = System.properties
          //    useJUnitPlatform()
          //}
        //Configuration.remote = "https://user1:1234@" + selenoidUrl+ ":4444/wd/hub/";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud:4444/wd/hub/";
        Configuration.browserVersion = "85.0";
        Configuration.startMaximized = true;



    }
//
//    @BeforeEach
//    public void initDriver(){
//        driver = new conf.WebDriverProvider().get();
//    }

    @AfterEach
    @Step("Attachments")
    public void afterEach(){
        attachScreenshot("Last screenshot");
        attachPageSource();
        attachAsText("Browser console logs", getConsoleLogs());
        attachVideo();


        closeWebDriver();
    }


}