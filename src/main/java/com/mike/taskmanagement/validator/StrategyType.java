package com.mike.taskmanagement.validator;

import lombok.Getter;

@Getter
public enum StrategyType {
    TEXT_VALIDATION("Validation for text"),
    EMAIL_VALIDATION("Validation for email addresses"),
    PHONE_NUMBER_VALIDATION("Validation for phone numbers");

    private final String description;

    StrategyType(String description) {
        this.description = description;
    }

}
