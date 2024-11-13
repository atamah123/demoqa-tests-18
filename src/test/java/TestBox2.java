import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestBox2 {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1366x768";
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void male() {
        open("/automation-practice-form");
        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Egorov");
        $("#userEmail").setValue("sdfsdf@sdfs.asda");
        $(".custom-control-label").scrollTo();
        $("#genterWrapper").$(byText("Male")).click();
        $("[id =userNumber]").setValue("1337001488");


        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-dropdown-container--select")
                .$(byText("August")).click();
        $(".react-datepicker__year-select")
                .$(byText("1990")).click();
        $(".react-datepicker__month")
                .$(byText("28")).click();


        $("#hobbies-checkbox-1").parent().$(byText("Sports")).click();
        $("#hobbies-checkbox-3").parent().$(byText("Music")).click();

        $("#uploadPicture").uploadFromClasspath("pic/228.png");
        $("#currentAddress").setValue("Hamburg, st. Shmal 32/2");

        $("#state").scrollTo();
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Panipat")).click();

        $("#subjectsInput").setValue("Germanys"); // последний
        $("#submit").scrollTo();
        $("#submit").click();



    }


}
