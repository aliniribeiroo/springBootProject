package com.aliniribeiro.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.aliniribeiro.api.common.PasswordCommon;

@SpringBootApplication
public class SpringBootFirstProjectApplication {

	@Value("${command.runnerTest}")
	private int commandRunner;
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootFirstProjectApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			String passwordEncoded = PasswordCommon.generateBcrypt("123456");
			System.out.println("Encoded password : " + passwordEncoded);
			
			String passwordEncodedAgain = PasswordCommon.generateBcrypt("123456");
			System.out.println("Encoded password again : " + passwordEncodedAgain);
			
			System.out.println("Senha válida : " + PasswordCommon.validatePassword("123456", passwordEncoded));
			
			System.out.println("#### Testando em 1, 2, 3 ...." + this.commandRunner);
		};
	}
}
