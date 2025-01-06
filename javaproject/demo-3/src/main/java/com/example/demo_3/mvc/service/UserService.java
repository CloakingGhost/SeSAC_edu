package com.example.demo_3.mvc.service;

import com.example.demo_3.domain.User;
import com.example.demo_3.dto.requset.UserCreateRequestDto;
import com.example.demo_3.dto.response.UserListResponseDto;
import com.example.demo_3.dto.response.UserResponseDto;
import com.example.demo_3.mvc.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public UserResponseDto createUser(UserCreateRequestDto requestDto) {
        User user = userRepository.save(requestDto.toEntity());
        return UserResponseDto.from(user);
    }

    public List<UserListResponseDto> readUsers() {
        List<User> users = userRepository.findAll();


        return users.stream().map(UserListResponseDto::from)
                .toList();


    }
}
