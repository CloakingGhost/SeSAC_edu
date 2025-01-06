package com.example.demo.myjpasitev4.dto;

import com.example.demo.myjpasitev4.PostV4;
import jakarta.validation.constraints.*;
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

    public PostV4 toEntity() {
        return PostV4.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
