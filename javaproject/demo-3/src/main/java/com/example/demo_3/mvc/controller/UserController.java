package com.example.demo_3.mvc.controller;

import com.example.demo_3.dto.requset.UserCreateRequestDto;
import com.example.demo_3.dto.response.UserListResponseDto;
import com.example.demo_3.dto.response.UserResponseDto;
import com.example.demo_3.mvc.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserResponseDto createUser(@Valid @RequestBody UserCreateRequestDto requestDto) {
        return userService.createUser(requestDto);
    }

    @GetMapping
    public List<UserListResponseDto> readUsers(){
        return userService.readUsers();
    }
}
