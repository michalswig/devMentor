package com.mike.taskmanagement.validator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.EnumMap;
import java.util.Map;
import java.util.Set;

@Configuration
public class ValidationStrategyConfiguration {
    Set<ValidatorStrategy> validatorStrategies;

    public ValidationStrategyConfiguration(Set<ValidatorStrategy> validatorStrategies) {
        this.validatorStrategies = validatorStrategies;
    }

    @Bean
    Map<StrategyType, ValidatorStrategy> validatorStrategyMap() {
        Map<StrategyType, ValidatorStrategy> validatorStrategyMap = new EnumMap<>(StrategyType.class);
        validatorStrategies.forEach(
                validatorStrategy -> validatorStrategyMap.put(
                        validatorStrategy.getStrategyType(), validatorStrategy)
        );
        return validatorStrategyMap;
    }

}
