package com.aliniribeiro.api.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.aliniribeiro.api.model.employee.EmployeeEntity;

public class JwtUserFactory {

	private JwtUserFactory() {

	}

	/**
	 * Converte e gera um Usuário com base nos dados do colaborador
	 * 
	 * @param employee
	 * @return
	 */
	public static JwtUser create(EmployeeEntity employee) {
		return new JwtUser(employee.getId(), employee.getEmail(), employee.getPassword(),
				mapToGrantedAuthorities(employee.getProfile()));
	}

	/**
	 * Converte o perfil do usuário para o formato utilizado no Spring Security
	 * 
	 * @return uma lista de GrantedAuthority
	 */
	private static List<GrantedAuthority> mapToGrantedAuthorities(ProfileEnum profile) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(profile.toString()));
		return authorities;
	}

}
