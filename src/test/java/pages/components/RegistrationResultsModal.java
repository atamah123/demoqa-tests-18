package pages.components;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationResultsModal {
    public void verifyModalAppears() {
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    }

    public void verifyResult(String key, String value) {
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));
    }

    public void verifyResults(String key, String ... array) {
        StringBuilder sb = new StringBuilder();
        sb.append(array[0]);
        for(int i = 1; i < array.length - 1; i++){
            sb.append(", " + array[i]);
        }
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(sb.toString()));
        System.out.println(sb.toString());
    }

}