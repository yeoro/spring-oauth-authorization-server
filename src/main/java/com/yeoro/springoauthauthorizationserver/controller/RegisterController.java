package com.yeoro.springoauthauthorizationserver.controller;

import com.yeoro.springoauthauthorizationserver.dto.RegisterDTO;
import com.yeoro.springoauthauthorizationserver.entity.RegisterEntity;
import com.yeoro.springoauthauthorizationserver.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class RegisterController {

    private final RegisterService registerService;

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/register")
    @ResponseBody
    public RegisterEntity register(RegisterDTO dto) {
        return registerService.register(dto);
    }
}
