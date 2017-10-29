package com.aliniribeiro.api.model.company;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<CompanyEntity, Long> {
	
	CompanyEntity findByCnpj(String cnpj);
}
