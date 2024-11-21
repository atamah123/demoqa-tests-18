package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationTests {

    @BeforeAll
    static void beforeAll() {
//        Configuration.browser = "firefox";
        Configuration.browserSize = "1366x768";
//        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";


    }

    @Test
    void male() {
        open("/automation-practice-form");

        for(int i =0; i<5; i++);
        actions().moveToElement($("div")).sendKeys(Keys.chord(Keys.CONTROL, "-")).perform();

        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Egorov");
        $("#userEmail").setValue("aue@mail.ru");
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
        $("#subjectsInput").setValue("Hindi").pressEnter();
        $("#subjectsInput").setValue("English").pressEnter();

        $("#uploadPicture").uploadFromClasspath("pic/228.png");
        $("#currentAddress").setValue("Hamburg, st. Shmal 32/2");

        $("#state").scrollTo();
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Panipat")).click();

        $("#submit").click();


        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Alex Egorov"));
        $(".table-responsive").shouldHave(text("aue@mail.ru"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("1337001488"));
        $(".table-responsive").shouldHave(text("28 August,1990"));
        $(".table-responsive").shouldHave(text("Hindi, English"));
        $(".table-responsive").shouldHave(text("Sports, Music"));
        $(".table-responsive").shouldHave(text("228.png"));
        $(".table-responsive").shouldHave(text("Hamburg, st. Shmal 32/2"));
        $(".table-responsive").shouldHave(text("Haryana Panipat"));


//        for(int i = 0; i < 4; i++)
//            $(By.tagName("body")).press(Keys.PAGE_DOWN);
//        $("#closeLargeModal").pressEnter();

        sleep(30000);
    }


}
