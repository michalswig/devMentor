package com.mike.taskmanagement.validator;

import com.mike.taskmanagement.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserValidator {

    private final ValidationService validationService;

    public UserValidator(ValidationService validationService) {
        this.validationService = validationService;
    }

    public boolean validateText(User user){
        return validationService.validate(user.getFirstName(), StrategyType.TEXT_VALIDATION);
    }

}
