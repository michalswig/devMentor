package com.mike.taskmanagement.validator;

import lombok.Getter;

@Getter
public enum StrategyType {
    NAME_VALIDATION("Validation for names"),
    EMAIL_VALIDATION("Validation for email addresses"),
    PHONE_NUMBER_VALIDATION("Validation for phone numbers");

    private final String description;

    StrategyType(String description) {
        this.description = description;
    }

}
