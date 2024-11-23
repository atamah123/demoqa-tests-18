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
                userLastName = getRandomLastName(),
                userEmail = getRandomEmail(
                        userFirstName + userLastName),
                gender = getRandomGender(),
                phone = getRandomPhoneNumber(10),
                dayOfBerth = getRandomDay(),
                monthOfBerth = getRandomMonth(),
                yearOfBerth = getRandomYear(),
                subject1 = getRandomSubject(), subject2 = getRandomSubject(),
                hobbies1 = "Sports", hobbies2 = "Music",
                pictureName = "1.png",
                address = getRandomAddress(),
                state = "NCR",
                city = "Delhi";



        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.openPage()
                .setFirstName(userFirstName)
                .setLastName(userLastName)
                .setEmail(userEmail)
                .setGender(gender)
                .setPhone(phone)
                .setBirthDate(dayOfBerth,monthOfBerth,yearOfBerth)
                .setSubject(subject1).setSubject(subject2)
                .setHobbies(hobbies1).setHobbies(hobbies2)
                .uploadPicture(pictureName)
                .setAddress(address)
                .setStateAndCity(state, city)
                .submit();



        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", userFirstName + " " + userLastName)
                .verifyResult("Student Email", userEmail)
                .verifyResult("Mobile", phone)
                .verifyResult("Gender", gender)
                .verifyResult("Date of Birth", dayOfBerth
                        + " " + monthOfBerth + "," + yearOfBerth)
                .verifyResults("Subjects", subject1, subject2)
                .verifyResults("Hobbies", hobbies1, hobbies2)
                .verifyResult("Picture", pictureName)
                .verifyResult("Address", address)
                .verifyResult("State and City", state + " " + city);

        sleep(2000);
    }
}
