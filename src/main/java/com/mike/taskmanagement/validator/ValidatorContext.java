package com.mike.taskmanagement.validator;

import org.springframework.stereotype.Component;

@Component
public class ValidatorContext {
    private ValidatorStrategy strategy;

    public void setStrategy(ValidatorStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean validate(String input) {
        if (strategy == null) {
            throw new IllegalArgumentException("Validation strategy is not set");
        }
        return strategy.validate(input);
    }

}
