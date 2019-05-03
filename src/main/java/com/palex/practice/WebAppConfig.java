package com.palex.practice;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Класс конфигурация Spring
 *
 */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.palex.practice")
public class WebAppConfig {
}
