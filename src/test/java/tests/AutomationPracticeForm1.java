package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class AutomationPracticeForm1 {
    @BeforeAll
    static void BeforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void PageTest() {
        open("/automation-practice-form");
        $("#firstName").sendKeys("Mikhail");
        $("#lastName").sendKeys("Matskevich");
        $("#userEmail").sendKeys("myemail@gmail.com");
        $("label[for=gender-radio-1]").click();
        $("#userNumber").sendKeys("123456789");
        $("dateOfBirthInput").click();
        $(By.className("subjects-auto-complete__control")).sendKeys("Law");
    }
}
