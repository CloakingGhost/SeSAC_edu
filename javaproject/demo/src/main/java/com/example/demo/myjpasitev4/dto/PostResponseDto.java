package com.example.demo.myjpasitev4.dto;

import com.example.demo.myjpasitev4.PostV4;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder // @AllArgsConstructor 자동 생성
public class PostResponseDto {
    private final Long id;

    private final String title;
    private final String content;
    private final String author;

    public static PostResponseDto from(PostV4 entity) {
//        return new PostResponseDto(entity.getId(), entity.getTitle(), entity.getContent(), entity.getAuthor());
        return PostResponseDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .content(entity.getContent())
                .author(entity.getAuthor())
                .build();
    }
}
