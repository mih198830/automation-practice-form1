package pages;

import pages.components.CalendarComponent;
import pages.components.ResultsTableComponent;
import com.codeborne.selenide.Selectors;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrastionFormPage {

    CalendarComponent calendarComponent = new CalendarComponent();
    ResultsTableComponent resultsTableComponent = new ResultsTableComponent();
    public RegistrastionFormPage openPage(){
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('#RightSide_Advertisement').remove()");
        return this;
    }

    public RegistrastionFormPage setFirstName(String value){
        $("#firstName").setValue(value);
        return this;
    }

    public RegistrastionFormPage setLastName(String value){
        $("#lastName").setValue(value);
        return this;
    }

    public RegistrastionFormPage setEmail(String value){
        $("#userEmail").setValue(value);
        return this;
    }

    public RegistrastionFormPage setGender(String value){
        $("#genterWrapper").$(byText(value)).click();
        return this;
    }

    public RegistrastionFormPage setUserNumber(String value){
        $("#userNumber").setValue(value);
        return this;
    }

    public RegistrastionFormPage setDateOfBirth(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrastionFormPage checkResult(String key, String value){
        resultsTableComponent.checkResult(key, value);
        return this;
    }

    public RegistrastionFormPage setEnglish(String value){
        $("#subjectsInput").sendKeys(value);
        $(byText("English")).click();
        return this;
    }

    public RegistrastionFormPage setHobbie(String value){
        $("#hobbiesWrapper").$(byText(value)).click();
        return this;
    }

    public RegistrastionFormPage uploadPicture(String value){
        $("#uploadPicture").uploadFile(new File(value));
        return this;
    }

    public RegistrastionFormPage setAddress(String value){
        $("#currentAddress").setValue(value);
        return this;
    }

    public RegistrastionFormPage setStateAndCity(String state, String city){
        $("#stateCity-wrapper").$(Selectors.byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(Selectors.byText(city)).click();
        return this;
    }

    public RegistrastionFormPage sendForm(){
        $("#submit").click();
        return this;
    }
}
