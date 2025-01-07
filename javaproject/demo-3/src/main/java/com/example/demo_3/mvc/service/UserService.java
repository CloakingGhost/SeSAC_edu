package com.example.demo_3.mvc.service;

import com.example.demo_3.domain.User;
import com.example.demo_3.dto.requset.UserCreateRequestDto;
import com.example.demo_3.dto.requset.UserUpdateRequestDto;
import com.example.demo_3.dto.response.UserListResponseDto;
import com.example.demo_3.dto.response.UserResponseDto;
import com.example.demo_3.mvc.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    public UserResponseDto readUser(Long id) {
        User user = userRepository.findById(id).orElseThrow();

        return UserResponseDto.from(user);
    }

    @Transactional
    public UserResponseDto updateUser(Long id, UserUpdateRequestDto requestDto) {
        User user = userRepository.findById(id).orElseThrow();
        user.update(requestDto);
        return UserResponseDto.from(user);
    }

    @Transactional
    public void removeUser(Long id){
        User entity = userRepository.findById(id).orElseThrow();
        entity.setIsActive(false);

    }

    public UserResponseDto findByNickname(String nickname){
        User user = userRepository.findByNickname(nickname).orElseThrow();

        return UserResponseDto.from(user);
    }
}
