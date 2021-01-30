package utils;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class BaseSteps {
    //public String issueName;

    @Step("Go to create issue")
    public void goToCreateIssue() {
        System.out.println("Go to create issue");
        $(by("data-content", "Issues")).click();
        $(byLinkText("New issue")).click();
    }
    
    @Step("Fill issues inputs")
    public void fillIssuesInputs(String issueName, String description) {
        System.out.println("fill form");
        $("#issue_title").setValue(issueName);
        $("#issue_body").setValue(description);
        System.out.println("issue name is: " + issueName);
    }
    
    @Step("Assigning issue to developer")
    public void assigningIssue() {
        $(byText("assign yourself")).click();
    }
    
    @Step("Submit new issue")
    public void submitNewIssue() {
        $(withText("Submit new issue")).click();
    }
    
    @Step("Checking the condition 'The new issue is successfully created'")
    public void checkTheIssueWasCreated(String issue_name) {
      //  $(by("data-content", "Issues")).click();
        $(byText(issue_name)).shouldBe(Condition.visible);
        System.out.println("check if issue exist");
    }
}
