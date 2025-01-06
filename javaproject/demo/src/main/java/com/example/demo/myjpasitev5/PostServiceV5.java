package com.example.demo.myjpasitev5;

import com.example.demo.myjpasitev5.dto.PostCreateRequestDto;
import com.example.demo.myjpasitev5.dto.PostListResponseDto;
import com.example.demo.myjpasitev5.dto.PostResponseDto;
import com.example.demo.myjpasitev5.dto.PostUpdateRequestDto;
import com.example.demo.myjpasitev5.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostServiceV5 {

    private final PostRepositoryV5 postRepositoryV5;

    @Transactional
    public PostResponseDto createPost(PostCreateRequestDto requestDto) {
//        requestDto -> Dto 변환
        PostV5 entityPost = requestDto.toEntity();
        // return에 엔티티를 직접 사용하지 않음
//        return postRepositoryV4.save(post);
        PostV5 post = postRepositoryV5.save(entityPost);
        return PostResponseDto.from(post);


    }

    public List<PostListResponseDto> readPosts() {
        List<PostV5> posts = postRepositoryV5.findAll();
        return posts.stream().map(PostListResponseDto::from).toList();

    }

    public PostResponseDto readPostById(Long id) {
        PostV5 post = postRepositoryV5.findById(id).orElseThrow(ResourceNotFoundException::new);
        return PostResponseDto.from(post);
    }

    @Transactional
    public PostResponseDto updatePost(Long id, PostUpdateRequestDto requestDto) {
        PostV5 post = postRepositoryV5.findById(id).orElseThrow(IllegalAccessError::new);
        post.update(requestDto);
        // dirty checking이 되어 수정만해도 반영 된다.
//        postRepositoryV4.save(post);
        return PostResponseDto.from(post);

    }

    @Transactional
    public void deletePost(Long id) {
        PostV5 post = postRepositoryV5.findById(id).orElseThrow(IllegalAccessError::new);
        postRepositoryV5.delete(post);

    }
}
