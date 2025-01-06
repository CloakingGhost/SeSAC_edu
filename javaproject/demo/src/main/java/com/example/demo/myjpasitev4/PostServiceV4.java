package com.example.demo.myjpasitev4;

import com.example.demo.myjpasitev4.dto.PostCreateRequestDto;
import com.example.demo.myjpasitev4.dto.PostListResponseDto;
import com.example.demo.myjpasitev4.dto.PostResponseDto;
import com.example.demo.myjpasitev4.dto.PostUpdateRequestDto;
import com.example.demo.myjpasitev4.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostServiceV4 {

    private final PostRepositoryV4 postRepositoryV4;

    @Transactional
    public PostResponseDto createPost(PostCreateRequestDto requestDto) {
//        requestDto -> Dto 변환
        PostV4 entityPost = requestDto.toEntity();
        // return에 엔티티를 직접 사용하지 않음
//        return postRepositoryV4.save(post);
        PostV4 post = postRepositoryV4.save(entityPost);
        return PostResponseDto.from(post);


    }

    public List<PostListResponseDto> readPosts() {
        List<PostV4> posts = postRepositoryV4.findAll();
        return posts.stream().map(PostListResponseDto::from).toList();

    }

    public PostResponseDto readPostById(Long id) {
        PostV4 post = postRepositoryV4.findById(id).orElseThrow(ResourceNotFoundException::new);
        return PostResponseDto.from(post);
    }

    @Transactional
    public PostResponseDto updatePost(Long id, PostUpdateRequestDto requestDto) {
        PostV4 post = postRepositoryV4.findById(id).orElseThrow(IllegalAccessError::new);
        post.update(requestDto);
        // dirty checking이 되어 수정만해도 반영 된다.
//        postRepositoryV4.save(post);
        return PostResponseDto.from(post);

    }

    @Transactional
    public void deletePost(Long id) {
        PostV4 post = postRepositoryV4.findById(id).orElseThrow(IllegalAccessError::new);
        postRepositoryV4.delete(post);

    }
}
