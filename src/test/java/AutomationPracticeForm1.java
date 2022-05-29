import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class AutomationPracticeForm1 {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void pageTest() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('#RightSide_Advertisement').remove()");
        executeJavaScript("$('.i-amphtml-fill-content').remove()");

        //first name last name
        $("#firstName").setValue("Mikhail");
        $("#lastName").setValue("Matskevich");

        //email
        $("#userEmail").setValue("myemail@gmail.com");

        //radio-button
        $("#genterWrapper").$(byText("Male")).click();

        //phone number
        $("#userNumber").setValue("1234567890");

        //dob
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").selectOption("1988");
        $(".react-datepicker__day--029").click();

        //subject
        $("#subjectsInput").sendKeys("E");
        $(byText("English")).click();

        //checkbox
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();

        //upload
        $("#uploadPicture").uploadFile(new File("src/test/java/resources/selenidescreen.png"));

        //address
        $("#currentAddress").setValue("Georgia, stret1");

        $("#state").scrollTo().click();

        //state
        $("#stateCity-wrapper").$(Selectors.byText("NCR")).click();

        //city
        $("#city").click();
        $("#stateCity-wrapper").$(Selectors.byText("Delhi")).click();

        $("#submit").click();

        $(".modal-content").shouldHave(
                text("Mikhail"),
                text("Matskevich"),
                text("myemail@gmail.com"),
                text("Male"),
                text("123456789"),
                text("29 May,1988"),
                text("English"),
                text("Sports"),
                text("Music"),
                text("selenidescreen.png"),
                text("Georgia, stret1"),
                text("NCR Delhi"));
    }
}
