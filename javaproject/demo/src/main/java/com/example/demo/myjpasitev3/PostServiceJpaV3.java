package com.example.demo.myjpasitev3;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostServiceJpaV3 {
    private final PostRepositoryJpaV3 postRepositoryJpaV3;

    @Transactional
    public PostJpaV3 createPost(PostJpaV3 post) {
        return postRepositoryJpaV3.save(post);
    }

    public List<PostJpaV3> readPosts() {
        return postRepositoryJpaV3.findAll();
    }

    public PostJpaV3 readPostById(Long id) {
        return postRepositoryJpaV3.findById(id);
    }

    @Transactional
    public void delete(Long id) {
        PostJpaV3 post = postRepositoryJpaV3.findById(id);
        postRepositoryJpaV3.delete(post);

    }

    @Transactional
    public PostJpaV3 update(Long id, PostJpaV3 updatedPost) {
        PostJpaV3 post = postRepositoryJpaV3.findById(id);
        post.update(updatedPost.getTitle(), updatedPost.getContent());
        return postRepositoryJpaV3.save(post);

    }

}

