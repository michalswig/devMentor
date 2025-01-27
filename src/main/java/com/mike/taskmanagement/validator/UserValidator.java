package com.mike.taskmanagement.validator;

import com.mike.taskmanagement.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserValidator {
    private final ValidatorContext context;

    public UserValidator(ValidatorContext context) {
        this.context = context;
    }

    public boolean validate(User user) {
        context.setStrategy(new NameValidation());
        if (!context.validate(user.getFirstName())) {
            return false;
        }
        context.setStrategy(new NameValidation());
        if (!context.validate(user.getLastName())) {
            return false;
        }
        context.setStrategy(new PhoneNumberValidation());
        if (!context.validate(user.getPhoneNumber())) {
            return false;
        }
        context.setStrategy(new EmailValidation());
        if (!context.validate(user.getEmail())) {
            return false;
        }
        return true;
    }

}
