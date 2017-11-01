package com.aliniribeiro.api.model.employee;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Serializable> {

	EmployeeEntity findByEmail(String email);
}
