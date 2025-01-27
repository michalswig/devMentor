package com.mike.taskmanagement.validator;

public class EmailValidation implements ValidatorStrategy {
    @Override
    public boolean validate(String input) {
        return true;
    }
}
