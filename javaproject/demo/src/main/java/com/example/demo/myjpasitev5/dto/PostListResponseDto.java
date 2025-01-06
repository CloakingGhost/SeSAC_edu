package com.example.demo.myjpasitev5.dto;

import com.example.demo.myjpasitev4.PostV4;
import com.example.demo.myjpasitev5.PostV5;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder // @AllArgsConstructor 자동 생성
public class PostListResponseDto {
    private final Long id;


    private final String title;

    public static PostListResponseDto from(PostV5 entity) {
//        return new PostResponseDto(entity.getId(), entity.getTitle());
        return PostListResponseDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .build();
    }
}
