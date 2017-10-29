package com.aliniribeiro.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.aliniribeiro.api.common.PasswordCommon;
import com.aliniribeiro.api.jpapersistence.model.company.CompanyEntity;
import com.aliniribeiro.api.jpapersistence.model.company.CompanyRepository;

@SpringBootApplication
public class SpringBootFirstProjectApplication {

	@Autowired
	private CompanyRepository companyRepository;
	
	@Value("${command.runnerTest}")
	private int commandRunner;
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootFirstProjectApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			
//			CompanyEntity company = new CompanyEntity();
//			company.setCnpj("123456");
//			company.setSocialName("Empresatest");
//			this.companyRepository.save(company);
//			
//			List<CompanyEntity> copmpanies = companyRepository.findAll();
//			copmpanies.forEach(System.out::println);
//			
//			CompanyEntity companyDb = companyRepository.findOne(1L);
//			System.out.println("Empresa por ID: "+ companyDb);
//			
//			CompanyEntity companyByCNPJ = companyRepository.findByCnpj("123456");
//			System.out.println("Empresa por CNPJ: "+ companyByCNPJ);
//			
//			
//			String passwordEncoded = PasswordCommon.generateBcrypt("123456");
//			System.out.println("Encoded password : " + passwordEncoded);
//			
//			String passwordEncodedAgain = PasswordCommon.generateBcrypt("123456");
//			System.out.println("Encoded password again : " + passwordEncodedAgain);
//			
//			System.out.println("Senha válida : " + PasswordCommon.validatePassword("123456", passwordEncoded));
			
			System.out.println("#### Testando em 1, 2, 3 ...." + this.commandRunner);
		};
	}
}
