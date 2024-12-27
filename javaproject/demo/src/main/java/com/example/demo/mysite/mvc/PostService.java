package com.example.demo.mysite.mvc;

import com.example.demo.mysite.Post;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PostService {

    private PostRepository postRepository = new PostRepository();


    // 컨트롤러에게서 데이터 입력 받는다
    public Post createPost(Post newPost) {
        // validation - 비즈니스 로직 처리
//        String title = newPost.getTitle();
//        String content = newPost.getContent();
//
//        if (title == null || title.isBlank()) {
//            throw new RuntimeException("title을 입력하시오.");
//        }
//
//        if (content == null || content.isBlank()) {
//            throw new IllegalArgumentException("content를 입력하시오.");
//        }
        validatePostData(newPost);
        // post 생성
        return postRepository.save(newPost);

    }

    public List<Post> readPosts(){
        return postRepository.findAll();
    }

    public Post readPostById(Long id){
        Post post = postRepository.findById(id);
//        if (Objects.isNull(post)) {
//            throw new IllegalArgumentException("없는 id입니다.");
//        }
        checkPostIsNull(post);
        return post;
    }

    public Post updatePost(Long id, Post updatePost) {
        Post post = postRepository.findById(id);
//        if (Objects.isNull(post)) {
//            throw new IllegalArgumentException("없는 id입니다.");
//        }
        checkPostIsNull(post);
        validatePostData(post);
        return postRepository.modify(id, updatePost);
    }

    public void checkPostIsNull(Post post){
        if(Objects.isNull(post)){
            throw new IllegalArgumentException("없는 id입니다");
        }
    }
    public void validatePostData(Post post ){
        String title = post.getTitle();
        String content = post.getContent();

        if (title == null || title.isBlank()) {
            throw new RuntimeException("title을 입력하시오.");
        }

        if (content == null || content.isBlank()) {
            throw new IllegalArgumentException("content를 입력하시오.");
        }
    }

    public boolean deletePost(Long id){
        Post post = postRepository.findById(id);
        checkPostIsNull(post);
        return postRepository.delete(post);
    }
}
