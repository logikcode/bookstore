package com.manuel.bookstore.flyway;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;

@Configuration
public class ProfileConfiguration {


    public ProfileConfiguration(ConfigurableEnvironment env) {
        // Set the active profile(s)
        env.setActiveProfiles("local");
    }
}
