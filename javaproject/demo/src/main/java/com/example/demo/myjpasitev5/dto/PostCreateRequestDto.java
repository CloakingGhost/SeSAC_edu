package com.example.demo.myjpasitev5.dto;

import com.example.demo.myjpasitev4.PostV4;
import com.example.demo.myjpasitev5.PostV5;
import jakarta.validation.constraints.NotBlank;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

// title, content, author 받아
// Post를 만드는 역할을 수행
@Setter
@NoArgsConstructor // @RequestBody
public class PostCreateRequestDto {
    @NotBlank(message = "제목은 필수지요")
    @Length(max = 20, message = "길이는 20자 이하지요")
    private String title;

    @NotBlank
    @Length(min = 5)
    private String content;


    @Length(min = 2, max = 10)
    private String author;

    public PostV5 toEntity() {
        return PostV5.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
