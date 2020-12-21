package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class SearchTests extends TestBase{

    @Test
    @DisplayName("Google search")
    @Feature("Searching")
    @Link(url="https://github.com/sagittMZ/qa_guru", name ="Учимсо потихоньку")
    @Owner("s_a_g_i_t_t")
    public void ufcSearchTest() {
        step("Open google", ()->{
            open("https://www.google.com/");
        });
        step("Type search request", ()->{
            $(byName("q")).setValue("ufc").pressEnter();
        });
        step("Check search results", ()->{
            $("html").shouldHave(Condition.text("Ultimate Fighting Championship"));
        });
    }
    
    //Сейчас все ищут через Mail ты че !! ))) - pull request from @telepnev
    @Test
    @DisplayName("Mail search")
    @Feature("Searching")
    @Link(url="https://github.com/sagittMZ/qa_guru", name ="Учимсо потихоньку")
    @Owner("s_a_g_i_t_t")
    public void mailSearch() {

        step("Open mail", ()->{
            open("https://mail.ru/");
        });
        step("Type search request", ()->{
            $(byName("q")).setValue("ufc").pressEnter();
        });
        step("Check search results", ()->{
            $("html").shouldHave(Condition.text("Ultimate Fighting Championship"));
        });
    }
}
