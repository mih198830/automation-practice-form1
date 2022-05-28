package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

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


        $("#firstName").setValue("Mikhail");
        $("#lastName").setValue("Matskevich");
        $("#userEmail").setValue("myemail@gmail.com");
        $("label[for=gender-radio-1]").click();
        $("#userNumber").setValue("123456789");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__day--029").click();
        executeJavaScript("$('arguments[0].scrollIntoView(true)').");
//      $(".css-1wa3eu0-placeholder").parent().setValue("skdf");
        $(".custom-control-label").click();
        $("#currentAddress").setValue("Georgia, stret1");
    }
}
