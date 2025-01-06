package com.example.demo.myjpasitev5.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

// title, content, author 받아
// Post를 만드는 역할을 수행
@Getter
@NoArgsConstructor // @RequestBody
public class PostUpdateRequestDto {
    private String title;
    private String content;

    // 새로운 엔티티를 만드는 것이 아니다
    // 기존에 있던 데이터를 수정한다
//    public PostV4 toEntity(){
//        return PostV4.builder()
//                .title(title)
//                .content(content)
//                .build();
//    }
}
