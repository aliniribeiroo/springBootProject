package com.aliniribeiro.api.model.employee;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeRepositoryImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Optional<EmployeeEntity> getUserbyEmail(String email) {
		return Optional.ofNullable(this.employeeRepository.findByEmail(email));
	}

}
