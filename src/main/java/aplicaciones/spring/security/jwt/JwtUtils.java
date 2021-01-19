package aplicaciones.spring.security.jwt;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import aplicaciones.spring.security.services.UserDetailsImpl;
import io.jsonwebtoken.*;

@Component
public class JwtUtils {
	private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);
	
	@Value("${food.app.jwtSecret}")
	private String jwtSecret;
	
	@Value("${food.app.jwtExpirationMs}")
	private int jwtExpirationMs;
	
	public String generateJwtToken(Authentication authentication) {
		
		UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
		
		return Jwts.builder()
				.setSubject((userPrincipal.getUsername()))
				.setIssuedAt(new Date())
				.setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
				.signWith(SignatureAlgorithm.HS512, jwtSecret)
				.compact();
	}
	
	public String getUserNameFromJwtToken(String token) {
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();	
	}
	
	public boolean validateJwtToken(String authtoken) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authtoken);
			return true;
		} catch (SignatureException e) {
			logger.error("JWT no valida: {}", e.getMessage());
		} catch (MalformedJwtException e) {
			logger.error("JWT token invalida: {}", e.getMessage());
		} catch (ExpiredJwtException e) {
			logger.error("JWT token expirada: {}", e.getMessage());
		} catch (UnsupportedJwtException e) {
			logger.error("JWT token no admitido: {}", e.getMessage());
		} catch (IllegalArgumentException e) {
			logger.error("La cadena de reclamaciones de JWT está vacía: {}", e.getMessage());
		}
		return false;
	}
}
