package com.example.relation.domain.post.entity;

import com.example.relation.domain.comment.Comment;
import com.example.relation.domain.post.dto.PostUpdateRequestDto;
import com.example.relation.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String title;

    @Column(nullable = false)
    private String content;

    private String author;

    @Setter
    private String imageUrl;

    // 커맨트 들고 올 때 다 조회
    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY)
    private List<Comment> comments;

    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PostTag> postTags;

    @Builder
    public Post(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
        comments = new ArrayList<>(); // 초기화 안해서 에러 발생
        postTags = new ArrayList<>(); // 초기화 안해서 에러 발생
    }

    public Post update(PostUpdateRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        return this;
    }

}