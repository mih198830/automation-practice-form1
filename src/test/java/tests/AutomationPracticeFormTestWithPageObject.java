package tests;

import config.CredentialsConfig;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


public class AutomationPracticeFormTestWithPageObject extends TestBase {
    public class OwnerTests {
        CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);

        @Test
        @Tag("owner")
        void loginTest() {
            String login = config.login();
            String password = config.password();
        }
    }
    @Test
    @Description("Checking all fields availability")
    @Owner("Mikhail")
    @Severity(SeverityLevel.NORMAL)
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
               .uploadPicture(testData.picture)
               .setAddress(testData.address)
               .setState(testData.state)
               .setCity(testData.city)
               .sendForm();

        registrastionFormPage.checkResult("Student Name", testData.firstName + " " + testData.lastName)
                        .checkResult("Student Email", testData.email)
                        .checkResult("Gender", testData.randomGender)
                        .checkResult("Mobile", testData.number)
                        .checkResult("Date of Birth", testData.day + ' ' + testData.months + ',' + testData.year)
                        .checkResult("Subjects", testData.randomSubject)
                        .checkResult("Hobbies", testData.randomHobbie)
                        .checkResult("Picture", testData.picture)
                        .checkResult("Address", testData.address)
                        .checkResult("State and City", testData.state + ' ' + testData.city);
    }
}
