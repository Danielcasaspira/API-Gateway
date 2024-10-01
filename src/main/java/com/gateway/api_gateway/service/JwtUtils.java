package com.gateway.api_gateway.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtUtils {

    private final String secretKey = "p7oK7dsV9x0HkjF7JrGfTrShL9NC82qH+ImG/OUX8MvJxHeD3M3lql5wvNhcJ5PfBYLC1z+mWCUrrcFXHFvOwA==";

    public Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean isExpired(String token){
        try {
            return getClaims(token).getExpiration().before(new Date());
        } catch (Exception e){
            return false;
        }
    }

    public Integer extractUserId(String token){
        try {
            return Integer.parseInt(getClaims(token).getSubject());
        } catch (Exception e){
            return null;
        }
    }

}
