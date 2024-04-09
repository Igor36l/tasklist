package com.studyproject.tasklist.web.controller;

import com.studyproject.tasklist.domain.user.User;
import com.studyproject.tasklist.service.AuthService;
import com.studyproject.tasklist.service.UserService;
import com.studyproject.tasklist.web.dto.auth.JwtRequest;
import com.studyproject.tasklist.web.dto.auth.JwtResponse;
import com.studyproject.tasklist.web.dto.user.UserDto;
import com.studyproject.tasklist.web.dto.validation.OnCreate;
import com.studyproject.tasklist.web.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Validated
public class AuthController {

    private final AuthService authService;
    private final UserService userService;

    private final UserMapper userMapper;

    @PostMapping("/login")
    public JwtResponse login(@Validated @RequestBody JwtRequest loginRequest) {
        return authService.login(loginRequest);
    }

    @PostMapping("/register")
    public UserDto register(@Validated(OnCreate.class) @RequestBody UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        User createdUser = userService.create(user);
        return userMapper.toDto(createdUser);
    }

    @PostMapping("/refresh") //TODO
    public JwtResponse refresh(@Validated @RequestBody String refreshRequest) {
        return authService.refresh(refreshRequest);
    }
}
