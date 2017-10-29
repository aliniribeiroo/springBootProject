package com.aliniribeiro.api.dtos;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CNPJ;

public class CompanyDto {

	private int id;
	private String socialName;
	private String cnpj;

	public CompanyDto() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@NotEmpty(message = "A Razão social não pode ser nula.")
	@Length(min = 5, max = 200, message = "A razão social não deve conter entre 5 e 200 carácteres.")
	public String getSocialName() {
		return socialName;
	}

	public void setSocialName(String socialName) {
		this.socialName = socialName;
	}

	@NotEmpty(message = "CNPJ não deve ser vazio.")
	@CNPJ(message = "CNPJ inválido")
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
}
