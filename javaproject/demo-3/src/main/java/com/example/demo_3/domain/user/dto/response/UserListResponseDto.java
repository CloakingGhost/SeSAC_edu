package com.example.demo_3.domain.user.dto.response;

import com.example.demo_3.domain.user.entity.User;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class UserListResponseDto {
    private Long id;
    private String username;
    private boolean isActive;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static UserListResponseDto from(User entity) {
        return UserListResponseDto.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .isActive(entity.getIsActive())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }

}
