package com.example.demo_3.dto.response;

import com.example.demo_3.domain.User;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder // @AllArgsConstructor 사용됨
public class UserResponseDto {

    private String username;
    private String email;
    private String nickname;
    private Integer age;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;



    public static UserResponseDto from(User entity){
        return UserResponseDto.builder()
                .username(entity.getUsername())
                .email(entity.getEmail())
                .nickname(entity.getNickname())
                .age(entity.getAge())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }
}
