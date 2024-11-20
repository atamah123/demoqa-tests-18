package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class RegistrationWithPageObjectsTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "http://demoqa.com";
    }

    @Test
    void successfulRegistrationTest() {
        String userFirstName = "Alex";
        String userLastName = "Egorov";
        String email = "ae@mail.ru";
        String gender = "Male";
        String subject1 = "Maths"; String subject2 = "English";
        String hobbies1 = "Sports"; String hobbies2 = "Music";
        String address = "Some address 1";
        String state = "NCR";
        String city = "Delhi";



        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.openPage()
                .setFirstName(userFirstName)
                .setLastName(userLastName)
                .setEmail(email)
                .setGender(gender)
                .setPhone("1234567890")
                .setBirthDate("30","July","2008")
                .setSubject(subject1).setSubject(subject2)
                .setHobbies(hobbies1).setHobbies(hobbies2)
                .setAddress(address)
                .setStateAndCity(state, city)
                .submit();

//        $("#uploadPicture").uploadFromClasspath("img/1.png");



        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", userFirstName + " " + userLastName)
                .verifyResult("Student Email", email)
                .verifyResult("Mobile", "1234567890")
                .verifyResult("Gender", gender)
                .verifyResult("Date of Birth", "30 July,2008")
                .verifyResult("Subjects", "Maths, English")
                .verifyResult("Hobbies", "Sports, Music")
                .verifyResult("Address", "Some address 1")
                .verifyResult("State and City", "NCR Delhi");

        sleep(3000);
    }
}
