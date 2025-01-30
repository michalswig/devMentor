package com.mike.taskmanagement.validator;

import com.mike.taskmanagement.model.User;
import com.mike.taskmanagement.util.UserDataGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserValidatorTest {

    private UserValidator userValidator;
    private ValidationService validationService;
    private ValidatorStrategy textValidatorStrategy;

    @BeforeEach
    void setUp() {

        textValidatorStrategy = new TextValidation();

        Map<StrategyType, ValidatorStrategy> strategyMap = new EnumMap<>(StrategyType.class);
        strategyMap.put(StrategyType.TEXT_VALIDATION, textValidatorStrategy);

        validationService = new ValidationService(strategyMap);

        userValidator = new UserValidator(validationService);
    }

    @Test
    void shouldValidateValidUserWithPolishFonts() {
        // Given a valid user with Polish characters
        User validUser = UserDataGenerator.userWithPolishChars();

        // When validation is performed
        boolean isValid = userValidator.validateText(validUser);

        // Then the user should be valid
        assertTrue(isValid, "Expected valid user to pass validation");
    }

    @Test
    void shouldNotValidateUserWithEmptyFirstName() {
        // Given a user with an empty first name
        User invalidUser = UserDataGenerator.userWithEmptyFirstName();

        // When validation is performed
        boolean isValid = userValidator.validateText(invalidUser);

        // Then the user should be invalid
        assertFalse(isValid, "Expected invalid user to fail validation");
    }

}
