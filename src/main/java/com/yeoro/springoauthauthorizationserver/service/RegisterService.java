package com.yeoro.springoauthauthorizationserver.service;

import com.yeoro.springoauthauthorizationserver.dto.RegisterDTO;
import com.yeoro.springoauthauthorizationserver.entity.RegisterEntity;
import com.yeoro.springoauthauthorizationserver.repository.RegisterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RegisterService {

    private final RegisterRepository registerRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public RegisterEntity register(RegisterDTO dto) {

        RegisterEntity entity = new RegisterEntity();

        entity.setId(UUID.randomUUID().toString());
        entity.setClientId(UUID.randomUUID().toString());
        entity.setClientIdIssuedAt(Instant.now());
        entity.setClientSecret(bCryptPasswordEncoder.encode(UUID.randomUUID().toString()));
        entity.setClientAuthenticationMethods("client_secret_basic");
        entity.setAuthorizationGrantTypes("refresh_token,authorization_code");

        entity.setClientName(dto.getClientName());
        entity.setRedirectUris(dto.getRedirectUris());
        entity.setPostLogoutRedirectUris(dto.getPostLogoutRedirectUris());
        entity.setScopes(dto.getScopes());

        entity.setClientSettings("{" +
                "\"@class\":\"java.util.Collections$UnmodifiableMap\"," +
                "\"settings.client.require-proof-key\":false," +
                "\"settings.client.require-authorization-consent\":true" +
                "}");

        entity.setTokenSettings("{" +
                "\"@class\":\"java.util.Collections$UnmodifiableMap\"," +
                "\"settings.token.reuse-refresh-tokens\":true," + //true(액세스 재발급, 리프레시 재사용), false(액세스, 리프레시 재발급)
                "\"settings.token.x509-certificate-bound-access-tokens\":false," +
                "\"settings.token.id-token-signature-algorithm\":[\"org.springframework.security.oauth2.jose.jws.SignatureAlgorithm\",\"RS256\"]," +
                "\"settings.token.access-token-time-to-live\":[\"java.time.Duration\",300.000000000]," +
                "\"settings.token.access-token-format\":{\"@class\":\"org.springframework.security.oauth2.server.authorization.settings.OAuth2TokenFormat\",\"value\":\"self-contained\"}," +
                "\"settings.token.refresh-token-time-to-live\":[\"java.time.Duration\",3600.000000000]," +
                "\"settings.token.authorization-code-time-to-live\":[\"java.time.Duration\",20.000000000]," +
                "\"settings.token.device-code-time-to-live\":[\"java.time.Duration\",300.000000000]" +
                "}");

        return registerRepository.save(entity);
    }
}
