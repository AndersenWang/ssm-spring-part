package com.andersen.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import(value = {JavaConfigurationB.class})
@Configuration
public class JavaConfigurationA {
}
