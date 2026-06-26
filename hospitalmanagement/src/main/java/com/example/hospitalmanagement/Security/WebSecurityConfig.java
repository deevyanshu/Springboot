package com.example.hospitalmanagement.Security;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import com.example.hospitalmanagement.Entity.PermissionType;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
@EnableMethodSecurity
public class WebSecurityConfig {

    private final JwtAuthFilter jwtAuthFilter;
    private final OAuth2SuccessHandler oAuth2SuccessHandler;
    private final HandlerExceptionResolver resolver;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.csrf(csrfConfig->csrfConfig.disable()).
        sessionManagement(sessionConfig->sessionConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS)).
        authorizeHttpRequests(auth->auth.
        requestMatchers("public/**","/auth/**").permitAll().
        requestMatchers(HttpMethod.DELETE,"/admin/**").hasAnyAuthority(PermissionType.APPOINTMENT_DELETE.name(),PermissionType.USER_MANAGE.name()).
        requestMatchers("admin/**").hasRole("ADMIN")
        .requestMatchers("/doctors/**").hasAnyRole("DOCTOR","ADMIN")
    ).addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class).
    oauth2Login(oAuth2->oAuth2.failureHandler(
        new AuthenticationFailureHandler()
        {

            @Override
            public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                    AuthenticationException exception) throws IOException, ServletException {
                // TODO Auto-generated method stub
                resolver.resolveException(request, response, null, exception);
            }
            
        }
    ).successHandler(oAuth2SuccessHandler)).exceptionHandling(exceptionConfig->exceptionConfig.accessDeniedHandler(new AccessDeniedHandler() {

        @Override
        public void handle(HttpServletRequest request, HttpServletResponse response,
                AccessDeniedException accessDeniedException) throws IOException, ServletException {
            resolver.resolveException(request, response, null, accessDeniedException);
        }
            
    }));

        return httpSecurity.build();
    }
    
}
