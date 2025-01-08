package com.example.relation.domain.post;

import com.example.relation.domain.comment.Comment;
import com.example.relation.domain.comment.CommentRepository;
import com.example.relation.domain.post.dto.*;
import com.example.relation.global.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;


    @Transactional
    public PostResponseDto createPost(PostCreateRequestDto requestDto) {
        Post post = postRepository.save(requestDto.toEntity());
        return PostResponseDto.from(post);
    }

    public List<PostListResponseDto> readPosts() {
        return postRepository.findAll().stream()
                .map(PostListResponseDto::from)
                .toList();
    }

    public PostWithCommentResponseDto readPostById(Long id) {
        Post post = postRepository.findById(id).orElseThrow(ResourceNotFoundException::new);

        List<Comment> comments = commentRepository.findByPostId(id);
        return PostWithCommentResponseDto.from(post, comments);
    }

    public PostWithCommentResponseDtoV2 readPostByIdV2(Long id){
//        post, comment를 한번에 가져오고 싶다.
        Post post = postRepository.findByIdWithComment(id).orElseThrow(ResourceNotFoundException::new);
        return PostWithCommentResponseDtoV2.from(post);
    }

    @Transactional
    public PostResponseDto updatePost(Long id, PostUpdateRequestDto requestDto) {
        Post post = postRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        post = post.update(requestDto);

        return PostResponseDto.from(post);
    }

    @Transactional
    public void deletePost(Long id) {
        Post post = postRepository.findById(id).orElseThrow(ResourceNotFoundException::new);

        postRepository.delete(post);
    }
}
