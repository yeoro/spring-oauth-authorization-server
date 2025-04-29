package com.yeoro.springoauthauthorizationserver.controller;

import com.yeoro.springoauthauthorizationserver.dto.UserDTO;
import com.yeoro.springoauthauthorizationserver.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class JoinController {

    private final UserService userService;

    @GetMapping("/join")
    public String joinPage() {
        return "joinPage";
    }

    @PostMapping("/join")
    @ResponseBody
    public String join(UserDTO dto) {
        userService.join(dto);
        return "ok";
    }
}
