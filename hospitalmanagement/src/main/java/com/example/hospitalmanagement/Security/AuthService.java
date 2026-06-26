package com.example.hospitalmanagement.Security;

import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.example.hospitalmanagement.Dto.LoginRequestDto;
import com.example.hospitalmanagement.Dto.LoginResponseDto;
import com.example.hospitalmanagement.Dto.SignupRequestDto;
import com.example.hospitalmanagement.Dto.SignupResponseDto;
import com.example.hospitalmanagement.Entity.AuthProviderType;
import com.example.hospitalmanagement.Entity.Patient;
import com.example.hospitalmanagement.Entity.Role;
import com.example.hospitalmanagement.Entity.User;
import com.example.hospitalmanagement.Repository.PatientRepository;
import com.example.hospitalmanagement.Repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;

    private final AuthUtil authUtil;

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final PatientRepository patientRepository;
    
    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        Authentication authentication= authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginRequestDto.getUsernme(), loginRequestDto.getPassword())
        );

        User user= (User)authentication.getPrincipal();

        String token=authUtil.generateAccessToken(user);

        return new LoginResponseDto(token, user.getId());
    }

    public User signUpInternal(SignupRequestDto signupRequestDto, AuthProviderType authProviderType, String providerId){
        User user= userRepository.findByUsername(signupRequestDto.getUsername()).orElse(null);

        if(user!=null) throw new IllegalArgumentException("User already exists");   
        
        
        user=User.builder().username(signupRequestDto.getUsername()).roles(signupRequestDto.getRoles())
        .providerId(providerId).providerType(authProviderType).build();

        if(authProviderType==AuthProviderType.EMAIL){
            user.setPassword(passwordEncoder.encode(signupRequestDto.getPassword()));
        }
        userRepository.save(user);        
        Patient patient=Patient.builder().name(signupRequestDto.getName()).email(signupRequestDto.getUsername()).user(user).build();

        patientRepository.save(patient);
        return userRepository.save(user);
        
    }
    
    // method for email signup from controller
    public SignupResponseDto signup(SignupRequestDto signupRequestDto){
       User user= signUpInternal(signupRequestDto, AuthProviderType.EMAIL,null);
        return new SignupResponseDto(user.getId(),user.getUsername());
    }

    @Transactional
    public ResponseEntity<LoginResponseDto> handleOAuth2LoginRequest(OAuth2User oAuth2User, String registrationId) {
        AuthProviderType providerType= authUtil.getProviderTypeFromRegistrationId(registrationId);
        String providerId = authUtil.determineProviderIdFromOAuth2User(oAuth2User, registrationId);
        
        User user= userRepository.findByProviderTypeAndProviderId(providerType, providerId).orElse(null);

        String email=oAuth2User.getAttribute("email");
        String name=oAuth2User.getAttribute("name");

        User emailUser=userRepository.findByUsername(email).orElse(null);

        if(user==null && emailUser==null)
            {
                //signup
                String username=authUtil.determineUsernameFromOAuth2User(oAuth2User, registrationId, providerId);
                user= signUpInternal(
                    new SignupRequestDto(username, null,name,Set.of(Role.PATIENT)),providerType,providerId
                );
            }else if(user!=null){
                if(!email.isBlank() && email!=null && !email.equals(user.getUsername())){
                    user.setUsername(email);
                    userRepository.save(user);
                }
            }else{
                throw new BadCredentialsException("This email is already registered with provider"+ emailUser.getProviderType());
            }
        
            //login
        LoginResponseDto loginResponseDto= new LoginResponseDto(authUtil.generateAccessToken(user), user.getId());

        return ResponseEntity.ok(loginResponseDto);
    }
}
