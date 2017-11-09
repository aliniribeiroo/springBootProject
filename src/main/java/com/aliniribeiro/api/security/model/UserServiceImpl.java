package com.aliniribeiro.api.security.model;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aliniribeiro.api.model.employee.EmployeeEntity;
import com.aliniribeiro.api.model.employee.EmployeeRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Optional<EmployeeEntity> findByEmail(String email) {
		return Optional.ofNullable(employeeRepository.findByEmail(email));
	}

}
