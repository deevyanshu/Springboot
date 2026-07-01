package com.deevyanshu.api.Filter;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Base64;

@Component
public class JwtUtil {

    public static final String SECRET_KEY="Adfhudfhodjdfhc46ibkdbubojifdpdjfsjbb";

    private Key getKey()
    {
        byte[] bytes= Base64.getDecoder().decode(SECRET_KEY);

        return Keys.hmacShaKeyFor(bytes);
    }

    public void validateToken(String token) {
        Jwts.parser().verifyWith((SecretKey) getKey()).build().parseSignedClaims(token);
    }
}
