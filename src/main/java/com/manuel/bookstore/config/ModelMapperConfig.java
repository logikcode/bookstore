package com.manuel.bookstore.config;

import com.github.rozidan.springboot.modelmapper.ConfigurationConfigurer;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;

@Component
public class ModelMapperConfig extends ConfigurationConfigurer {


    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        configure(modelMapper.getConfiguration());
        return modelMapper;
    }

    @Override
    public void configure(Configuration configuration) {
        configuration.setMatchingStrategy(MatchingStrategies.STANDARD);
        configuration.setPropertyCondition(Conditions.isNotNull());
        configuration.setPropertyCondition(Conditions.not(Conditions.isType(LinkedHashMap.class)));
        //configuration.setSkipNullEnabled(true);
    }
}
