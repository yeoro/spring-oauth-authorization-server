package com.yeoro.springoauthauthorizationserver.service;

import com.yeoro.springoauthauthorizationserver.entity.UserEntity;
import com.yeoro.springoauthauthorizationserver.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity entity = userRepository.findByUsername(username).orElseThrow();

        //Authorization Server 의존성과 CustomUserDetails를 같이 쓰면 SecurityJackson2 모듈에서 역직렬화 문제 발생
        //Spring Security User로 return
        return User.builder()
                .username(entity.getUsername())
                .password(entity.getPassword())
                .roles(entity.getRole())
                .build();
    }
}
