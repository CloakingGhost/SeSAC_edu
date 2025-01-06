package com.example.demo.myjpasitev3;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor
public class PostJpaV3 {
    @Id // 기본키
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본기 생성방법(strategy: 전략)
    @Setter(AccessLevel.NONE)
    private Long id; // db에서 부여
    private String title;
    private String content;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    // title, content의 setter
    public PostJpaV3 update(String title, String content) {
        this.title = title;
        this.content = content;
        return this;
    }
}
