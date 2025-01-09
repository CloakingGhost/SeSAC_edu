package com.example.relation.domain.post.dto;

import com.example.relation.domain.post.entity.Post;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class PostWithCountCommentResponseDto {
    private Long id;
    private String title;

    private LocalDateTime createAt;

    private Long count;

    public static PostWithCountCommentResponseDto from(Post entity, Long count) {
        return PostWithCountCommentResponseDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .createAt(entity.getCreatedAt())
                .count(count)
                .build();
    }

}
