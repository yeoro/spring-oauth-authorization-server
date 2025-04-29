package com.yeoro.springoauthauthorizationserver.repository;

import com.yeoro.springoauthauthorizationserver.entity.RegisterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegisterRepository extends JpaRepository<RegisterEntity, String> {

    Optional<RegisterEntity> findByClientId(String clientId);
}
