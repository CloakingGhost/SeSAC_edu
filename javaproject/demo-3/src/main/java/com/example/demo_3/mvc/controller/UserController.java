package com.example.demo_3.mvc.controller;

import com.example.demo_3.domain.User;
import com.example.demo_3.dto.requset.UserCreateRequestDto;
import com.example.demo_3.dto.requset.UserUpdateRequestDto;
import com.example.demo_3.dto.response.UserListResponseDto;
import com.example.demo_3.dto.response.UserResponseDto;
import com.example.demo_3.mvc.repository.UserRepository;
import com.example.demo_3.mvc.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;


    @PostMapping
    public UserResponseDto createUser(@Valid @RequestBody UserCreateRequestDto requestDto) {
        return userService.createUser(requestDto);
    }

    @GetMapping
    public List<UserListResponseDto> readUsers(){
        return userService.readUsers();
    }

    @GetMapping("/{id}")
    public UserResponseDto readUser(@PathVariable Long id){
        return userService.readUser(id);
    }

    @PutMapping("/{id}")
    public UserResponseDto updateUser(@PathVariable Long id, @Valid @RequestBody UserUpdateRequestDto requestDto) {
        return userService.updateUser(id, requestDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeUser(@PathVariable Long id){
        userService.removeUser(id);
    }

    @GetMapping("/search")
    public List<User> search(
            @RequestParam(required = false) int value
                                  )
    {
        List<User> users = userRepository.findByIsActiveFalseAndAgeGreaterThan(value);
        return users;
    }
}
