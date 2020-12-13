package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.byText;

public class StudentRegistrationForm {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
        open("https://demoqa.com/automation-practice-form");
    }

    @Test
    public void fillFormTestPositiveScenario() {


        String name = "GoodUserName",
                lastname = "GoodLastName",
                email = "ytbgtwdw@supere.ml",
                phone = "9876543210",
                gender = "Male",
                hobby = "Reading",
                state = "Uttar Pradesh",
                city = "Lucknow",
                currentAddress = "Alte Oper Frankfurt",
                fileName = "pic.jpg";


        $("#firstName").val(name);
        $("#lastName").val(lastname);
        $("#userEmail").val(email);
        $(byText(gender)).click();
        $("#userNumber").val(phone);
        $("#dateOfBirthInput").click();
        //$(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOptionByValue("0");
        //$(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOptionByValue("1951");
        $(".react-datepicker__day--023").click();
        $(byText(hobby)).click();
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $(byText(state)).click();
        $("#city").click();
        $(byText(city)).click();
        $("#uploadPicture").uploadFile(new File("src/test/diffsrc/" + fileName));
        $("#submit").click();

        //check example
        $("#example-modal-sizes-title-lg").shouldHave(exactText("Thanks for submitting the form"));
        $(byXpath("//tbody")).shouldHave(text(email));
        $("#closeLargeModal").click();
        System.out.println("game over");




    }
}
