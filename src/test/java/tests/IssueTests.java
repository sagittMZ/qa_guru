package tests;

import com.codeborne.selenide.Condition;
import conf.IssueConfig;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utils.BaseMethods;
import utils.BaseSteps;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;



public class IssueTests extends  TestBase{
    IssueConfig config = ConfigFactory.newInstance().create(IssueConfig.class);
    String login = config.login();
    String password = config.password();


    private static String REPOSITORY = "https://github.com/sagittMZ/qa_guru";
    BaseMethods base = new BaseMethods();


//TODO Не забыть спросить почему при подключении селеноида и использовании настроек из TestBase не логинит
//
//    @BeforeAll
//     static void setup() {
//        Configuration.startMaximized = true;
//    }
//    @AfterEach
//    @Step("Attachments")
//    public void afterEach(){
//        attachScreenshot("Last screenshot");
//        attachPageSource();
//        attachAsText("Browser console logs", getConsoleLogs());
//        attachVideo();
//        closeWebDriver();
//    }

    @Test
    @DisplayName("Создание issue с использоавнием чистого селенида")
    @Feature("Issue")
    @Link(url="https://github.com/sagittMZ/qa_guru", name ="Учимсо потихоньку")
    @Owner("s_a_g_i_t_t")
    public void createIssueUsingPureSelenide() {
        base.githubLogin(login, password);
//        open(REPOSITORY);
        String issues_name = "Issue was created at " + base.getCurrentTimeStamp();
        System.out.println("Just wait a little bit");
        $(byAttribute("data-content","Issues")).click();
        $(By.linkText("New issue")).click();
        $("#issue_title").setValue(issues_name);
        $("#issue_body").setValue("Some crazy description" + base.generateDescription());
        $(byText("assign yourself")).click();
        $(withText("Submit new issue")).click();
        $(byText(issues_name)).shouldBe(Condition.visible);
    }

    @Test
    @DisplayName("Создание issue с использованием лямбда выражений")
    @Feature("Issue")
    @Link(url="https://github.com/sagittMZ/qa_guru", name ="Учимсо потихоньку")
    @Owner("s_a_g_i_t_t")
    public void createIssueUsingLambda() {
        base.githubLogin(login, password);
        open(REPOSITORY);
        Map<String,String> data = new HashMap<>();
        data.put("CurrentTime",base.getCurrentTimeStamp());
        step("Go to create new issue", ()->{
            $(byAttribute("data-content","Issues")).click();
            $(By.linkText("New issue")).click();
        });
        step("Fill issues inputs", ()->{
            String issues_name = "Issue was created at " + data.get("CurrentTime");
            $("#issue_title").setValue(issues_name);
            $("#issue_body").setValue("Some crazy description" + base.generateDescription());
        });
        step("Assigning issue to developer", ()-> {
            $(byText("assign yourself")).click();
        });
        step("Submit new issue", ()-> {
            $(withText("Submit new issue")).click();
        });
        step("Checking the condition 'The new issue is successfully created'", ()-> {
            String issues_name = "Issue was created at " + data.get("CurrentTime");
            $(byAttribute("data-content", "Issues")).click();
            $(byText(issues_name)).shouldBe(Condition.visible);
            System.out.println("Checking the condition 'The new issue is successfully created'");
        });
    }

    @Test
    @DisplayName("Создание issue с использованием аннотаций")
    @Feature("Issue")
    @Link(url="https://github.com/sagittMZ/qa_guru", name ="Учимсо потихоньку")
    @Owner("s_a_g_i_t_t")
    public void createIssueUsingAnnotation() {
//        open(REPOSITORY);
        base.githubLogin(login, password);
        BaseSteps steps = new BaseSteps();
        Map<String,String> data = new HashMap<>();
        data.put("CurrentTime",base.getCurrentTimeStamp());
        data.put("Description",base.generateDescription());
        String issue_name = "Issue was created at: " + data.get("CurrentTime");
        String description = "Some crazy description: " + data.get("Description");
        steps.goToCreateIssue();
        steps.fillIssuesInputs(issue_name, description);
        steps.assigningIssue();
        steps.submitNewIssue();
        steps.checkTheIssueWasCreated(issue_name);
    }

    @Test
    @DisplayName("Проверка логина")
    @Feature("Issue")
    @Link(url="https://github.com/sagittMZ/qa_guru", name ="Учимсо потихоньку")
    @Owner("s_a_g_i_t_t")
    public void checkLoginToGithub() {
        step("Open github", ()-> {
            System.out.println("bebebbebe");
//            open(REPOSITORY);
        });
        step("Log in", ()-> {
            base.githubLogin(login, password);
        });
        System.out.println("test");
    }

}
