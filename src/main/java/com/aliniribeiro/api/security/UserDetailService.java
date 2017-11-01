package com.aliniribeiro.api.security;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserDetailService {

	UserDetails loadUserByUsername(String Username);
}
