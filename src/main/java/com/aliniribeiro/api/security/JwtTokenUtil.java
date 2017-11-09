package com.aliniribeiro.api.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
@Profile("dev")
public class JwtTokenUtil {

	static final String CLAIM_KEY_USERNAME = "sub";
	static final String CLAIM_KEY_ROLE = "role";
	static final String CLAIM_KEY_CREATED = "created";

	@Value("${jwt.secret}")
	private String secret;

	@Value("${jwt.expiration}")
	private int expiration;

	//Clains é o nome que se da para os atributos dentro do token
	/**
	 * Obtém o username contido no token (email).
	 * @param token
	 * @return username do token
	 */
	public String getUsernameFromToken(String token) {
		String username;
		try {
			Claims claims = getClaimsFromToken(token);
			username = claims.getSubject();
		} catch (Exception e) {
			username = null;
		}
		return username;
	}

	/**
	 * Realiza o parse do token JWT para extrair as informações contidas em seu
	 * corpo.
	 * 
	 * @param token
	 * @return
	 */
	private Claims getClaimsFromToken(String token) {
		Claims claims;
		try {
			claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		} catch (Exception e) {
			claims = null;
		}
		return claims;
	}
	
	/**
	 * Busca a data de expiração do token
	 * @param token
	 * @return
	 */
	private Date getExpirationDateFromToken(String token) {
		Date date;
		try {
			Claims claims = getClaimsFromToken(token);
			date = claims.getExpiration();
		} catch (Exception e) {
			date = null;
		}
		return date;
	}
	
	/**
	 *  Cria um novo token
	 * @param token
	 * @return
	 */
	public String refreshToken(String token) {
		String refreshToken;
		try {
			Claims claims = getClaimsFromToken(token);
			claims.put(CLAIM_KEY_CREATED, new Date());
			refreshToken = generateToken(claims);
		} catch (Exception e) {
			refreshToken = null;
		}
		return refreshToken;
	}
	
	/**
	 * Verifica se o token é valido
	 * @param token
	 * @return
	 */
	public boolean isTokenValid(String token) {
		return !tokenExpired(token);
	}
	
	/**
	 * Retorna um novo token JWT com base nos dados do usuário
	 * @param userDetails
	 * @return
	 */
	public String getToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
		claims.put(CLAIM_KEY_USERNAME, userDetails.getUsername());
		userDetails.getAuthorities().forEach(autorithy -> claims.put(CLAIM_KEY_ROLE, autorithy.getAuthority()));
		claims.put(CLAIM_KEY_CREATED, new Date());
		
		return  generateToken(claims);
	}
	
	private Date generateExpirationDate() {
		return new Date(System.currentTimeMillis() + expiration * 1000);	
	}
	
	private boolean tokenExpired(String token) {
		Date expirationDate = this.getExpirationDateFromToken(token);
		if (expirationDate == null) {
			return false;
		}
		return expirationDate.before(new Date());
	}
	
	private String generateToken(Map<String, Object> claims) {
		return Jwts.builder().setClaims(claims).setExpiration(generateExpirationDate())
				.signWith(SignatureAlgorithm.HS512, secret).compact();
	}
}
