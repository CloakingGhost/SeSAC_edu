package com.example.demo.myjpasite;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceJpa {
    private final PostRepositoryJpa postRepositoryJpa;

    public PostServiceJpa(PostRepositoryJpa postRepository) {
        this.postRepositoryJpa = postRepository;
    }

    public PostJpa createPost(PostJpa postJpa) {
        return postRepositoryJpa.save(postJpa);
    }

    public List<PostJpa> readPosts() {
        return postRepositoryJpa.findAll();
    }

    public PostJpa readPostById(Long id) {
        return postRepositoryJpa.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("없는 \"id\" 입니다."));
    }

    public PostJpa updatePost(Long id, PostJpa updatedPost) {
        PostJpa post = readPostById(id);

        String title = updatedPost.getTitle();
        String content = updatedPost.getContent();
        post.update(title, content);

        return postRepositoryJpa.save(post);

//        return postRepositoryJpa.save(post.update(title, content));

    }
}
