package lt.onemagic.TruckScale.utils;

import com.github.javafaker.Faker;
import lt.onemagic.TruckScale.models.Contact;

public class ContactDataGenerator {

    private static final Faker faker = new Faker();

    public static Contact generateContact() {
        return new Contact(
            0,
            faker.name().firstName(),
            faker.name().lastName(),
            faker.internet().emailAddress(),
            faker.phoneNumber().phoneNumber(),
            faker.phoneNumber().phoneNumber(),
            faker.address().streetAddress(),
            faker.address().city(),
            faker.address().zipCode(),
            faker.address().country()
        );
    }
}
