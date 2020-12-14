package tests;

import Utils.BaseMethods;
import Utils.BaseSteps;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class IssueTests extends BaseMethods {

    private static String REPOSITORY = "https://github.com/sagittMZ/qa_guru";

    @BeforeAll
     static void setup() {
        Configuration.startMaximized = true;
        githubLogin();
        open(REPOSITORY);

    }

    @Test
    public void createIssueUsingPureSelenide() {

        String issues_name = "Issue was created at " + getCurrentTimeStamp();
        System.out.println("Just wait a little bit");
        $(byAttribute("data-content","Issues")).click();
        $(By.linkText("New issue")).click();
        $("#issue_title").setValue(issues_name);
        $("#issue_body").setValue("Some crazy description" + generateDescription());
        $(byText("assign yourself")).click();
        $(withText("Submit new issue")).click();
        $(byText(issues_name)).shouldBe(Condition.visible);
    }

    @Test
    public void createIssueUsingLambda() {
        Map<String,String> data = new HashMap<>();
        data.put("CurrentTime",getCurrentTimeStamp());
        step("Go to create new issue", ()->{
            $(byAttribute("data-content","Issues")).click();
            $(By.linkText("New issue")).click();
        });
        step("Fill issues inputs", ()->{
            String issues_name = "Issue was created at " + data.get("CurrentTime");
            $("#issue_title").setValue(issues_name);
            $("#issue_body").setValue("Some crazy description" + generateDescription());
        });
        step("Assigning issue to developer", ()-> {
            $(byText("assign yourself")).click();
        });
        step("Submit new issue", ()-> {
            $(withText("Submit new issue")).click();
        });
        step("Checking the condition 'The new issue is successfully created'", ()-> {
            String issues_name = "Issue was created at " + data.get("CurrentTime");
            $(byText(issues_name)).shouldBe(Condition.visible);
            System.out.println("Checking the condition 'The new issue is successfully created'");
        });
    }

    @Test
    public void createIssueUsingAnnotation() {
        BaseSteps steps = new BaseSteps();
        Map<String,String> data = new HashMap<>();
        data.put("CurrentTime",getCurrentTimeStamp());
        data.put("Description",generateDescription());
        String issue_name = "Issue was created at " + data.get("CurrentTime");
        String description = "Some crazy description" + data.get("Description");
        steps.goToCreateIssue();
        steps.fillIssuesInputs(issue_name, description);
        steps.assigningIssue();
        steps.submitNewIssue();
        steps.checkTheIssueWasCreated();
    }


}
