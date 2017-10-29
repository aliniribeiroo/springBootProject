package com.aliniribeiro.api.jpapersistence.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aliniribeiro.api.jpapersistence.dtos.CompanyDto;

@RestController
@RequestMapping("api/company")
public class CompanyController {

	@PostMapping
	public ResponseEntity<CompanyDto> example(@RequestBody CompanyDto companyDto) {
		companyDto.setId(1);
		return ResponseEntity.ok(companyDto);
	}
}
