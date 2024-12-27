package com.example.demo.mysite;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Post {
    private Long id;
    private String title;
    private String content;


}
