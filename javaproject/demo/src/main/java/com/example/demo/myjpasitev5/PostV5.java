package com.example.demo.myjpasitev5;

import com.example.demo.myjpasitev5.dto.PostUpdateRequestDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // JPA에서
//public class PostV5 {
public class PostV5 extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;
    private String content; // BaseTimeEntity
    private String author; // BaseTimeEntity


    @Builder
    public PostV5(String title, String content, String author) {
        // id는 DB에서 만들어 줌
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public PostV5 update(PostUpdateRequestDto requestDto) {

        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        return this;
    }
}
