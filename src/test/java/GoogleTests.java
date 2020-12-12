import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GoogleTests {

    @Test
    public void ufcSearchTest() {
        // Открыть google
        open("https://www.google.com/");

        // Ввести поисковый запрос в поиск
        $(byName("q")).setValue("ufc").pressEnter();

        // Проверить, что поисковый запрос есть в результатах поиска
        $("html").shouldHave(Condition.text("Ultimate Fighting Championship"));
    }
    
//     Сейчас все ищут через Mail ты че !! ))) 
    @Test
    public void mailSearch() {
        open("https://mail.ru/");
        $(byName("q")).val(ufc).pressEnter();
    }
}
