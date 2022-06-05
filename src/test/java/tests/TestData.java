package tests;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {
    Faker faker = new Faker(new Locale("pl"));
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            number = faker.phoneNumber().subscriberNumber(10),
            link = "src/test/java/resources/selenidescreen.png",
            address = faker.address().fullAddress();
}
