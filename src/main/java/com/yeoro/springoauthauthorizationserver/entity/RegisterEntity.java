package com.yeoro.springoauthauthorizationserver.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name = "oauth2_register")
@Getter
@Setter
public class RegisterEntity {

    @Id
    private String id;

    //서비스측에서 랜덤값 (PK)
    private String clientId;

    //ClientId 생성 시점
    private Instant clientIdIssuedAt;

    //서비스측에서 랜덤값
    private String clientSecret;

    //ClientSecret 만료시간
    private Instant clientSecretExpiresAt;

    //3자 플랫폼이 설정한 어플리케이션 이름
    private String clientName;

    //3자 플랫폼이 사용할 인증 방식
    @Column(length = 1000)
    private String clientAuthenticationMethods;

    //OAuth2 인증 방식 4종류 중 한가지
    @Column(length = 1000)
    private String authorizationGrantTypes;

    //3자 플랫폼이 코드를 받기 위해 허용 uri
    @Column(length = 1000)
    private String redirectUris;

    //OAuth2 로그아웃 후 리디렉션 장소
    @Column(length = 1000)
    private String postLogoutRedirectUris;

    //3자 플랫폼이 가질 권한 범위
    @Column(length = 1000)
    private String scopes;

    //첫 로그인시 동의 표시와 같은 설정을 JSON으로 보관
    @Column(length = 2000)
    private String clientSettings;

    //CODE나 JWT 활성 시간과 같은 설정을 JSON으로 보관
    @Column(length = 2000)
    private String tokenSettings;
}
