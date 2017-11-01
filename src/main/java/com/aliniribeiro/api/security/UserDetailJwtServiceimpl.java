package com.aliniribeiro.api.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.aliniribeiro.api.model.employee.EmployeeEntity;
import com.aliniribeiro.api.model.employee.EmployeeService;

public class UserDetailJwtServiceimpl implements UserDetailService {

	@Autowired
	EmployeeService employeeService;
	
	@Override
	public UserDetails loadUserByUsername(String username) {
		Optional<EmployeeEntity> employee = employeeService.getUserbyEmail(username);
		
		if (employee.isPresent()) {
			return JwtUserFactory.create(employee.get());
		}

		throw new UsernameNotFoundException("Email não encontrado");
	}

}
