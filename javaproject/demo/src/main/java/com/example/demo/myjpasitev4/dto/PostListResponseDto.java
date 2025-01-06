package com.example.demo.myjpasitev4.dto;

import com.example.demo.myjpasitev4.PostV4;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder // @AllArgsConstructor 자동 생성
public class PostListResponseDto {
    private final Long id;

    private final String title;

    public static PostListResponseDto from(PostV4 entity) {
//        return new PostResponseDto(entity.getId(), entity.getTitle());
        return PostListResponseDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .build();
    }
}
