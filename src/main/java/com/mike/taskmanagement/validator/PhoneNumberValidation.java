package com.mike.taskmanagement.validator;

public class PhoneNumberValidation implements ValidatorStrategy {
    @Override
    public boolean validate(String input) {
        return true;
    }

    @Override
    public StrategyType getStrategyType() {
        return StrategyType.PHONE_NUMBER_VALIDATION;
    }
}
