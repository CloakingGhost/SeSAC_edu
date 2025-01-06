package com.example.demo_3.mvc.controller;

import com.example.demo_3.dto.requset.UserCreateRequestDto;
import com.example.demo_3.dto.response.UserCreateResponseDto;
import com.example.demo_3.mvc.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserCreateResponseDto createUser(@RequestBody UserCreateRequestDto requestDto) {
        return userService.createUser(requestDto);
    }
}
