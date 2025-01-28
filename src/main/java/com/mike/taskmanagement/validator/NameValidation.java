package com.mike.taskmanagement.validator;

import io.micrometer.common.util.StringUtils;

public class NameValidation implements ValidatorStrategy {
    @Override
    public boolean validate(String input) {
        if (StringUtils.isBlank(input)) {
            return false;
        }
        for (char c : input.toCharArray()) {
            Character.UnicodeBlock block = Character.UnicodeBlock.of(c);
            boolean isAllowedChar = !Character.isLetter(c) || !(block == Character.UnicodeBlock.BASIC_LATIN || block == Character.UnicodeBlock.LATIN_EXTENDED_A);
            if (isAllowedChar) {
                return false;
            }
        }
        return true;
    }

    @Override
    public StrategyType getStrategyType() {
        return StrategyType.NAME_VALIDATION;
    }
}