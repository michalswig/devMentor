package com.mike.taskmanagement.validator;

import com.mike.taskmanagement.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserValidatorTest {

    private UserValidator userValidator;

    @BeforeEach
    void setUp() {
        ValidatorContext validatorContext = new ValidatorContext();
        userValidator = new UserValidator(validatorContext);
    }

    @Test
    void shouldValidateValidUser() {
        // Given
        User validUser = new User.Builder()
                .id(1L)
                .firstName("Michał")
                .lastName("Kościelny")
                .phoneNumber("+1234567890")
                .email("john.doe@example.com")
                .build();

        // When
        boolean isValid = userValidator.validate(validUser);

        // Then
        assertTrue(isValid, "Expected valid user to pass validation");
    }

}