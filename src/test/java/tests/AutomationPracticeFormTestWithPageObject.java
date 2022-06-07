package tests;

import org.junit.jupiter.api.Test;

public class AutomationPracticeFormTestWithPageObject extends TestBase {

    @Test
    void pageTest() {
       registrastionFormPage.openPage()
               .setFirstName(testData.firstName)
               .setLastName(testData.lastName)
               .setEmail(testData.email)
               .setGender(testData.randomGender)
               .setUserNumber(testData.number)
               .setDateOfBirth(testData.day, testData.months, testData.year)
               .setSubject(testData.randomSubject)
               .setHobbie(testData.randomHobbie)
               .uploadPicture(testData.link)
               .setAddress(testData.address)
               .scrollToClick()
               .setStateAndCity("NCR", "Delhi")
               .sendForm();

        registrastionFormPage.checkResult("Student Name", testData.firstName + " " + testData.lastName)
                        .checkResult("Student Email", testData.email)
                        .checkResult("Gender", testData.randomGender)
                        .checkResult("Mobile", testData.number)
                        .checkResult("Date of Birth", testData.day + ' ' + testData.months + ',' + testData.year)
                        .checkResult("Subjects", testData.randomSubject)
                        .checkResult("Hobbies", testData.randomHobbie)
                        .checkResult("Picture", "selenidescreen.png")
                        .checkResult("Address", testData.address)
                        .checkResult("State and City", "NCR Delhi");
    }
}
