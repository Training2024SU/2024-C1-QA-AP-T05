package com.davidbonelo.models.factories;

import com.davidbonelo.models.User;
import net.datafaker.Faker;

public class UserFactory {
    public static User createFakeUser(String firstName) {
        Faker faker = new Faker();
        firstName = firstName != null ? firstName : faker.name().firstName();
        User user = new User();
        user.setFirstName(firstName);
        user.setPassword(faker.internet().password(10, 14, true, true, true));
        return user;
    }
}
