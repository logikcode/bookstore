package com.manuel.bookstore.flyway;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

@Slf4j
public class SwitchDatabases {

    public static void run() {

        var currentBranchName = executeCommandAndGetResult(new String[]{"git", "rev-parse", "--abbrev-ref", "HEAD"});

        var activeContainer = currentBranchName.contains("/main/") || currentBranchName.equals("main") ? "/main" :
                currentBranchName.contains("/release/") || currentBranchName.equals("release") ? "/release" : "";

        if (StringUtils.isBlank(activeContainer))
            throw new RuntimeException("""
                    Invalid branch naming convention. your branch must include release or main to indicate which database to use.
                    e.g. feature/main/<feature-description> or bugfix/release/<bugfix-description> etc...""");

        try {

            var result = executeCommandAndGetResult(new String[]{"/bin/bash", "-c", "docker inspect -f '{{.State.Status}}' " + activeContainer});

            if (result.equals("running"))
                return;

            Stream.of("/release", "/main").filter(a -> !a.equals(activeContainer))
                    .findFirst().ifPresent(c -> {
                        executeCommandAndGetResult(new String[]{"/bin/bash", "-c", "docker stop " + c});
                    });

            executeCommandAndGetResult(new String[]{"/bin/bash", "-c", "docker start " + activeContainer});

            result = executeCommandAndGetResult(new String[]{"/bin/bash", "-c", "until docker exec " + activeContainer + " pg_isready; do sleep 5 ; done"});

            log.info(result);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String executeCommandAndGetResult(String[] command) {

        try {

            Process process = Runtime.getRuntime().exec(command);

            process.waitFor();

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {

                return reader.readLine();
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
