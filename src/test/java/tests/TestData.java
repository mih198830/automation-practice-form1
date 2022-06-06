package tests;

import com.github.javafaker.Faker;

import java.util.Locale;

import static utils.RandomUtils.randomHobbieFromArr;
import static utils.RandomUtils.randomStringFromArrGender;

public class TestData {
    Faker faker = new Faker(new Locale("pl"));
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            number = faker.phoneNumber().subscriberNumber(10),
            randomGender = randomStringFromArrGender(),
            randomHobbie = randomHobbieFromArr(),
            link = "src/test/resources/selenidescreen.png",
            address = faker.address().fullAddress();

}
