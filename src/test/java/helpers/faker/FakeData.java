package helpers.faker;

import com.github.javafaker.Faker;

public class FakeData {
    private Faker faker = new Faker();
    public String
            fakeUser = faker.name().name() + "#%@&&%$#",
            fakePassword = faker.internet().password(10, 15);
}