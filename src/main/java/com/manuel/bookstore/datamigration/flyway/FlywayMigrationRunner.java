
 package com.manuel.bookstore.datamigration.flyway;


import lombok.RequiredArgsConstructor;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@RequiredArgsConstructor
@ConditionalOnProperty(
        value = "flywayrunner.enabled",
        havingValue = "true",
        matchIfMissing = true)
public class FlywayMigrationRunner {

    private final DataSource dataSource;

    @Bean(initMethod = "migrate")
    public Flyway flyway() {

        return Flyway.configure()
                .dataSource(dataSource)
                .locations("classpath:db/migration",
                        "classpath:db/**/migrations/",
                        "classpath:db/**/views/",
                        "classpath:db/**/procedures/")
                .sqlMigrationPrefix("V")
                .placeholderPrefix("$$")
                .placeholderReplacement(false)
                .load();
    }
}

