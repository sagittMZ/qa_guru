package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.BaseMethods;

import java.io.IOException;

public class APITests extends BaseMethods {

    @Test
    @DisplayName("API тест - заглушка для Jenkins")
    @Feature("Issue")
    @Link(url="https://github.com/sagittMZ/qa_guru", name ="Учимсо потихоньку")
    @Owner("s_a_g_i_t_t")
    public void simpleCheckStatusAPItest() {
        try {
            getRequest("https://qa.guru/");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
