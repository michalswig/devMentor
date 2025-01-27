package com.mike.taskmanagement.validator;

public class NameValidation implements ValidatorStrategy {
    @Override
    public boolean validate(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }
        for (char c : input.toCharArray()) {
            Character.UnicodeBlock block = Character.UnicodeBlock.of(c);
            if (!Character.isLetter(c) ||
                    !(block == Character.UnicodeBlock.BASIC_LATIN || block == Character.UnicodeBlock.LATIN_EXTENDED_A)
            ) {
                return false;
            }
        }
        return true;
    }
}