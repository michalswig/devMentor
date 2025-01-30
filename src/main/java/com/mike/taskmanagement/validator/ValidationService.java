package com.mike.taskmanagement.validator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
public class ValidationService {

    private final Map<StrategyType, ValidatorStrategy> validatorStrategyMap;

    public ValidationService(Map<StrategyType, ValidatorStrategy> validatorStrategyMap) {
        log.info(validatorStrategyMap.toString());
        this.validatorStrategyMap = validatorStrategyMap;
    }

    public boolean validate(String input, StrategyType strategyType){
        ValidatorStrategy validatorStrategy = validatorStrategyMap.get(strategyType);
        return validatorStrategy.validate(input);
    }

}
