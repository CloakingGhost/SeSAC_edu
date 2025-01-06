package com.example.demo.myjpasitev2;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceJpaV2 {
    private final PostRepositoryJpaV2 postRepositoryJpaV2;


    public PostJpaV2 createPost(PostJpaV2 postJpaV2) {
        return postRepositoryJpaV2.save(postJpaV2);
    }

    public List<PostJpaV2> readPosts() {
        return postRepositoryJpaV2.findAll();
    }

    public PostJpaV2 readPostById(Long id) {
        return postRepositoryJpaV2.findById(id);
    }

//    public PostJpaV2 updatePost(Long id, PostJpaV2 updatedPost) {
//        PostJpaV2 post = readPostById(id);
//
//        String title = updatedPost.getTitle();
//        String content = updatedPost.getContent();
//        post.update(title, content);
//
//        return postRepositoryJpaV2.save(post);
//
////        return postRepositoryJpa.save(post.update(title, content));

//    }
    public PostJpaV2 updatePost(Long id, PostJpaV2 updatedPost) {

        return postRepositoryJpaV2.update(id, updatedPost);

//        return postRepositoryJpa.save(post.update(title, content));

    }
    public void delete(Long id){
        postRepositoryJpaV2.delete(id);
    }

}
