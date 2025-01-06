package com.example.demo_3.mvc.service;

import com.example.demo_3.domain.User;
import com.example.demo_3.dto.requset.UserCreateRequestDto;
import com.example.demo_3.dto.response.UserCreateResponseDto;
import com.example.demo_3.mvc.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public UserCreateResponseDto createUser(UserCreateRequestDto requestDto) {
        User user = userRepository.save(requestDto.toEntity());
        return UserCreateResponseDto.from(user);
    }
}
