package com.example.hospitalmanagement.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hospitalmanagement.Entity.AuthProviderType;
import com.example.hospitalmanagement.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);

    Optional<User> findByProviderTypeAndProviderId(AuthProviderType providerType, String providerId);
}
