package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBox {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1366x768";
        // Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {

        
            open("/text-box");
            $("[id =userName]").setValue("Alex Egorov");
//        $("#userName").setValue("Alex Egorov"); // аналогичный вариант
            // два скоращений id = # и class = . (точка)

            $("#userEmail").setValue("a.egorov@mail.ru");
            $("[id = currentAddress]").setValue("Some adress 1");
            $("[id =permanentAddress]").setValue("Another adress 1");

            $("[id=submit]").click();

            $("#output").shouldHave(
                    text("Alex Egorov"),
                    text("a.egorov@mail.ru"),
                    text("Some adress 1"),
                    text("Another adress 1"));
    }
}
