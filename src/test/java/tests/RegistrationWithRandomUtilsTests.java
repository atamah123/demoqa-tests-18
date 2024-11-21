package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.sleep;
import static utils.RandomUtils.*;

public class RegistrationWithRandomUtilsTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "http://demoqa.com";
    }

    @Test
    void successfulRegistrationTest() {
        String userFirstName = getRandomFirstName(),
                userLastName = getRandomString(9),
                userEmail = getRandomEmail(),
                gender = getRandomGender(),
                phone = getRandomPhoneNumber(10),
                dateDay = "30", dateMonth = "July", dateYear = "2008",
                subject1 = "Maths", subject2 = "English",
                hobbies1 = "Sports", hobbies2 = "Music",
                address = "Some address 1",
                state = "NCR",
                city = "Delhi";



        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.openPage()
                .setFirstName(userFirstName)
                .setLastName(userLastName)
                .setEmail(userEmail)
                .setGender(gender)
                .setPhone(phone)
                .setBirthDate(dateDay,dateMonth,dateYear)
                .setSubject(subject1).setSubject(subject2)
                .setHobbies(hobbies1).setHobbies(hobbies2)
                .setAddress(address)
                .setStateAndCity(state, city)
                .submit();

//        $("#uploadPicture").uploadFromClasspath("img/1.png");



        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", userFirstName + " " + userLastName)
                .verifyResult("Student Email", userEmail)
                .verifyResult("Mobile", phone)
                .verifyResult("Gender", gender)
                .verifyResult("Date of Birth", dateDay
                        + " " + dateMonth + "," + dateYear)
                .verifyResults("Subjects", subject1, subject2)
                .verifyResult("Hobbies", hobbies1 + ", " +hobbies2)
                .verifyResult("Address", address)
                .verifyResult("State and City", state + " " + city);

        sleep(3000);
    }
}
