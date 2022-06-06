package tests;
import com.github.javafaker.Faker;
import java.util.Locale;

import static utils.RandomUtils.*;

public class TestData {
    Faker faker = new Faker(new Locale("pl"));
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            number = faker.phoneNumber().subscriberNumber(10),
            day = String.valueOf(faker.number().numberBetween(1, 28)),

            year = String.valueOf(faker.number().numberBetween(1980, 2022)),

            randomGender = randomStringFromArrGender(),
            randomHobbie = randomHobbieFromArr(),
            randomSubject = randomSubjectFromArr(),
            link = "src/test/resources/selenidescreen.png",
            address = faker.address().fullAddress(),
            months = randomMonths();

}
