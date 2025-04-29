package com.yeoro.springoauthauthorizationserver.repository;

import com.yeoro.springoauthauthorizationserver.entity.ConsentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConsentRepository extends JpaRepository<ConsentEntity, String> {

    Optional<ConsentEntity> findByRegisteredClientIdAndPrincipalName(String registeredClientId, String principalName);
    void deleteByRegisteredClientIdAndPrincipalName(String registeredClientId, String principalName);
}
