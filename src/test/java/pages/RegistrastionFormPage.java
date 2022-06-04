package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
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

    SelenideElement firstNameInput = $("#firstName");
    SelenideElement lastNameInput = $("#lastName");
    SelenideElement emailInput = $("#userEmail");
    SelenideElement genderRadioButton = $("#genterWrapper");
    SelenideElement userNumberInput = $("#genterWrapper");
    SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    SelenideElement subjectInput = $("#subjectsInput");
    SelenideElement hobbiesCheckBox = $("#hobbiesWrapper");
    SelenideElement uploadImage = $("#uploadPicture");
    SelenideElement currentAddress = $("#currentAddress");
    SelenideElement stateCityWrapper = $("#stateCity-wrapper");
    SelenideElement citySelector = $("#city");
    SelenideElement submitButton = $("#submit");

    public RegistrastionFormPage openPage(){
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('#RightSide_Advertisement').remove()");
        return this;
    }

    public RegistrastionFormPage setFirstName(String value){
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrastionFormPage setLastName(String value){
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrastionFormPage setEmail(String value){
        emailInput.setValue(value);
        return this;
    }

    public RegistrastionFormPage setGender(String value){
        genderRadioButton.$(byText(value)).click();
        return this;
    }

    public RegistrastionFormPage setUserNumber(String value){
        userNumberInput.setValue(value);
        return this;
    }

    public RegistrastionFormPage setDateOfBirth(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrastionFormPage checkResult(String key, String value){
        resultsTableComponent.checkResult(key, value);
        return this;
    }

    public RegistrastionFormPage setEnglish(String value){
        subjectInput.sendKeys(value);
        $(byText("English")).click();
        return this;
    }

    public RegistrastionFormPage setHobbie(String value){
        hobbiesCheckBox.$(byText(value)).click();
        return this;
    }

    public RegistrastionFormPage uploadPicture(String value){
        uploadImage.uploadFile(new File(value));
        return this;
    }

    public RegistrastionFormPage setAddress(String value){
        currentAddress.setValue(value);
        return this;
    }

    public RegistrastionFormPage setStateAndCity(String state, String city){
        stateCityWrapper.$(Selectors.byText(state)).click();
        citySelector.click();
        stateCityWrapper.$(Selectors.byText(city)).click();
        return this;
    }

    public RegistrastionFormPage sendForm(){
        submitButton.click();
        return this;
    }
}
