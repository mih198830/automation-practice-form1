package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import java.io.File;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class AutomationPracticeFormTest {
    @Disabled
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    @Disabled
    void pageTest() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('#RightSide_Advertisement').remove()");
        executeJavaScript("$('.i-amphtml-fill-content').remove()");

        $("#firstName").setValue("Mikhail");
        $("#lastName").setValue("Matskevich");

        $("#userEmail").setValue("myemail@gmail.com");

        $("#genterWrapper").$(byText("Male")).click();

        $("#userNumber").setValue("1234567890");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").selectOption("1988");
        $(".react-datepicker__day--029").click();

        $("#subjectsInput").sendKeys("E");
        $(byText("English")).click();

        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();

        $("#uploadPicture").uploadFile(new File("src/test/java/resources/selenidescreen.png"));

        $("#currentAddress").setValue("Georgia, stret1");
        $("#state").scrollTo().click();

        $("#stateCity-wrapper").$(Selectors.byText("NCR")).click();
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
