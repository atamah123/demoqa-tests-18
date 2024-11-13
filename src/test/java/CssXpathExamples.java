import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;

public class CssXpathExamples {
    void cssXpathExamples() {
        $("[data-testidemail]").setValue("1");
        // $(by("data-testid", "email")).setValue("1"); // альтернативный вариант
    }
}
