package com.aliniribeiro.api.security.model;

import java.util.Optional;

import com.aliniribeiro.api.model.employee.EmployeeEntity;

public interface UserService {

	/**
	 * Busca e retorna um usuário dado um email.
	 * 
	 * @param email
	 * @return Optional<Usuario>
	 */
	Optional<EmployeeEntity> findByEmail(String email);
}
