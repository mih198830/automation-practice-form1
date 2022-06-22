package pages;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.components.CalendarComponent;
import pages.components.ResultsTableComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrastionFormPage {

    CalendarComponent calendarComponent = new CalendarComponent();
    ResultsTableComponent resultsTableComponent = new ResultsTableComponent();

    SelenideElement firstNameInput = $("#firstName");
    SelenideElement lastNameInput = $("#lastName");
    SelenideElement emailInput = $("#userEmail");
    SelenideElement genderRadioButton = $("#genterWrapper");
    SelenideElement userNumberInput = $("#userNumber");
    SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    SelenideElement subjectInput = $("#subjectsInput");
    SelenideElement hobbiesCheckBox = $("#hobbiesWrapper");
    SelenideElement uploadImage = $("#uploadPicture");
    SelenideElement currentAddress = $("#currentAddress");

    SelenideElement stateInput = $("#state");
    SelenideElement stateMenuInput = $("#stateCity-wrapper");
    SelenideElement cityInput = $("#city");
    SelenideElement cityMenuInput = $("#stateCity-wrapper");
    SelenideElement submitButton = $("#submit");

    @Step("Open /automation-practice-form page")
    public RegistrastionFormPage openPage(){
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('#RightSide_Advertisement').remove()");
        return this;
    }

    @Step("Set First Name")
    public RegistrastionFormPage setFirstName(String value){
        firstNameInput.setValue(value);
        return this;
    }

    @Step("Set Last Name")
    public RegistrastionFormPage setLastName(String value){
        lastNameInput.setValue(value);
        return this;
    }

    @Step("Set email")
    public RegistrastionFormPage setEmail(String value){
        emailInput.setValue(value);
        return this;
    }

    @Step("Set gender")
    public RegistrastionFormPage setGender(String value){
        genderRadioButton.$(byText(value)).click();
        return this;
    }

    @Step("Set user number")
    public RegistrastionFormPage setUserNumber(String value){
        userNumberInput.setValue(value);
        return this;
    }

    @Step("Set DOB")
    public RegistrastionFormPage setDateOfBirth(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    @Step("Check result")
    public RegistrastionFormPage checkResult(String key, String value){
        resultsTableComponent.checkResult(key, value);
        return this;
    }

    @Step("Select subject")
    public RegistrastionFormPage setSubject(String value){
        subjectInput.sendKeys(value);
        subjectInput.pressEnter();
        return this;
    }

    @Step("Set hobbie")
    public RegistrastionFormPage setHobbie(String value){
        hobbiesCheckBox.$(byText(value)).click();
        return this;
    }

    @Step("Upload picture")
    public RegistrastionFormPage uploadPicture(String value){
        uploadImage.uploadFromClasspath(value);
        return this;
    }

    @Step("Set address")
    public RegistrastionFormPage setAddress(String value){
        currentAddress.setValue(value);
        return this;
    }

    @Step("Scroll to click")
    public RegistrastionFormPage scrollToClick(){
        $("#state").scrollTo().click();
        return this;
    }

    @Step("Set state")
    public RegistrastionFormPage setState(String value) {
        stateInput.click();
        stateMenuInput.$(byText(value)).click();
        return this;
    }

    @Step("Set city")
    public RegistrastionFormPage setCity(String value) {
        cityInput.click();
        cityMenuInput.$(byText(value)).click();
        return this;
    }

    @Step("Send form")
    public RegistrastionFormPage sendForm(){
        submitButton.click();
        return this;
    }
}
