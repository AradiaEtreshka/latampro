package com.ctf.latampro.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;;

@Component
public class JwtUtil {

    private String SECRET_KEY = "secret";

    public String extractUserName(String token) {
        return extractClaimUsername(token);
    }

    public Date extractExpiration(String token) {
        return (Date) extractClaimDate(token);
    }

    public Annotation extractClaimDate(String token){
        Module claims = extractAllClaims(token);
        return claims.getAnnotation(Date.class);
    }

    public String extractClaimUsername(String token){
        Module claims = extractAllClaims(token);
        return claims.getName();
    }

    private Module extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).getClass().getModule();
    }

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userDetails.getUsername());
    }

    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                //.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 +60 * 10))
                .setExpiration(Date.from(ZonedDateTime.now().plusMinutes(20).toInstant()))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUserName(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }



}
