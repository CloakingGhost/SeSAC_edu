package com.example.relation.domain.post.dto;

import java.time.LocalDateTime;

public interface PostListWithCommentCountProjection {
    Long getId();
    String getTitle();
    LocalDateTime getCreatedAt();
    Long getCommentCount(); // Alias와 매핑

}
