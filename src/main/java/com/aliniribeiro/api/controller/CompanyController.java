package com.aliniribeiro.api.controller;


import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aliniribeiro.api.common.Response;
import com.aliniribeiro.api.dtos.CompanyDto;

@RestController
@RequestMapping("api/company")
public class CompanyController {

	@PostMapping
	public ResponseEntity<Response<CompanyDto>> example(@Valid @RequestBody CompanyDto companyDto, BindingResult result) {
		Response<CompanyDto> response = new Response<CompanyDto>();
		
		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		companyDto.setId(1);
		response.setData(companyDto);
		return ResponseEntity.ok(response);
	}
	
	/**
	 *  Versionamento da APi pelo Heaser 'X-API-Version=xxx'
	 * @param name
	 * @return
	 */
	@GetMapping(value = "/test/version", headers = "X-API-Version=v1")
	public ResponseEntity<String> testVersionV1(@PathVariable("name") String name){
		return ResponseEntity.ok(String.format("API com a versão 1: Olá %s!! ",name));
	}
}
