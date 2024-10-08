package lt.onemagic.TruckScale.utils;

import com.github.javafaker.Faker;
import lt.onemagic.TruckScale.models.Company;

public class CompanyDataGenerator {

    private static final Faker faker = new Faker();

    public static Company generateCompany() {
        return new Company(
            0,
            faker.company().name(),
            faker.company().industry(),
            faker.number().digits(10),
            faker.number().digits(9),
            faker.address().streetAddress(),
            faker.address().city(),
            faker.address().zipCode(),
            faker.address().country(),
            faker.internet().emailAddress(),
            faker.phoneNumber().phoneNumber(),
            faker.phoneNumber().phoneNumber(),
            faker.lorem().sentence()
        );
    }
}