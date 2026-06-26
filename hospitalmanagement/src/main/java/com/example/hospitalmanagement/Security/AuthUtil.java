package com.example.hospitalmanagement.Security;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;

import com.example.hospitalmanagement.Entity.AuthProviderType;
import com.example.hospitalmanagement.Entity.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class AuthUtil {
    
    private String jwtSecretKey= "sdjfbskbdiusahohdsiubcsbc83eur3uvr2u32u32u3";

    private SecretKey getSecretKey()
    {
        return Keys.hmacShaKeyFor(jwtSecretKey.getBytes(StandardCharsets.UTF_8));
    }

    public String generateAccessToken(User user)
    {
        return Jwts.builder().subject(user.getUsername()).
        claim("userId",user.getId().toString()).issuedAt(new Date()).expiration(new Date(System.currentTimeMillis()+ 1000*60*10))
        .signWith(getSecretKey())
        .compact();
    }

    public String getUsernameFromToken(String token)
    {
        Claims claims= Jwts.parser().verifyWith(getSecretKey()).build()
        .parseSignedClaims(token).getPayload();
        return claims.getSubject();
    }

    public AuthProviderType getProviderTypeFromRegistrationId(String registrationId)
    {
        return switch(registrationId.toLowerCase())
        {
            case "google"-> AuthProviderType.GOOGLE;
            case "facebook"-> AuthProviderType.FACEBOOK;
            case "github"-> AuthProviderType.GITHUB;
            default-> throw new IllegalArgumentException("Unsupported provider type:"+registrationId);
        };
    }

    public String determineProviderIdFromOAuth2User(OAuth2User oAuth2User,String registrationId)
    {
        String providerId= switch(registrationId.toLowerCase()){
            case "google"-> oAuth2User.getAttribute("sub");
            case "github"-> oAuth2User.getAttribute("id").toString();
            default-> throw new IllegalArgumentException("Unsupported provider type:"+registrationId);
        };

        if(providerId==null || providerId.isBlank())
            {
                throw new IllegalArgumentException("Provider ID not found in OAuth2User attributes for provider:"+registrationId);
            }
        return providerId;
    }

    public String determineUsernameFromOAuth2User(OAuth2User oAuth2User,String registrationId,String providerId)
    {
        String email= oAuth2User.getAttribute("email");

        if(email!=null && !email.isBlank())
            {
                return email;
            }
        
            return switch(registrationId.toLowerCase()){
                case "google"-> oAuth2User.getAttribute("sub");
                case "github"-> oAuth2User.getAttribute("login");
                default-> providerId;
            };
    }
}
