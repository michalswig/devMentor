package com.mike.taskmanagement.util;

import com.mike.taskmanagement.model.User;

public class UserDataGenerator {

    private UserDataGenerator() {
        throw new UnsupportedOperationException("This is utility class and can`t be instantiated");
    }

    public static User userWithPolishChars() {
        return new User.Builder()
                .id(1L)
                .firstName("Michał")
                .lastName("Kościelny")
                .phoneNumber("+1234567890")
                .email("john.doe@example.com")
                .build();
    }

    public static User userWithEmptyFirstName() {
        return new User.Builder()
                .id(1L)
                .firstName("")
                .lastName("Kościelny")
                .phoneNumber("+1234567890")
                .email("john.doe@example.com")
                .build();
    }

}
