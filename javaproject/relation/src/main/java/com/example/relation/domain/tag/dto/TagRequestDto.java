package com.example.relation.domain.tag.dto;


import lombok.Getter;

@Getter
public class TagRequestDto {

    private String name;

    public Tag toEntity(){
        return Tag.builder()
                .name(name)
                .build();
    }
}
