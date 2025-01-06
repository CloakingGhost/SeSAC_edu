package com.example.demo.myjpasitev5.dto;

import com.example.demo.myjpasitev4.PostV4;
import com.example.demo.myjpasitev5.PostV5;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder // @AllArgsConstructor 자동 생성
public class PostResponseDto {
    private final Long id;

    private final String title;
    private final String content;
    private final String author;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static PostResponseDto from(PostV5 entity) {
        return PostResponseDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .content(entity.getContent())
                .author(entity.getAuthor())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }
}
