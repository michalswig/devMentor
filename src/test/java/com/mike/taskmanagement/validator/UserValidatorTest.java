package com.mike.taskmanagement.validator;

import com.mike.taskmanagement.model.User;
import com.mike.taskmanagement.util.UserDataGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UserValidatorTest {

    private UserValidator userValidator;
    private ValidationService validationService;
    private ValidatorStrategy textValidatorStrategy;

    @BeforeEach
    void setUp() {
        // Mocking the validator strategy for TEXT_VALIDATION
        textValidatorStrategy = mock(ValidatorStrategy.class);

        // Creating a strategy map and adding the mocked validator strategy
        Map<StrategyType, ValidatorStrategy> strategyMap = new EnumMap<>(StrategyType.class);
        strategyMap.put(StrategyType.TEXT_VALIDATION, textValidatorStrategy);

        // Initializing ValidationService with the mocked strategy map
        validationService = new ValidationService(strategyMap);

        // Initializing UserValidator with the ValidationService
        userValidator = new UserValidator(validationService);
    }

    @Test
    void shouldValidateValidUserWithPolishFonts() {
        // Given a valid user with Polish characters
        User validUser = UserDataGenerator.userWithPolishChars();
        when(textValidatorStrategy.validate(validUser.getFirstName())).thenReturn(true);

        // When validation is performed
        boolean isValid = userValidator.validateText(validUser);

        // Then the user should be valid
        assertTrue(isValid, "Expected valid user to pass validation");
    }

    @Test
    void shouldNotValidateUserWithEmptyFirstName() {
        // Given a user with an empty first name
        User invalidUser = UserDataGenerator.userWithEmptyFirstName();
        when(textValidatorStrategy.validate(invalidUser.getFirstName())).thenReturn(false);

        // When validation is performed
        boolean isValid = userValidator.validateText(invalidUser);

        // Then the user should be invalid
        assertFalse(isValid, "Expected invalid user to fail validation");
    }
}
