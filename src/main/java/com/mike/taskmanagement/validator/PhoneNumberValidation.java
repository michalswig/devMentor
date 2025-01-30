package com.mike.taskmanagement.validator;

import org.springframework.stereotype.Service;

@Service
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
