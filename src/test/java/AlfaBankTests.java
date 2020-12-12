import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class AlfaBankTests {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
        open("https://alfabank.ru/make-money/");
    }

    @Test
    public void goToAlfaArchiveDeposits() {

        $$(byText("Депозиты")).filter(visible).first().parent().click();
        $$(byText("Архивные счета и депозиты")).filter(visible).first().click();
        $$(byText("Депозиты")).filter(visible).first().parent().click();
        int archive_deposits_amount = $$(byText("Подробные условия")).size();
        assert(archive_deposits_amount == 5);
    }
}
