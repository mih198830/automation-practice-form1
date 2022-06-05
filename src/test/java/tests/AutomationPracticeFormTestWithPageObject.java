package tests;

import org.junit.jupiter.api.Test;

public class AutomationPracticeFormTestWithPageObject extends TestBase {

    @Test
    void pageTest() {
       registrastionFormPage.openPage()
               .setFirstName(testData.firstName)
               .setLastName(testData.lastName)
               .setEmail(testData.email)
               .setGender("Male")
               .setUserNumber(testData.number)
               .setDateOfBirth("29", "May", "1988")
               .setEnglish("E")
               .setHobbie("Reading")
               .uploadPicture(testData.link)
               .setAddress(testData.address)
               .scrollToClick()
               .setStateAndCity("NCR", "Delhi")
               .sendForm();

        registrastionFormPage.checkResult("Student Name", testData.firstName + " " + testData.lastName)
                        .checkResult("Student Email", testData.email)
                        .checkResult("Gender", "Male")
                        .checkResult("Mobile", testData.number)
                        .checkResult("Date of Birth", "29 May,1988")
                        .checkResult("Subjects", "English")
                        .checkResult("Hobbies", "Reading")
                        .checkResult("Picture", "selenidescreen.png")
                        .checkResult("Address", testData.address)
                        .checkResult("State and City", "NCR Delhi");
    }
}
