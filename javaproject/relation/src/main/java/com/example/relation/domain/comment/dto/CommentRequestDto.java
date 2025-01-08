package com.example.relation.domain.comment.dto;

import com.example.relation.domain.comment.Comment;
import com.example.relation.domain.post.Post;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentRequestDto {

    @Column(nullable = false)
    @NotBlank
    private String content;

    public Comment toEntity(Post post){
        return Comment.builder()
                .content(content)
                .post(post)
                .build();
    }
}
