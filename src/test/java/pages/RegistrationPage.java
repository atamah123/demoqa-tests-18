package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private CalendarComponent calendarComponent = new CalendarComponent();
    private RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private final String TITLE_TEXT = "Student Registration Form";
    private SelenideElement lastNameInput = $("#lastName"),
            firstNameInput = $("#firstName"),
            emailInput = $("#userEmail"),
            genderBox = $("#genterWrapper"),
            number = $("#userNumber"),
            subject = $("#subjectsInput"),
            hobbie = $("#hobbiesWrapper"),
            address = $("#currentAddress"),
            state = $("#state"),
            city = $("#city");


    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage clearLastName() {
        lastNameInput.clear();
        return this;
    }

    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        genderBox.$(byText(value)).
                click();
        return this;
    }

    public RegistrationPage setPhone(String value) {
        number.setValue(value);
        return this;
    }

    public RegistrationPage setSubject(String value) {
        subject.setValue(value)
                .pressEnter();
        return this;
    }

    public RegistrationPage setHobbies(String value) {
        hobbie.$(byText(value))
                .click();
        return this;
    }

    public RegistrationPage setAddress(String value) {
        address.setValue(value);
        return this;
    }

    public RegistrationPage setStateAndCity(String stateValue, String cityValue) {
        state.click();
        $("#stateCity-wrapper").$(byText(stateValue))
                .click();
        city.click();
        $("#stateCity-wrapper").$(byText(cityValue))
                .click();
        return this;
    }



    public RegistrationPage setCity(String value) {
        address.setValue(value);
        return this;
    }

    public void submit() {
        $("#submit").click();
    }

    public RegistrationPage setBirthDate(String day, String month, String year){
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage verifyResultsModalAppears(){
        registrationResultsModal.verifyModalAppears();
        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);
        return this;
    }

    public RegistrationPage verifyResults(String key, String value1, String value2) {
        registrationResultsModal.verifyResults(key, value1, value2);
        return this;
    }
}
