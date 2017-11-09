package com.aliniribeiro.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.aliniribeiro.api.common.PasswordCommon;
import com.aliniribeiro.api.model.company.CompanyRepository;
import com.aliniribeiro.api.model.employee.EmployeeEntity;
import com.aliniribeiro.api.model.employee.EmployeeRepository;
import com.aliniribeiro.api.security.ProfileEnum;

@SpringBootApplication
public class SpringBootFirstProjectApplication {

	@Autowired
	private CompanyRepository companyRepository;


	@Autowired
	private EmployeeRepository employeeRepository;

	
	private int commandRunner;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootFirstProjectApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {

			EmployeeEntity usuario = new EmployeeEntity();
			usuario.setEmail("usuario@email.com");
			usuario.setProfile(ProfileEnum.ROLE_USER);
			usuario.setPassword(PasswordCommon.generateBcrypt("123456"));
			employeeRepository.save(usuario);

			EmployeeEntity admin = new EmployeeEntity();
			admin.setEmail("admin@email.com");
			admin.setProfile(ProfileEnum.ROLE_ADMIN);
			admin.setPassword(PasswordCommon.generateBcrypt("123456"));
			employeeRepository.save(admin);

			// CompanyEntity company = new CompanyEntity();
			// company.setCnpj("123456");
			// company.setSocialName("Empresatest");
			// this.companyRepository.save(company);
			//
			// List<CompanyEntity> copmpanies = companyRepository.findAll();
			// copmpanies.forEach(System.out::println);
			//
			// CompanyEntity companyDb = companyRepository.findOne(1L);
			// System.out.println("Empresa por ID: "+ companyDb);
			//
			// CompanyEntity companyByCNPJ = companyRepository.findByCnpj("123456");
			// System.out.println("Empresa por CNPJ: "+ companyByCNPJ);
			//
			//
			// String passwordEncoded = PasswordCommon.generateBcrypt("123456");
			// System.out.println("Encoded password : " + passwordEncoded);
			//
			// String passwordEncodedAgain = PasswordCommon.generateBcrypt("123456");
			// System.out.println("Encoded password again : " + passwordEncodedAgain);
			//
			// System.out.println("Senha válida : " +
			// PasswordCommon.validatePassword("123456", passwordEncoded));

			System.out.println("#### Testando em 1, 2, 3 ....");
		};
	}
}
