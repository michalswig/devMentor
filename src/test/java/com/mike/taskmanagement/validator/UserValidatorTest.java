package com.mike.taskmanagement.validator;

import com.mike.taskmanagement.model.User;
import com.mike.taskmanagement.util.UserDataGenerator;
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
    void shouldValidateValidUserWithPolishFonts() {
        // Given
        User validUser = UserDataGenerator.userWithPolishChars();

        // When
        boolean isValid = userValidator.validate(validUser);

        // Then
        assertTrue(isValid, "Expected valid user to pass validation");
    }

    @Test
    void shouldNotValidateUserWithEmptyFirstName(){
        // Given
        User validUser = UserDataGenerator.userWithEmptyFirstName();

        // When
        boolean isValid = userValidator.validate(validUser);

        // Then
        assertFalse(isValid, "Expected invalid user to fail validation");
    }


}