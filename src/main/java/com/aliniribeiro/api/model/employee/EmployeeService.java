package com.aliniribeiro.api.model.employee;

import java.util.Optional;

public interface EmployeeService {

	Optional <EmployeeEntity> getUserbyEmail(String email);
	
}
