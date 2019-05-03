package com.palex.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * Запускаем приложение.
 * @SpringBootApplication - запускает сканирование компонентов в текущем пакете.
 * (эквивалентно совокупности @Configuration, @EnableAutoConfiguration, @ComponentScan)
 * но у нас конфигурация WebMvc
 */
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
