package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;

public class AutomationPracticeFormTestWithPageObject extends TestBase{

    @Test
    void pageTest() {
        String firstName = "Mikhail";
        String lastName = "Matskevich";
        String email = "myemail@gmail.com";
        String number = "1234567890";
        String link = "src/test/java/resources/selenidescreen.png";
        String address = "Georgia, stret1";

       registrastionFormPage.openPage()
               .setFirstName(firstName)
               .setLastName(lastName)
               .setEmail(email)
               .setGender("Male")
               .setUserNumber(number)
               .setDateOfBirth("29", "May", "1988")
               .setEnglish("E")
               .setHobbie("Reading")
               .uploadPicture(link)
               .setAddress(address)
               .scrollToClick();
               registrastionFormPage.setStateAndCity("NCR", "Delhi")
               .sendForm();

        registrastionFormPage.checkResult("Student Name", firstName + " " + lastName)
                        .checkResult("Student Email", email)
                        .checkResult("Gender", "Male")
                        .checkResult("Mobile", number)
                        .checkResult("Date of Birth", "29 May,1988")
                        .checkResult("Subjects", "English")
                        .checkResult("Hobbies", "Reading")
                        .checkResult("Picture", "selenidescreen.png")
                        .checkResult("Address", address)
                        .checkResult("State and City", "NCR Delhi");
    }
}
