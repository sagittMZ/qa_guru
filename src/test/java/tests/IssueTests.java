package tests;

import Utils.BaseMethods;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.IOException;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class IssueTests extends BaseMethods {

    private static String repository = "https://github.com/sagittMZ/qa_guru";
    @BeforeAll
     static void setup() {
        Configuration.startMaximized = true;
        githubLogin();
        open(repository);

    }

    @Test
    public void createIssueUsingPureSelenide() {
        System.out.println("Just wait a little bit");
        $(byAttribute("data-content","Issues")).click();
        $(By.linkText("New issue")).click();
        $("#issue_title").setValue("Issue was created at" + getCurrentTimeStamp());
        $("#issue_body").setValue("Some crazy description" + generateDescription());
        $(byText("assign yourself")).click();
        $(withText("Submit new issue")).click();
    }

    @Test
    public void createIssueUsingLambda() {
    }

    @Test
    public void createIssueUsingStepAnnotation() {
    }
}
