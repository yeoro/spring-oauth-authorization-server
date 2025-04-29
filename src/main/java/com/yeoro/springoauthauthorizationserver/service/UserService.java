package com.yeoro.springoauthauthorizationserver.service;

import com.yeoro.springoauthauthorizationserver.dto.UserDTO;
import com.yeoro.springoauthauthorizationserver.entity.UserEntity;
import com.yeoro.springoauthauthorizationserver.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void join(UserDTO dto) {

        UserEntity entity = new UserEntity();
        entity.setUsername(dto.getUsername());
        entity.setPassword(passwordEncoder.encode(dto.getPassword()));
        entity.setNickname(dto.getNickname());
        entity.setPhone(dto.getPhone());
        entity.setRole("ADMIN");

        userRepository.save(entity);

    }
}
