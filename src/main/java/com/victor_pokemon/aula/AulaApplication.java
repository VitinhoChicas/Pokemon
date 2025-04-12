package com.victor_pokemon.aula;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@ComponentScan(basePackages = "com.victor_pokemon")
@EntityScan(basePackages = {"com.victor_pokemon.aula.domains", "com.victor_pokemon.aula.domains.enums"})
@EnableJpaRepositories(basePackages = "com.victor_pokemon.aula.repositories")

@SpringBootApplication
public class AulaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AulaApplication.class, args);
	}

}
