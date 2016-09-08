package com.sebbia.testtask.config;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("!testing")
public class LoggingConfig {

}
