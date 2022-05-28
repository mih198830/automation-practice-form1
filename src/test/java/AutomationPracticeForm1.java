import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class AutomationPracticeForm1 {
    @BeforeAll
    static void BeforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void PageTest() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('#RightSide_Advertisement').remove()");
        executeJavaScript("$('.i-amphtml-fill-content').remove()");

        $("#firstName").setValue("Mikhail");
        $("#lastName").setValue("Matskevich");
        $("#userEmail").setValue("myemail@gmail.com");
        $("[for=gender-radio-1]").click();
        $("#userNumber").setValue("123456789");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__day--029").click();
        $(".col-md-9").click();
        $("#subjectsInput").setValue("Physics").pressEnter();
        $("[for=hobbies-checkbox-2]").click();
        $("#uploadPicture").uploadFile(new File("src/test/java/tests/selenidescreen.png"));

        $("#currentAddress").setValue("Georgia, stret1");
        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(Selectors.byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(Selectors.byText("Delhi")).click();

    }
}
