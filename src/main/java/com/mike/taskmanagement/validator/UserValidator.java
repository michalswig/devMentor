package com.mike.taskmanagement.validator;

import com.mike.taskmanagement.model.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserValidator {
    private final ValidatorContext context;

    public UserValidator(ValidatorContext context) {
        this.context = context;
    }

    public boolean validate(User user) {
//        context.setStrategy(new NameValidation());
//        if (!context.validate(user.getFirstName())) {
//            return false;
//        }
//        context.setStrategy(new NameValidation());
//        if (!context.validate(user.getLastName())) {
//            return false;
//        }
//        context.setStrategy(new PhoneNumberValidation());
//        if (!context.validate(user.getPhoneNumber())) {
//            return false;
//        }
//        context.setStrategy(new EmailValidation());
//        if (!context.validate(user.getEmail())) {
//            return false;
//        }
//        return true;
        Map<ValidatorStrategy, String> validatorStrategyStringMap = Map.of(
                new NameValidation(), user.getFirstName(),
                new NameValidation(), user.getLastName(),
                new PhoneNumberValidation(), user.getPhoneNumber(),
                new EmailValidation(), user.getEmail()
        );
        for (Map.Entry<ValidatorStrategy, String> entry : validatorStrategyStringMap.entrySet()) {
            context.setStrategy(entry.getKey());
            if (!context.validate(entry.getValue())) {
                return false;
            }
        }
        return true;
    }

}
