package com.example.demo_3.mvc.service;

import com.example.demo_3.domain.user.entity.User;
import com.example.demo_3.domain.user.dto.requset.UserCreateRequestDto;
import com.example.demo_3.domain.user.dto.requset.UserUpdateRequestDto;
import com.example.demo_3.domain.user.dto.response.UserListResponseDto;
import com.example.demo_3.domain.user.dto.response.UserResponseDto;
import com.example.demo_3.domain.user.feature.UserSearchSpecifications;
import com.example.demo_3.mvc.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
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
    public void removeUser(Long id) {
        User entity = userRepository.findById(id).orElseThrow();
        entity.setIsActive(false);

    }

    public List<UserResponseDto> searchUsers(String nickname, Integer minAge, Integer maxAge, Boolean active, String email) {
        Specification<User> spec = Specification.where(null);

        if (nickname != null) {
            spec = spec.and(UserSearchSpecifications.hasNickname(nickname));
        }

        if (minAge != null && maxAge != null) {
            spec = spec.and(UserSearchSpecifications.hasAge(minAge, maxAge));
        }

        if (active != null) {
            spec = spec.and(UserSearchSpecifications.isActiveStatus(active));
        }

        if (email != null) {
            spec = spec.and(UserSearchSpecifications.hasEmailContaining(email));
        }


        return userRepository.findAll(spec).stream().map(UserResponseDto::from).toList();
    }
}
